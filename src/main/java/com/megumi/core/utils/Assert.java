package com.megumi.core.utils;

import com.megumi.core.exception.ServiceException;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 业务层断言类
 *
 * @author megumi
 * @date 2018/11/15
 */
public class Assert {

    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new ServiceException(message);
        }
    }

    public static void state(boolean expression, Object resultCodeVO) {
        if (!expression) {
            throw new ServiceException(resultCodeVO);
        }
    }


    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ServiceException(message);
        }
    }

    public static void isTrue(boolean expression, Object resultCodeVO) {
        if (!expression) {
            throw new ServiceException(resultCodeVO);
        }
    }

    public static void isNull(@Nullable Object object, String message) {
        if (object != null) {
            throw new ServiceException(message);
        }
    }

    public static void isNull(@Nullable Object object, Object resultCodeVO) {
        if (object != null) {
            throw new ServiceException(resultCodeVO);
        }
    }


    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new ServiceException(message);
        }
    }

    public static void notNull(@Nullable Object object, Object resultCodeVO) {
        if (object == null) {
            throw new ServiceException(resultCodeVO);
        }
    }

    public static void hasLength(@Nullable String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new ServiceException(message);
        }
    }

    public static void hasLength(@Nullable String text, Object resultCodeVO) {
        if (!StringUtils.hasLength(text)) {
            throw new ServiceException(resultCodeVO);
        }
    }


    public static void hasText(@Nullable String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new ServiceException(message);
        }
    }

    public static void hasText(@Nullable String text, Object resultCodeVO) {
        if (!StringUtils.hasText(text)) {
            throw new ServiceException(resultCodeVO);
        }
    }

    public static void notEmpty(@Nullable Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new ServiceException(message);
        }
    }

    public static void notEmpty(@Nullable Object[] array, Object resultCodeVO) {
        if (ObjectUtils.isEmpty(array)) {
            throw new ServiceException(resultCodeVO);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ServiceException(message);
        }
    }

    public static void notEmpty(@Nullable Collection<?> collection, Object resultCodeVO) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ServiceException(resultCodeVO);
        }
    }

    public static void notEmpty(@Nullable Map<?, ?> map, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new ServiceException(message);
        }
    }

    public static void notEmpty(@Nullable Map<?, ?> map, Object resultCodeVO) {
        if (CollectionUtils.isEmpty(map)) {
            throw new ServiceException(resultCodeVO);
        }
    }


}
