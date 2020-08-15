package com.learn.dubbo.api.exception;

/**
 * @author jingjing.zhang
 */
public class LearnException extends Exception {
    private String code;
    private String message;

    public LearnException(String message) {
        this(null,message);
    }

    public LearnException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
