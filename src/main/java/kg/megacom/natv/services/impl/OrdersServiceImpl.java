package kg.megacom.natv.services.impl;

import kg.megacom.natv.exceptions.SaveTroubleException;
import kg.megacom.natv.mappers.OrdersMapper;
import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.models.dtos.OrderDetailDto;
import kg.megacom.natv.models.dtos.OrdersDto;
import kg.megacom.natv.models.requests.ChannelReq;
import kg.megacom.natv.models.requests.OrderReq;
import kg.megacom.natv.models.responces.OrderChannelResponse;
import kg.megacom.natv.models.responces.OrderResponse;
import kg.megacom.natv.models.responces.orders.OrdersResponse;
import kg.megacom.natv.repositories.OrdersRepository;
import kg.megacom.natv.services.ChannelsService;
import kg.megacom.natv.services.DaysService;
import kg.megacom.natv.services.OrderDetailService;
import kg.megacom.natv.services.OrdersService;
import kg.megacom.natv.utils.ResourceBundle;
import kg.megacom.natv.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersRepository repository;
    @Autowired
    ChannelsService channelsService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    DaysService daysService;
    OrdersMapper mapper = OrdersMapper.INSTANCE;

    @Override
    public OrdersDto save(OrdersDto ordersDto) {
        return mapper.toDto(repository.save(mapper.toEntity(ordersDto)));
    }

    @Override
    public OrdersDto findById(Long id, int lang) {
        return OrdersMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("sdfsdf")));
    }

    @Override
    public List<OrdersDto> findAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public OrderResponse saveOrder(OrderReq orderRequest, int lang) throws SaveTroubleException{

        if(orderRequest.getText().isEmpty()){
            throw new SaveTroubleException(ResourceBundle.periodMessages(Language.getLang(lang),"textEmpExc"));
        }
        OrdersDto dto = new OrdersDto();
        OrderResponse orderResponse = getOrder(orderRequest, lang);
        OrdersDto orderDto;
        dto.setName(orderRequest.getName());
        dto.setEmail(orderRequest.getEmail());
        dto.setPhone(orderRequest.getPhone());
        dto.setText(orderRequest.getText());
        dto.setTotalPrice(orderResponse.getTotalPrice());
        dto.setPriceDiscount(orderResponse.getPriceDiscount());
        orderDto = save(dto);
        orderChannelRequest(orderRequest.getChannels(), orderDto.getId(), lang, dto.getText());

        OrderResponse getResponse = new OrderResponse();
        getResponse.setText(orderDto.getText());
        getResponse.setName(orderDto.getName());
        getResponse.setPhone(orderDto.getPhone());
        getResponse.setEmail(orderDto.getEmail());
        getResponse.setTotalPrice(orderDto.getTotalPrice());
        getResponse.setPriceDiscount(orderDto.getPriceDiscount());
        getResponse.setChannels(orderChannelRequest(orderRequest.getChannels(), orderDto.getId(), lang, dto.getText()));

        return getResponse;
    }

    @Override
    public OrderResponse getOrder(OrderReq request, int lang) {
        OrderResponse orderResponse = new OrderResponse();
        List<BigDecimal> total = new ArrayList<>();
        List<BigDecimal> dPrice = new ArrayList<>();
        var list = orderDetailService.getOrderChannelResponse(request.getChannels(), lang, request.getText());
        for (OrderChannelResponse item : list) {
            total.add(item.getPrice());
        }

        BigDecimal totalPrice = total.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        orderResponse.setTotalPrice(totalPrice);
        for (OrderChannelResponse item : list) {
            dPrice.add(item.getPriceDiscount());
        }
        BigDecimal priceDiscount = dPrice.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        orderResponse.setPriceDiscount(priceDiscount);

        return orderResponse;
    }


    @Override
    public List<OrderChannelResponse> orderChannelRequest(List<ChannelReq> channelReqList, Long orderID, int lang, String text) {
        List<OrderChannelResponse> channelResponses = orderDetailService.getOrderChannelResponse(channelReqList, lang, text);
        Map<Long, BigDecimal> discountPrice = new HashMap<>();
        for (var item : channelResponses) {
            discountPrice.put(item.getChannelId(), item.getPriceDiscount());
        }

        for (ChannelReq item : channelReqList) {
            OrderDetailDto orderDetailDto = new OrderDetailDto();
            orderDetailDto.setChannelId(channelsService.findById(item.getChannelId(), lang));
            orderDetailDto.setPrice(discountPrice.get(item.getChannelId()));
            orderDetailDto.setOrderId(OrdersDto.builder()
                    .id(orderID)
                    .build()
            );

            for (Date days : item.getDays()) {
                DaysDto daysDto = new DaysDto();
                daysDto.setOrderDetailId(orderDetailDto);
                daysDto.setDay(days);
                daysService.save(daysDto);
            }
            orderDetailService.save(orderDetailDto);
        }
        return channelResponses;
    }

}
