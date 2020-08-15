package com.learn.dubbo.consumer.controller;

import com.learn.dubbo.api.exception.LearnException;
import com.learn.dubbo.api.model.User;
import com.learn.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingjing.zhang
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Value("${user.name}")
    String userName;
    @Value("${user.addr}")
    String addr;
    @Reference(loadbalance = "roundrobin", cluster = "failfast", check = false)
    private UserService userService;

    @PostMapping("/getUser")
    public User getUser(Long id) {
        try {
            logger.info("userName : {}, addr : {}",userName,addr);
            return userService.findUserById(id);
        } catch (LearnException e) {
            logger.error("LearnException",e);
        }
        return null;
    }

}
