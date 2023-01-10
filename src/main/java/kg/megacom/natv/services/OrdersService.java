package kg.megacom.natv.services;

import kg.megacom.natv.models.dtos.OrdersDto;
import kg.megacom.natv.models.requests.ChannelReq;
import kg.megacom.natv.models.requests.OrderReq;
import kg.megacom.natv.models.responces.OrderChannelResponse;
import kg.megacom.natv.models.responces.OrderResponse;
import kg.megacom.natv.models.responces.orders.OrdersResponse;

import java.util.List;

public interface OrdersService extends BaseService<OrdersDto> {
    OrderResponse saveOrder(OrderReq orderRequest, int lang);
    OrderResponse getOrder(OrderReq request, int lang);


    List<OrderChannelResponse> orderChannelRequest(List<ChannelReq> channelReqList, Long orderId, int lang, String text);
}
