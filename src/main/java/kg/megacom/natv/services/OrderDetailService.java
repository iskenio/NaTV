package kg.megacom.natv.services;

import kg.megacom.natv.models.dtos.OrderDetailDto;
import kg.megacom.natv.models.requests.ChannelReq;
import kg.megacom.natv.models.responces.OrderChannelResponse;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDetailService extends BaseService<OrderDetailDto> {
//    void orderChannelRequest(List<ChannelReq> channelReqList, int lang, String text);
    List<OrderChannelResponse> getOrderChannelResponse(List<ChannelReq> channelReq, int lang, String text);


}
