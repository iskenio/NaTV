package kg.megacom.natv.models.responces.orders;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrdersResponse {
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    List<ChannelsResponse> channelsResponseList;
}
