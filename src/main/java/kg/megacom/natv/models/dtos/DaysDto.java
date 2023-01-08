package kg.megacom.natv.models.dtos;

import kg.megacom.natv.models.entities.OrderDetail;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DaysDto {
    Long id;
    Date day;
    OrderDetailDto orderDetailId;
}
