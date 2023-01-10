package kg.megacom.natv.mappers;

import kg.megacom.natv.models.dtos.ChannelsDto;
import kg.megacom.natv.models.entities.Channels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//public class ChannelsMapperTest {
//    //public static void assertEquals (ChannelsDto channelsDto, Channels channels);
//    ChannelsMapper channelsMapper = new ChannelsMapperImpl();
//    @Test
//    void testChannelMapperToDto(){
//        Channels channel = new Channels();
//        channel.setId(1l);
//        channel.setName("НТС");
//
//        ChannelsDto channelsDto = channelsMapper.toDto(channel);
//        Assertions.assertEquals(channelsDto.getId(), channel.getId());
//        Assertions.assertEquals(channelsDto.getName(), channel.getName());
//    }
//
//    @Test
//    void testChannelMapperToEntity(){
//        ChannelsDto channelsDto = new ChannelsDto();
//        channelsDto.setId(1l);
//        channelsDto.setName("312");
//        Channels channels = channelsMapper.toEntity(channelsDto);
//
//        Assertions.assertEquals(1l, channelsDto.getId());
//        Assertions.assertEquals(channels.getName(), "312");
//    }
//
////    @Test
////    void testChannelMapperToDtos(){
////        List<Channels> channelsList = new ArrayList<>();
////        Channels channel = new Channels();
////        channel.setId(1l);
////        channel.setName("1канал");
////        channelsList.add(channel);
////        ChannelsDto channelsDto
////    }
//}
