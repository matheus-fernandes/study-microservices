package com.study.microservices.user.service;

import com.study.microservices.user.valueobjects.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class DepartmentService {
    @Autowired
    private RestTemplate restTemplate;

    public Department findById(Long departmentId){
        try {
            log.info("DEPARTMENT REST SERVICE \"fetching department\"");

            String url = "http://DEPARTMENT-SERVICE/departments/";
            return restTemplate.getForObject(url + departmentId, Department.class);
        }catch (HttpClientErrorException e){
            log.error(e.getMessage());
            throw new ResponseStatusException(e.getStatusCode(), e.getMessage());
        }

    }
}
