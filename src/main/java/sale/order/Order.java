package sale.order;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Order{
    private LocalDateTime date;
    private String companyName;
    private Integer price;

}
