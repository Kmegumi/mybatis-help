package com.megumi.core.exception;

/**
 *  乐观锁用Exception
 *
 * @author yuweilun
 * @date 2017/10/9
 */
public class LockException extends RuntimeException {

    public LockException() {
        super();
    }

    public LockException(String message) {
        super(message);
    }

    public LockException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockException(Throwable cause) {
        super(cause);
    }

}
