package kg.megacom.natv.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelRequest {
    Long id;
    String name;
    String photo;
    Boolean status;
    @JsonProperty(value = "order_num")
    int orderNum;
}
