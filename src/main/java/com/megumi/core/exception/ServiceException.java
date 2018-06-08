package com.megumi.core.exception;

/**
 *  业务层通用用Exception
 *
 * @author yuweilun
 * @date 2017/7/11
 */
public class ServiceException extends RuntimeException  {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
