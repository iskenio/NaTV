package kg.megacom.natv.models.responces.channel;

import java.math.BigDecimal;

public interface ChannelResponse {
    Long getId();
    String getName();
    String getPhoto();
    BigDecimal getPrice();
}
