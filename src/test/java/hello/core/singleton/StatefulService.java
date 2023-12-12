package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 문제 발생 -> 스프링은 항상 무상태로 설계 해야한다.
//    }
//
//    public int getPrice() {
//        return price;
//    }

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

}
