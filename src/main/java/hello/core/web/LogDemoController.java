package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    // private final MyLogger myLogger; // request 요청이 올때 생성됨. -> 따라서 서버를 올릴때 에러!
//    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest reqeust) throws InterruptedException {

        String requestURL = reqeust.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setReqeustURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}
