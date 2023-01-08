package kg.megacom.natv.services;

import kg.megacom.natv.models.dtos.PricesDto;

import java.math.BigDecimal;

public interface PriceService extends BaseService<PricesDto>{
    BigDecimal getChannelPrice(Long channelId);
}
