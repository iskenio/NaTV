package kg.megacom.natv.models.dtos;

import kg.megacom.natv.models.enums.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrdersDto {
    Long id;
    String text;
    String name;
    String phone;
    String email;
    BigDecimal totalPrice;
    BigDecimal priceDiscount;
    Date editDate;
    Date addDate;
    OrderStatus status;
}
