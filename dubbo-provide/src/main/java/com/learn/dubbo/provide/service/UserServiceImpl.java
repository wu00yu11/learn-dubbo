package com.learn.dubbo.provide.service;

import com.learn.dubbo.api.exception.LearnException;
import com.learn.dubbo.api.model.User;
import com.learn.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author jingjing.zhang
 */
@Component
@Service(loadbalance = "random",cluster = "failsafe")
public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(Long id) throws LearnException {
        return new User("zhangsan","zhongshanglu",29);
    }
}
