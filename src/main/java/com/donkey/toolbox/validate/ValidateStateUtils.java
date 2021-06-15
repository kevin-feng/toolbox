package com.donkey.toolbox.validate;

import com.donkey.toolbox.exception.BizException;
import com.donkey.toolbox.exception.ErrorCodeMsg;
import org.slf4j.helpers.MessageFormatter;

import static com.donkey.toolbox.exception.CommonErrorCodeMsg.ILLEGAL_STATE_ERROR;

/**
 * @author yuanxiang.fyx
 * @date 2021/06/15
 */
public class ValidateStateUtils extends ValidateUtils {

    public static void isTrue(final boolean expression, final ErrorCodeMsg code) {
        isTrue(expression,code,null);
    }

    public static void isTrue(final boolean expression, final ErrorCodeMsg code, final String message, Object... values) {
        if (!expression) {
            throw new BizException(ILLEGAL_STATE_ERROR, MessageFormatter.arrayFormat(message,values).getMessage());
        }
    }
}
