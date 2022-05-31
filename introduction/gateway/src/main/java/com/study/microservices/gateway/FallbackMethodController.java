package com.study.microservices.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackMethodController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallBackMethod(){
        return "user service is taking longer than expected, please try again...";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallBackMethod(){
        return "department service is taking longer than expected, please try again...";
    }


}
