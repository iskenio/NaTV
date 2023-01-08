package kg.megacom.natv.repositories;

import kg.megacom.natv.models.dtos.OrdersDto;
import kg.megacom.natv.models.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
