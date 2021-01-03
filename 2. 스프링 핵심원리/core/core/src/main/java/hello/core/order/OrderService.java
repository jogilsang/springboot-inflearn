package hello.core.order;

/**
 * @author : user
 * @version : 1.0.0
 * @package : hello.core.order
 * @name : OrderService.java
 * @date : 2021-01-03 오후 9:12
 * @modifyed :
 **/

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
