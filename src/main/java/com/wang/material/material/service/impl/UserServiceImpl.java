package com.wang.material.material.service.impl;

import com.wang.material.material.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public void test() {
        log.info("hello");
    }
}
