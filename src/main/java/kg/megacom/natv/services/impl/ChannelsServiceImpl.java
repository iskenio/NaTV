package kg.megacom.natv.services.impl;

import kg.megacom.natv.exceptions.EntityNotFoundExc;
import kg.megacom.natv.exceptions.SaveTroubleException;
import kg.megacom.natv.mappers.ChannelsMapper;
import kg.megacom.natv.microservices.FeignFileService;
import kg.megacom.natv.models.dtos.ChannelsDto;
import kg.megacom.natv.models.responces.ChannelRes;
import kg.megacom.natv.models.responces.channel.ChannelResponse;
import kg.megacom.natv.repositories.ChannelsRepository;
import kg.megacom.natv.services.ChannelsService;
import kg.megacom.natv.services.DiscountsService;
import kg.megacom.natv.utils.ResourceBundle;
import kg.megacom.natv.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelsServiceImpl implements ChannelsService {

    @Autowired
    ChannelsRepository repository;
    @Autowired
    private DiscountsService service;

    @Autowired
    FeignFileService feignFileService;
    ChannelsMapper mapper =ChannelsMapper.INSTANCE;

    @Override
    public ChannelsDto save(ChannelsDto channelsDto) throws SaveTroubleException{
        if (channelsDto.getPhoto().isEmpty() || channelsDto.getName().isEmpty())
            throw new SaveTroubleException("Поля не могут быть пустымы");
        if (repository.existByOrderNum(channelsDto.getOrderNum()))
            throw new SaveTroubleException("Такой номер заявки уже есть");
        return mapper.toDto(repository.save(mapper.toEntity(channelsDto)));
    }

    @Override
    public ChannelsDto findById(Long id, int lang) {
        Language language = Language.getLang(lang);
        return ChannelsMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(language, "channelNotFound"))));
    }

    @Override
    public List<ChannelsDto> findAll() {
        return ChannelsMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public List<ChannelResponse> channelResponse(){
        List<ChannelResponse> channelResponses = repository.channelResponse();
        return channelResponses;
    }

    @Override
    public List<ChannelRes> channelRes() {
        List<ChannelResponse> channelResponseList = channelResponse();
        List<ChannelRes> channelResList = new ArrayList<>();
        for (ChannelResponse item: channelResponseList){
            ChannelRes channelResp = new ChannelRes();
            channelResp.setId(item.getId());
            channelResp.setName(item.getName());
            channelResp.setPhoto(item.getPhoto());
            channelResp.setPrice(item.getPrice());
            channelResp.setDiscountMinDaysResponses(service.getDiscountChannels(item.getId()));
            channelResList.add(channelResp);
        }
        return channelResList;
    }

    @Override
    public ChannelsDto saveChannel(String name, MultipartFile photo, int orderNum) {
        ChannelsDto channelsDto = new ChannelsDto();
        channelsDto.setName(name);
        channelsDto.setPhoto(feignFileService.storeFile(photo).getDownloadUri());
        channelsDto.setOrderNum(orderNum);
        ChannelsDto dto = save(channelsDto);
        return dto;
    }
}
