package com.vmware.tanzu.simplewebapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SimpleController {

    @GetMapping("/")
    public String ok() {
        return "OK";
    }

    @GetMapping("/hello")
    public String hello(@Value("${greeting.message:Hello from the Simple Web App!}") String message) {
        return message;
    }

    @GetMapping("/env")
    public Map<String,String> env() {
        return System.getenv();
    }

    @GetMapping("/echo")
    public String echoParam(@RequestParam String message) {
        return message;
    }

    @PostMapping("/echo")
    public String echoBody(@RequestBody String body) {
        return body;
    }
}
