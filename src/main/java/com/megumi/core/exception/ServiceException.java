package com.megumi.core.exception;

/**
 *  业务层通用用Exception
 *
 * @author yuweilun
 * @date 2017/7/11
 */
public class ServiceException extends RuntimeException  {

    private Object object;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Object object) {
        super();
        this.object = object;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        if (object == null) {
            return super.getMessage();
        }
        return object.toString() + "->" + super.getMessage();
    }
}
