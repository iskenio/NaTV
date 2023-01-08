package kg.megacom.natv.models.responces.channel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelDiscountResponse {
    Long id;
    String name;
    String photo;
    Boolean status;
    @JsonProperty(value = "order_num")
    int orderNum;
}

