package kg.megacom.natv.models.responces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.nio.channels.Channel;
import java.util.List;

@Getter
@Setter
public class OrderResponse {
    @JsonProperty(value = "total_price")
    BigDecimal totalPrice;
    @JsonProperty(value = "discount_price")
    BigDecimal priceDiscount;
    List<OrderChannelResponse> channels;
}
