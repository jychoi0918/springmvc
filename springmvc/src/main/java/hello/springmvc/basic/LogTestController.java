package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogTestController {
        private final Logger log = LoggerFactory.getLogger(getClass());

        @RequestMapping("/log-test")
        public String logTest(){
            String name ="Spring";

            System.out.println("name = " + name);

            log.trace("trace log={}", name);
            log.debug("debug log={}", name);
            log.info("info log={}", name);
            log.warn("warn log={}", name);
            log.error("error log={}", name);

            return "Everything is Okay:)";
        }
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");

        return "ok :-)";
    }
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");

        return "ok :) ";
    }
    /**
     * PathVariable사용 가능
     * 변수명이 같으면 생략 가능
     *
     */
/*
    @GetMapping("/mapping/{userId}")
*/
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath userId={}", data);

        return "It's Ok";
     }
  /*  @GetMapping("/mapping/{data}")
    public String mappingPath(@PathVariable String data){
        log.info("mappingPath userId={}", data);

        return "It's Ok";
    }
*/

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");

        return "ok";
    }
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");

        return "ok";
    }
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");

        return "ok";
    }
}
