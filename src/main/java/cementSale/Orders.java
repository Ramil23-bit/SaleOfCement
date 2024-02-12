package cementSale;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Orders {
    private LocalDateTime date;
    private String nameCompany;
    private Integer orderPrice;


}
