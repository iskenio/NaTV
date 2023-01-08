package kg.megacom.natv.models.entities;

import kg.megacom.natv.models.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_order")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String text;
    String name;
    String phone;
    String email;
    @Column(name = "total_price")
    Double totalPrice;
    @Column(name = "discount_price")
    BigDecimal priceDiscount;
    @Column(name = "edit_date")
    Date editDate;
    @Column(name = "add_date")
    Date addDate;
    OrderStatus status;

    @PrePersist
    protected void onCreate(){
        status = OrderStatus.ACTIVE;
        editDate = new Date();
        addDate = new Date();
    }

}
