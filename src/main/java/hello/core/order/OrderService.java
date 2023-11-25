package hello.core.order;

public interface OrderService {

    /**
     * 회원 조회 후 할인 적용
     */
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
