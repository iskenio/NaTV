package kg.megacom.natv.services;

import kg.megacom.natv.models.dtos.ChannelsDto;
import kg.megacom.natv.models.responces.ChannelRes;
import kg.megacom.natv.models.responces.channel.ChannelResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ChannelsService extends BaseService<ChannelsDto>{
    List<ChannelResponse> channelResponse(int page, int size);
    List<ChannelRes> channelRes(int page, int size);
    ChannelsDto saveChannel(String name, MultipartFile photo, int orderNum);
}
