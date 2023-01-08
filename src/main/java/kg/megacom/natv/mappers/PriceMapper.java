package kg.megacom.natv.mappers;

import kg.megacom.natv.models.dtos.PricesDto;
import kg.megacom.natv.models.entities.Prices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PriceMapper extends BaseMapper<Prices, PricesDto> {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
}
