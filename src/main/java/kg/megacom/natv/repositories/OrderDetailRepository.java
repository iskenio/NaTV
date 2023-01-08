package kg.megacom.natv.repositories;

import kg.megacom.natv.models.dtos.OrderDetailDto;
import kg.megacom.natv.models.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
