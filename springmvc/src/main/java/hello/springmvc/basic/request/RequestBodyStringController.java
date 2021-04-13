package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v4")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);


        response.getWriter().write("Ok");
    }
    //어우 위에 http로 받고 지저분에 깨끗이 하고 싶어!
    //저번에 사용할 수 있는 것중 inputStream을 사용가능한 것을 보앗잖아!
    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException{
       String messageBody= StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);


        responseWriter.write("Ok");
    }

    //@RequestBody 어노테이션
    @ResponseBody
    @PostMapping("/request-body-string-v3")
    public String requestBodyStringV3(@RequestBody String messageBody) throws IOException{
                                                  //RequestEntity
        log.info("messageBody={}", messageBody);
        return "ok";
                                //("ok", HttpStatus.CREATED) :이런식으로 상태코드 알려줄 수 있음
        //마치 http를 직접 주고 받은것과 같은 것!
    }



}
