package kg.megacom.natv.services.impl;

import kg.megacom.natv.mappers.DiscountMapper;
import kg.megacom.natv.models.dtos.DiscountsDto;
import kg.megacom.natv.models.responces.DiscountMinDaysResponse;
import kg.megacom.natv.repositories.DiscountsRepository;
import kg.megacom.natv.services.DiscountsService;
import kg.megacom.natv.utils.ResourceBundle;
import kg.megacom.natv.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountsServiceImpl implements DiscountsService {
    @Autowired
    DiscountsRepository repository;
    DiscountMapper mapper = DiscountMapper.INSTANCE;
    @Override
    public DiscountsDto save(DiscountsDto discountsDto) {

        return mapper.toDto(repository.save(mapper.toEntity(discountsDto)));
    }

    @Override
    public DiscountsDto findById(Long id, int lang) {
        return DiscountMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException(ResourceBundle.periodMessages(Language.getLang(lang), "notFound"))));

    }

    @Override
    public List<DiscountsDto> findAll() {
        return DiscountMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public List<DiscountMinDaysResponse> getDiscountChannels(Long channelId) {
        return repository.getDiscountChannels(channelId);
    }
}
