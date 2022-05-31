package com.study.microservice.department.service;

import com.study.microservice.department.entity.Department;
import com.study.microservice.department.exception.DepartmentNotFoundException;
import com.study.microservice.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department save(Department department) {
        logInfo("saving department");
        return repository.save(department);
    }


    public Department findById(Long departmentId) {
        logInfo("finding by id");

        Optional<Department> mayDepartment =
                repository.findById(departmentId);

        if (mayDepartment.isEmpty()){
            throw new DepartmentNotFoundException();
        }

        return mayDepartment.get();
    }

    private void logInfo(String info){
        log.info("DEPARTMENT SERVICE \"" + info + "\"");
    }
}
