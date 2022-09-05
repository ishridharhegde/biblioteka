package com.shridhar.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication @RestController @ComponentScan(basePackageClasses = DemoApplication.class) public class DemoApplication {

    static Logger log = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/testLog") public String testLog() {
        log.info("This is a test info log message!");
        return "This is just a page";
    }

}
