package kg.megacom.natv.services.impl;

import kg.megacom.natv.exceptions.EntityNotFoundExc;
import kg.megacom.natv.mappers.OrderDetailMapper;
import kg.megacom.natv.models.dtos.*;
import kg.megacom.natv.models.requests.ChannelReq;
import kg.megacom.natv.models.requests.OrderReq;
import kg.megacom.natv.models.responces.OrderChannelResponse;
import kg.megacom.natv.models.responces.OrderResponse;
import kg.megacom.natv.repositories.OrderDetailRepository;
import kg.megacom.natv.services.*;
import kg.megacom.natv.utils.ResourceBundle;
import kg.megacom.natv.utils.models.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.lang.Integer.valueOf;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository repository;
//    @Autowired
//    ChannelsService channelsService;
    @Autowired
    PriceService priceService;
    @Autowired
    DiscountsService discountsService;


    OrderDetailMapper mapper = OrderDetailMapper.INSTANCE;
    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        return mapper.toDto(repository.save(mapper.toEntity(orderDetailDto)));
    }

    @Override
    public OrderDetailDto findById(Long id, int lang) {
        return OrderDetailMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new EntityNotFoundExc(ResourceBundle.periodMessages(Language.getLang(lang), "notFound"))));
    }

    @Override
    public List<OrderDetailDto> findAll() {
        return OrderDetailMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public List<OrderChannelResponse> getOrderChannelResponse(List<ChannelReq> channelReq, int lang, String text) {
        List<OrderChannelResponse> orderChannelResponses = new ArrayList<>();
        List<ChannelReq> channelReqList = channelReq;


        for (ChannelReq item: channelReqList) {
            OrderChannelResponse response = new OrderChannelResponse();
            PricesDto dto = new PricesDto();
            response.setChannelId(item.getChannelId());
            response.setDays(item.getDays().size());
            dto.setPrice(priceService.getChannelPrice(item.getChannelId()));

            char[] charArr = text.toCharArray();
            int count = 0;
            for (int i = 0; i < charArr.length; i++) {
                if (Character.isSpaceChar(charArr[i]))
                    continue;
                count++;
                System.out.println(count);
            }

            BigDecimal myCount = BigDecimal.valueOf(count);
            BigDecimal myDays = BigDecimal.valueOf(response.getDays());
            BigDecimal result = myCount.multiply(myDays).multiply(dto.getPrice());
            response.setPrice(result);

            BigDecimal hundred = new BigDecimal(100);
            BigDecimal ten = new BigDecimal(10);
            BigDecimal fifteen = new BigDecimal(15);
            BigDecimal five = new BigDecimal(5);
            if (!discountsService.getDiscountChannels(response.getChannelId()).isEmpty()) {
                if (response.getDays() >= 3 && response.getDays() <= 5)
                    response.setPriceDiscount(response.getPrice().subtract(response.getPrice().multiply(five).divide(hundred)));
                    else if (response.getDays() > 5 && response.getDays() < 9)
                        response.setPriceDiscount(response.getPrice().subtract(response.getPrice().multiply(ten).divide(hundred)));
                        else if (response.getDays() > 10)
                            response.setPriceDiscount(response.getPrice().subtract(response.getPrice().multiply(fifteen).divide(hundred)));

                 else response.setPriceDiscount(result);
            }orderChannelResponses.add(response);
        }
        return orderChannelResponses;
    }
}
