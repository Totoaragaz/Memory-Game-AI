package com.example.memorygameai.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GameController {

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
