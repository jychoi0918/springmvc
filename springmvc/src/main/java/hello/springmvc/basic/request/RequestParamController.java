package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok param!");

    }
    @ResponseBody //(RequestController비슷! 바디에 콱 박아서!)
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge){

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";

    }

    @ResponseBody //(RequestController비슷! 바디에 콱 박아서!)
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){

        log.info("username={}, age={}", username, age);
        return "ok";

    }
    @ResponseBody //(RequestController비슷! 바디에 콱 박아서!)
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);
        return "ok";

    }

    @ResponseBody //(RequestController비슷! 바디에 콱 박아서!)
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            //기본 값이 true
        @RequestParam(required = true) String username,
        @RequestParam(required = false) Integer age){
    //기본형인 int는 null을 못 넣는다.

        log.info("username={}, age={}", username, age);
        return "ok";

    }
    @ResponseBody //(RequestController비슷! 바디에 콱 박아서!)
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            //기본 값이 true
        @RequestParam(required = true, defaultValue = "Stranger") String username,
        @RequestParam(required = false, defaultValue = "21") int age){
    //default value가 들어가면, required유무 상관이 없다


        log.info("username={}, age={}", username, age);
        return "ok";

    }
    @ResponseBody //(RequestController비슷! 바디에 콱 박아서!)
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){


        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";

    }
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttribute(@RequestParam String username, @RequestParam int age) {

        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "IT WORKs";
    }

  /*  @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

               log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "IT WORKs";
    }
*/

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
               log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "IT WORKs";
    }

}
