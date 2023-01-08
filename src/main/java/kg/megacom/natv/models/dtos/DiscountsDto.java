package kg.megacom.natv.models.dtos;

import kg.megacom.natv.models.entities.Channels;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountsDto {
    Long id;
    int percent;
    Date startDate;
    Date endDate;
    int minDays;
    ChannelsDto channelId;
}
