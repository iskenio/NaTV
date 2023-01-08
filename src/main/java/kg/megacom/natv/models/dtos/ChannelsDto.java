package kg.megacom.natv.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelsDto {
    Long id;
    String name;
    String photo;
    Boolean status;
    int orderNum;
}
