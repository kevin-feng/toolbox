package com.donkey.toolbox.exception;

/**
 * @author yuanxiang.fyx
 * @date 2021/06/15
 */
public enum CommonErrorCodeMsg implements ErrorCodeMsg {
    /**
     * 通用错误
     */
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),
    PARAM_ERROR("PARAM_ERROR", "参数错误"),
    ILLEGAL_STATE_ERROR("ILLEGAL_STATE_ERROR","非法状态错误"),
    UNSUPPORT_OPERATION_ERROR("UNSUPPORT_OPERATION_ERROR","不支持的操作"),

    /**
     * 调用下游系统错误，fail为下游返回success=false，error为下游抛出异常
     */
    SYSTEM_INVOKE_FAIL("SYSTEM_INVOKE_FAIL","系统调用失败"),
    SYSTEM_INVOKE_ERROR("SYSTEM_INVOKE_ERROR","系统调用错误"),

    /**
     * 分布式锁
     */
    GET_LOCK_ERROR("GET_LOCK_ERROR", "获取锁失败"),

    /**
     * 限流
     */
    FLOW_BLOCKED_ERROR("FLOW_BLOCKED_ERROR", "限流异常"),

    /**
     * DB错误
     */
    DB_QUERY_ERROR("DB_QUERY_ERROR","数据库查询错误"),
    DB_INSERT_ERROR("DB_INSERT_ERROR","数据库插入错误"),
    DB_UPDATE_ERROR("DB_UPDATE_ERROR","数据库更新错误"),
    DB_DUPLICATE_KEY_ERROR("DB_DUPLICATE_KEY_ERROR", "数据库唯一键重复错误"),
    DB_GET_SEQUENCE_ID_ERROR("DB_GET_SEQUENCE_ID_ERROR","数据库获取sequenceId错误"),
    DB_OPTIMISM_LOCK_ERROR("DB_OPTIMISM_LOCK_ERROR","数据库乐观锁错误"),


    /**
     * 缓存
     */
    CACHE_GET_ERROR("CACHE_GET_ERROR", "查询缓存异常"),
    CACHE_PUT_ERROR("CACHE_PUT_ERROR", "缓存写入异常"),
    CACHE_SERIAL_ERROR("CACHE_SERIAL_ERROR", "缓存序列化异常"),
    CACHE_LOCAL_GET_ERROR("CACHE_LOCAL_GET_ERROR", "查询本地缓存异常"),

    /**
     * igraph，fail为下游返回success=false，error为下游抛出异常
     */
    IGRAPH_SEARCH_FAIL("IGRAPH_SEARCH_FAIL","igraph查询失败"),
    IGRAPH_SEARCH_ERROR("IGRAPH_SEARCH_ERROR","igraph查询错误"),

    /**
     * 消息
     */
    METAQ_SEND_ERROR("METAQ_SEND_ERROR", "消息发送异常"),
    METAQ_CONSUME_ERROR("METAQ_CONSUME_ERROR", "消息消费异常"),

    /**
     * 安全错误
     */
    MTEE_ERROR("MTEE_ERROR","安全校验不通过"),

    /**
     * 枚举
     */
    ENUM_VALUE_ILLEGAL("ENUM_VALUE_ILLEGAL","枚举值非法")
    ;
    private final String code;
    private final String message;;

    CommonErrorCodeMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
