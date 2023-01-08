package kg.megacom.natv.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ChannelReq {
    @JsonProperty(value = "channel_id")
    Long channelId;
    List<Date> days;
}
