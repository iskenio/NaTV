package kg.megacom.natv.mappers;

import kg.megacom.natv.models.dtos.OrdersDto;
import kg.megacom.natv.models.entities.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface OrdersMapper extends BaseMapper<Orders, OrdersDto>{
    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);
}
