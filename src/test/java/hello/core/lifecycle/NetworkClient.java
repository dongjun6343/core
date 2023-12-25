package hello.core.lifecycle;

public class NetworkClient {

    /**
     * 스프링 빈은 간단하게 다음과 같은 라이프스타일을 가진다.
     * 객체 생성 -> 의존관계 주입. (하지만, 생성자주입은 예외!)
     */

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }
}
