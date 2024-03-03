package sale.order;

import java.util.List;

public interface OrderAdapter {
   List<Order> toOrders(List<String> listString);
}
