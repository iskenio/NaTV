package kg.megacom.natv.repositories;

import kg.megacom.natv.models.entities.Discounts;
import kg.megacom.natv.models.responces.DiscountMinDaysResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountsRepository extends JpaRepository<Discounts, Long> {
    @Query(value = "select d.min_days as minDays, d.percent from tb_discount d where d.channel_id=?1", nativeQuery = true)
    List<DiscountMinDaysResponse> getDiscountChannels(Long channelId);

}
