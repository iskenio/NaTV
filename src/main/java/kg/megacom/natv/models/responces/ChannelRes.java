package kg.megacom.natv.models.responces;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.megacom.natv.models.entities.Discounts;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class ChannelRes {
    Long id;
    String name;
    String photo;
    BigDecimal price;
    @JsonProperty(value = "discount_min_days")
    List<DiscountMinDaysResponse> discountMinDaysResponses;
}
