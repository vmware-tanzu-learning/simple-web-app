package com.vmware.tanzu.simplewebapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SimpleController {

    Logger logger = LoggerFactory.getLogger(SimpleController.class);

    @GetMapping("/")
    public String ok(@Value("${ok.message:OK}") String message) {
        logger.info("Requested /");
        return message;
    }

    @GetMapping("/hello")
    public String hello(@Value("${hello.message:Hello from the Simple Web App!}") String message) {
        logger.info("Requested /hello");
        return message;
    }

    @GetMapping("/env")
    public Map<String,String> env() {
        logger.info("Requested /env");
        return System.getenv();
    }

    @GetMapping("/echo")
    public String echoParam(@RequestParam String message) {
        logger.info("Requested /echo via GET");
        return message;
    }

    @PostMapping("/echo")
    public String echoBody(@RequestBody String body) {
        logger.info("Requested /echo via POST");
        return body;
    }

    @GetMapping("/status/{code}")
    public ResponseEntity<String> status(@PathVariable Integer code) {
        logger.info("Requested /status/" + code);
        return new ResponseEntity<>(HttpStatus.valueOf(code).getReasonPhrase(), HttpStatusCode.valueOf(code));
    }
}
