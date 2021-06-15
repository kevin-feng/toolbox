package com.donkey.toolbox.exception;

/**
 * @author yuanxiang.fyx
 * @date 2021/06/15
 */
public enum CommonErrorCodeMsg implements ErrorCodeMsg {
    /**
     * ͨ�ô���
     */
    SYSTEM_ERROR("SYSTEM_ERROR", "ϵͳ����"),
    PARAM_ERROR("PARAM_ERROR", "��������"),
    ILLEGAL_STATE_ERROR("ILLEGAL_STATE_ERROR","�Ƿ�״̬����"),
    UNSUPPORT_OPERATION_ERROR("UNSUPPORT_OPERATION_ERROR","��֧�ֵĲ���"),

    /**
     * ��������ϵͳ����failΪ���η���success=false��errorΪ�����׳��쳣
     */
    SYSTEM_INVOKE_FAIL("SYSTEM_INVOKE_FAIL","ϵͳ����ʧ��"),
    SYSTEM_INVOKE_ERROR("SYSTEM_INVOKE_ERROR","ϵͳ���ô���"),

    /**
     * �ֲ�ʽ��
     */
    GET_LOCK_ERROR("GET_LOCK_ERROR", "��ȡ��ʧ��"),

    /**
     * ����
     */
    FLOW_BLOCKED_ERROR("FLOW_BLOCKED_ERROR", "�����쳣"),

    /**
     * DB����
     */
    DB_QUERY_ERROR("DB_QUERY_ERROR","���ݿ��ѯ����"),
    DB_INSERT_ERROR("DB_INSERT_ERROR","���ݿ�������"),
    DB_UPDATE_ERROR("DB_UPDATE_ERROR","���ݿ���´���"),
    DB_DUPLICATE_KEY_ERROR("DB_DUPLICATE_KEY_ERROR", "���ݿ�Ψһ���ظ�����"),
    DB_GET_SEQUENCE_ID_ERROR("DB_GET_SEQUENCE_ID_ERROR","���ݿ��ȡsequenceId����"),
    DB_OPTIMISM_LOCK_ERROR("DB_OPTIMISM_LOCK_ERROR","���ݿ��ֹ�������"),


    /**
     * ����
     */
    CACHE_GET_ERROR("CACHE_GET_ERROR", "��ѯ�����쳣"),
    CACHE_PUT_ERROR("CACHE_PUT_ERROR", "����д���쳣"),
    CACHE_SERIAL_ERROR("CACHE_SERIAL_ERROR", "�������л��쳣"),
    CACHE_LOCAL_GET_ERROR("CACHE_LOCAL_GET_ERROR", "��ѯ���ػ����쳣"),

    /**
     * igraph��failΪ���η���success=false��errorΪ�����׳��쳣
     */
    IGRAPH_SEARCH_FAIL("IGRAPH_SEARCH_FAIL","igraph��ѯʧ��"),
    IGRAPH_SEARCH_ERROR("IGRAPH_SEARCH_ERROR","igraph��ѯ����"),

    /**
     * ��Ϣ
     */
    METAQ_SEND_ERROR("METAQ_SEND_ERROR", "��Ϣ�����쳣"),
    METAQ_CONSUME_ERROR("METAQ_CONSUME_ERROR", "��Ϣ�����쳣"),

    /**
     * ��ȫ����
     */
    MTEE_ERROR("MTEE_ERROR","��ȫУ�鲻ͨ��"),

    /**
     * ö��
     */
    ENUM_VALUE_ILLEGAL("ENUM_VALUE_ILLEGAL","ö��ֵ�Ƿ�")
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
