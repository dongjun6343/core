package hello.core.singleton;

public class SingletonService {


    // 1. static 영역에 객체를 딱 하나만 생성한다.
    private static final SingletonService instance = new SingletonService();


    //2. public 으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체를 생성 못하게 막는다.
    private SingletonService() {

    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    // 스프링 컨테이너에서는 객체를 생성하면 저절로 싱글톤으로 생성한다.

}
