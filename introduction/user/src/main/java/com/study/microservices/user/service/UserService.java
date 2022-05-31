package com.study.microservices.user.service;

import com.study.microservices.user.entity.User;
import com.study.microservices.user.exception.UserNotFoundException;
import com.study.microservices.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User save(User user) {
        logInfo("saving user");
        return repository.save(user);
    }

    public User findById(Long userId) {
        logInfo("finding user");

        Optional<User> mayUser =
                repository.findById(userId);

        if (mayUser.isEmpty()){
            throw new UserNotFoundException();
        }

        return mayUser.get();
    }

    private void logInfo(String info){
        log.info("USER SERVICE \"" + info + "\"");
    }
}
