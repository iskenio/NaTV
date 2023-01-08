package kg.megacom.natv.mappers;

import kg.megacom.natv.models.dtos.ChannelsDto;
import kg.megacom.natv.models.entities.Channels;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.jpa.repository.JpaRepository;
@Mapper
public interface ChannelsMapper extends BaseMapper<Channels, ChannelsDto> {
    ChannelsMapper INSTANCE = Mappers.getMapper(ChannelsMapper.class);
}
