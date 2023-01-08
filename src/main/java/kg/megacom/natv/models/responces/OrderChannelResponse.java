package kg.megacom.natv.models.responces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class OrderChannelResponse {
    @JsonProperty(value = "channel_id")
    Long channelId;
    BigDecimal price;
    BigDecimal priceDiscount;
    int days;
//    @JsonProperty(value = "price_for_symbol")
//    int symbolPrice;

}
