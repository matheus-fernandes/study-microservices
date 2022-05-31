package com.study.microservice.department.controller;

import com.study.microservice.department.entity.Department;
import com.study.microservice.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("/")
    public Department save(@RequestBody Department department){
        logInfo("saving department ...");
        return service.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long departmentId){
        logInfo("finding by id");
        return service.findById(departmentId);
    }

    private void logInfo(String info){
        log.info("DEPARTMENT CONTROLLER \"" + info + "\"");
    }
}
