package com.anjotics.anjotics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// This is a REST controller that handles GET requests to the /greeting endpoint
@RestController
@RequestMapping("/greeting")
public class helloWorldController {
    // This method handles GET requests to the /greeting/hello endpoint
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world!";
    }
}
