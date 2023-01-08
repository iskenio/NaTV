package kg.megacom.natv.services;

import kg.megacom.natv.models.dtos.DiscountsDto;
import kg.megacom.natv.models.entities.Discounts;
import kg.megacom.natv.models.responces.DiscountMinDaysResponse;

import java.util.List;

public interface DiscountsService extends BaseService<DiscountsDto> {
    List<DiscountMinDaysResponse> getDiscountChannels(Long channelId);
}
