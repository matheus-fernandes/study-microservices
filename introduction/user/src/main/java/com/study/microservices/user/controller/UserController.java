package com.study.microservices.user.controller;

import com.study.microservices.user.entity.User;
import com.study.microservices.user.service.DepartmentService;
import com.study.microservices.user.service.UserService;
import com.study.microservices.user.valueobjects.Department;
import com.study.microservices.user.valueobjects.UserWithDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        logInfo("saving user");
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public UserWithDepartment getUserWithDepartment(@PathVariable("userId") Long userId){
        logInfo("getting user with department");

        User user = userService.findById(userId);
        Department department = departmentService.findById(user.getDepartmentId());

        return new UserWithDepartment(user, department);
    }

    private void logInfo(String info){
        log.info("USER CONTROLLER \"" + info + "\"");
    }
}
