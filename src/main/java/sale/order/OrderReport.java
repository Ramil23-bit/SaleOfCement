package sale.order;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class OrderReport {
    private String companyName;
    private Integer price;

    @Override
    public String toString() {
        return companyName +
                " - " +
                price + "\n";
    }
}
