package com.learn.dubbo.api.service;

import com.learn.dubbo.api.exception.LearnException;
import com.learn.dubbo.api.model.User;

/**
 * @author jingjing.zhang
 */
public interface UserService {
    /**
     * 根据用户Id查询用户信息
     * @param id
     * @return
     * @throws LearnException
     */
    default User findUserById(Long id) throws LearnException {
        throw new LearnException("interface state exception");
    }
}
