package com.donkey.toolbox.validate;

import com.donkey.toolbox.exception.BizException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

import java.util.Collection;
import java.util.Map;

import static com.donkey.toolbox.exception.CommonErrorCodeMsg.PARAM_ERROR;
import static com.donkey.toolbox.exception.CommonErrorCodeMsg.UNSUPPORT_OPERATION_ERROR;
import static com.donkey.toolbox.validate.ValidateUtils.Operation.GE;
import static com.donkey.toolbox.validate.ValidateUtils.Operation.GT;
import static com.donkey.toolbox.validate.ValidateUtils.Operation.LE;
import static com.donkey.toolbox.validate.ValidateUtils.Operation.LT;

/**
 * @author yuanxiang.fyx
 * @date 2021/06/15
 */
public class ValidateUtils {

    public static void isTrue(final boolean expression) {
        isTrue(expression,null);
    }

    public static void isTrue(final boolean expression, final String message, Object... values) {
        if (!expression) {
            throw new BizException(PARAM_ERROR, MessageFormatter.arrayFormat(message,values).getMessage());
        }
    }

    public static <T> T notNull(final T object) {
        return notNull(object,null);
    }

    public static <T> T notNull(final T object, final String message, final Object... values) {
        isTrue(object != null,message,values);
        return object;
    }

    public static String notBlank(final String str) {
        return notBlank(str,  null);
    }

    public static String notBlank(final String str, final String message, final Object... values) {
        isTrue(StringUtils.isNotBlank(str),message,values);
        return str;
    }

    // notEmpty array
    //---------------------------------------------------------------------------------

    public static <T> T[] notEmpty(final T[] array) {
        return notEmpty(array,null);
    }

    public static <T> T[] notEmpty(final T[] array, final String message, final Object... values) {
        isTrue(array != null || array.length > 0,message,values);
        return array;
    }

    // notEmpty collection
    //---------------------------------------------------------------------------------

    public static <T extends Collection<?>> T notEmpty(final T collection) {
        return notEmpty(collection,  null);
    }

    public static <T extends Collection<?>> T notEmpty(final T collection, final String message, final Object... values) {
        isTrue(CollectionUtils.isNotEmpty(collection),message,values);
        return collection;
    }

    // notEmpty map
    //---------------------------------------------------------------------------------

    public static <T extends Map<?, ?>> T notEmpty(final T map) {
        return notEmpty(map,null);
    }

    public static <T extends Map<?, ?>> T notEmpty(final T map, final String message, final Object... values) {
        isTrue(MapUtils.isNotEmpty(map),message,values);
        return map;
    }

    public static <T extends Object> void equals(final T t1, final T t2) {
        isTrue(t1.equals(t2),null);
    }

    public static <T extends Object> void equals(final T t1, final T t2, final String message, final Object... values) {
        isTrue(t1.equals(t2),message,values);
    }

    //gtZero
    //---------------------------------------------------------------------------------

    public static void gtZero(final Long value) {
        gtZero(value,null);
    }

    public static void gtZero(final Long value, final String message, final Object... values) {
        isTrue(value != null && value > 0,message,values);
    }

    public static void gtZero(final Integer value) {
        gtZero(value,null);
    }

    public static void gtZero(final Integer value, final String message, final Object... values) {
        isTrue(value != null && value > 0,message,values);
    }


    public static <T extends Number> void gt(final T value1, final T value2) {
       gt(value1,value2,null);
    }

    public static <T extends Number> void gt(final T value1, final T value2, final String message, final Object... values) {
        compare(value1,value2, GT,message,values);
    }

    public static <T extends Number> void lt(final T value1, final T value2) {
        gt(value1,value2,null);
    }

    public static <T extends Number> void lt(final T value1, final T value2, final String message, final Object... values) {
        compare(value1,value2, LT,message,values);
    }

    public static <T extends Number> void ge(final T value1, final T value2) {
        gt(value1,value2,null);
    }

    public static <T extends Number> void ge(final T value1, final T value2, final String message, final Object... values) {
        compare(value1,value2, GE,message,values);
    }

    public static <T extends Number> void le(final T value1, final T value2) {
        gt(value1,value2,null);
    }

    public static <T extends Number> void le(final T value1, final T value2, final String message, final Object... values) {
        compare(value1,value2, LE,message,values);
    }

    private static <T extends Number> void compare(final T value1, final T value2,Operation operation, final String message, final Object... values) {
        isTrue(value1 != null && value2 != null,message,values);
        if (value1 instanceof Integer && value2 instanceof Integer){
            switch (operation){
                case GT:isTrue(value1.intValue() > value2.intValue(),message,values);
                    break;
                case GE:isTrue(value1.intValue() >= value2.intValue(),message,values);
                    break;
                case LT:isTrue(value1.intValue() < value2.intValue(),message,values);
                    break;
                case LE:isTrue(value1.intValue() <= value2.intValue(),message,values);
                    break;
            }
        }else if (value1 instanceof Long && value2 instanceof Long){
            switch (operation){
                case GT:isTrue(value1.longValue() > value2.longValue(),message,values);
                    break;
                case GE:isTrue(value1.longValue() >= value2.longValue(),message,values);
                    break;
                case LT:isTrue(value1.longValue() < value2.longValue(),message,values);
                    break;
                case LE:isTrue(value1.longValue() <= value2.longValue(),message,values);
                    break;
            }
        }else {
            throw new BizException(UNSUPPORT_OPERATION_ERROR);
        }
    }
    
    public static void main(String[] args){
        gt(2,1);
    }

    enum Operation{
        GT,GE,LT,LE
    }
}
