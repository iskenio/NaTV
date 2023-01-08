package kg.megacom.natv.models.dtos;

import kg.megacom.natv.models.entities.Channels;
import kg.megacom.natv.models.entities.Orders;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailDto {
    Long id;
    BigDecimal price;
    ChannelsDto channelId;
    OrdersDto orderId;
}
