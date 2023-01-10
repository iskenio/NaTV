package kg.megacom.natv.models.responces.orders;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class ChannelsResponse {
    Long channelId;
    BigDecimal price;
    List<Date> days;
}
