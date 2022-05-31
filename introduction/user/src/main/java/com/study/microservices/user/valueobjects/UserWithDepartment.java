package com.study.microservices.user.valueobjects;

import com.study.microservices.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithDepartment {
    private User user;
    private Department department;
}
