package kg.megacom.natv.mappers;

import kg.megacom.natv.models.dtos.DaysDto;
import kg.megacom.natv.models.entities.Days;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DaysMapper extends BaseMapper<Days, DaysDto>{
    DaysMapper INSTANCE = Mappers.getMapper(DaysMapper.class);
}
