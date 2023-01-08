package kg.megacom.natv.mappers;

import kg.megacom.natv.models.dtos.DiscountsDto;
import kg.megacom.natv.models.entities.Discounts;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DiscountMapper extends BaseMapper<Discounts, DiscountsDto>{
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);
}
