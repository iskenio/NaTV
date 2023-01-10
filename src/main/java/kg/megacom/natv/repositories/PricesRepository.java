package kg.megacom.natv.repositories;

import kg.megacom.natv.models.dtos.PricesDto;
import kg.megacom.natv.models.entities.Prices;
import kg.megacom.natv.models.requests.ChannelReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {
    @Query(value = "select price from tb_price where channel_id = ?1", nativeQuery = true)
    BigDecimal getChannelPrice(Long channelId);


}
