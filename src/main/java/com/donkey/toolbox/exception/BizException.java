package com.donkey.toolbox.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yuanxiang.fyx
 * @date 2021/06/15
 */
public class BizException extends RuntimeException{

    /**
     * ¥ÌŒÛ¬Î
     */
    private final ErrorCodeMsg codeMsg;

    /**
     * ∂ÓÕ‚¥ÌŒÛ–≈œ¢
     */
    private final String extraMessage;

    public BizException(ErrorCodeMsg codeMsg) {
        this(codeMsg,null,null);
    }
    public BizException(ErrorCodeMsg codeMsg, String extraMessage) {
        this(codeMsg,null,extraMessage);
    }

    public BizException(ErrorCodeMsg codeMsg,Throwable t) {
        this(codeMsg,t,null);
    }

    public BizException(ErrorCodeMsg codeMsg,Throwable t, String extraMessage) {
        super(StringUtils.isBlank(extraMessage) ? codeMsg.getMessage() : codeMsg.getMessage() + "-" + extraMessage,t);
        this.codeMsg = codeMsg;
        this.extraMessage = extraMessage;
    }

    public ErrorCodeMsg getCodeMsg() {
        return codeMsg;
    }

    public String getExtraMessage() {
        return extraMessage;
    }
}
