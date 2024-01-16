package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String reqeustURL;

    public void setReqeustURL(String reqeustURL) {
        this.reqeustURL = reqeustURL;
    }

    public void log(String message) {
        System.out.println("uuid = " + uuid + ", requestURL = " + reqeustURL + ", messge = " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("MyLogger.init");
        System.out.println("uuid = " + uuid + ", this = " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("MyLogger.close");
        System.out.println("this = " + this);
    }
}
