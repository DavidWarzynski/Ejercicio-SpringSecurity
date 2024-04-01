package es.neesis.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello_user")
    public String helloUser() {
        return "hello_user";
    }

    @GetMapping("/hello_admin")
    public String helloAdmin() {
        return "hello_admin";
    }
}
