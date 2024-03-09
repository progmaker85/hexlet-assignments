package exercise.controller;

import exercise.daytime.Daytime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    private Daytime daytime;

    @GetMapping
    public String index() {
        return "It is " + daytime.getName() + " now! Welcome to Spring";
    }
}
// END
