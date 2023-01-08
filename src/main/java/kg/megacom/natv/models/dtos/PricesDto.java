package kg.megacom.natv.models.dtos;

import kg.megacom.natv.models.entities.Channels;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PricesDto {
    Long id;
    Date startDate;
    Date endDate;
    BigDecimal price;
    ChannelsDto channelId;

}
