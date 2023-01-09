package kg.megacom.natv.repositories;

import kg.megacom.natv.models.entities.Channels;
import kg.megacom.natv.models.responces.channel.ChannelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelsRepository extends JpaRepository<Channels, Long> {
//    @Query(value = "select c.id, c.name, c.photo, p.price from tb_channels c join tb_price p on c.id = p.channel_id order by c.order_num asc limit 3", nativeQuery = true)
//    List<ChannelResponse> channelResponse();

    @Query(value = "select c.id, c.name, c.photo, p.price from tb_channels c join tb_price p on c.id = p.channel_id order by c.order_num asc limit ?2 offset ?1*?2", nativeQuery = true)
    List<ChannelResponse> channelResponse(int page, int size);

    //Проверка на повторяющиеся номера заявки
    @Query(value = "select (count(c)>0) from tb_channels c where c.order_num = ?1", nativeQuery = true)
    boolean existByOrderNum(int orderNum);
}
