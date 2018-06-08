package com.megumi.core.exception;

/**
 *  dao层通用Exception
 *
 * @author yuweilun
 * @date 2017/5/10
 */
public class DAOException extends RuntimeException {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

}
