package main.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot";
    }

//    @RequestMapping("/hello")
//    public String sayHello() {
//        return "Hello World";
//    }

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {
        if(name != null) {
            return "Hello " + name;
        }
        else{
            return  "Hello World";
        }
    }

    @RequestMapping(value = "/personalData", method = RequestMethod.POST)
    public String persistPerson(@RequestParam(value = "data") String data) {
        return data;
    }
}
