package com.yuanbao.park.common.resultUtils;

/**
 * 自定义错误码
 */
public enum MessageEnum {

    SUCCESS(1000,"成功"),
    FAILURE(9999,"失败"),

    PARMA_SPECIAL_CHAR(1001,"参数包含特殊字符"),
    PARMA_IS_EMPTY(1002,"参数为空"),
    PARMA_FORMAT_ERROR(1003,"参数格式错误"),

    ACCESS_TOKEN_ERROR(1004,"access_token 错误"),
    ACCESS_TOKEN_NOT_FOUND(1005,"access_token 已过期失效"),
    REFRESH_TOKEN_ERROR(1009,"refresh_token 无效"),
    REFRESH_TOKEN_EXPIRE(1010,"refresh_token 过期失效"),
    ACCESS_OUT_LIMITS(1006,"访问次数超限，请稍后再试"),
    PERMISSION_DENIED(1007,"权限不足"),

    SET_PRIVILEGE_FAIL(1008,"设置用户权限失败"),


    USER_NOT_EXIST(1011,"用户不存在"),
    PARMA_RANGE_ERROR(1012,"参数取值范围错误"),
    REDIS_OPERATION_FAIL(1013,"Redis 操作失败"),
    IP_INFO_ERROR(1014,"IP 地址错误"),
    USER_FREEZE(1015,"账号已冻结"),
    USER_NOT_FOLLOW_SELF(1016,"自己就不要关注自己啦"),
    USER_NOT_PRAISE_SELF(1017,"自己就不要点赞自己啦"),
    USER_NOT_VISIT_SELF(1018,"自己访问自己就不要保存啦"),
    USER_NOT_REMARK_SELF(1019,"自己就不需要备注啦"),
    VERIFY_CODE_ERROR(1020, "验证码错误"),
    REQUEST_WX_FAIL(1300,"请求微信接口失败"),
    REQUEST_WX_JM_FAIL(1301,"请求微信加密串不对，请重试"),





    UPLOAD_FILE_EMPTY(1990,"上传文件不能为空"),
    UPLOAD_FILE_FORMAT_EROOR(1991,"上传文件类型错误"),
    UPLOAD_FILE_TOOMAX(1992,"上传文件过大"),
    UPLOAD_FILE_ERROR(1993,"上传文件失败"),
    UPLOAD_FILE_FORMAT_ERROR(1994,"上传文件格式错误，请核对！"),
    UPLOAD_FILE_HAS_NULL_VALUE(1995,"上传文件内容有空值，请补全后上传！"),

    //用户
    USERNAME_OR_PASSWORD_ERROR(2000,"用户名或密码错误"),
    THIS_USER_IS_FREEZED(2001,"用户被冻结，请联系管理员"),
    USER_HAS_NO_MENU(2001,"用户没有绑定菜单，请联系管理员"),
    UUID_ERROR(2003,"用户uuid错误"),
    USERNAME_IS_EXIST(2005,"用户名已存在"),
    USERNAME_IS_NOT_CHINESE(2020,"用户名不能是中文"),
    USERPHOTO_IS_EMPTY(2021,"用户头像不能为空"),
    PHONE_FORMAT_ERROR(2006,"手机号格式错误"),
    PHONE_NOT_EXIST(2007,"手机号不存在"),
    PHONE_IS_EMPTY(2008,"手机号为空"),
    PHONE_IS_EXIST(2009,"手机号已存在"),

    VERIFY_CODE_FAIL(2010,"手机验证码错误"),

    PASSWORD_FORMAT_ERROR(2011,"密码格式错误"),
    PASSWORD_IS_ERROR(2012,"密码错误"),
    PASSWORD_IS_EMPTY(2013,"密码为空"),
    PAYPWD_FORMAT_ERROR(2014,"支付密码格式错误"),


    BIRTHDAY_FORMAT_ERROR(2015,"生日格式错误"),
    SEX_FORMAT_ERROR(2016,"性别格式错误"),
    INVITATION_CODE_ERROR(2017,"无效的推荐码"),

    POLICY_MARK_EMPTY(3000,"没有选择标签"),


    NEWPASS_FORMAT_ERROR(2016,"新密码格式错误"),
    NEWPASS_IS_ERROR(2017,"新密码错误"),
    NEWPASS_IS_EMPTY(2018,"新密码为空"),
    IDCARD_IS_ERROR(2019,"身份证号不合法"),
    IDCARD_REALNAME_ERROR(2020,"身份证号真实姓名不对"),
    DATE_IS_ERROR(2021,"日期格式错误"),

    MQ_SEND_FAIL(5000,"消息队列发送失败"),

    FUND_ACCOUNT_BALANCE_ERROR(4002,"帐户余额不足"),

    PERMISSIONS_MISSING(5000,"不是管理员或该信息创建人无法操作"),

    GET_SERVER_IP_ERROR(9992,"无法获取服务器IP！") ,
    PLEASE_REPLY(9993,"请重试！") ,
    TEMPLATE_ERROR(9994,"velocity template_执行错误") ,
    DATABASE_ERROR(9995,"db操作异常") ,
    SIGN_ERROR(9996,"接口签名错误") ,
    SYSTEM_INTERNAL_ERROR(9997,"系统异常") ,
    SYSTEM_UNKNOWN_ERROR(9998,"系统未知异常") ,




    ;

    MessageEnum(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    private int code;
    private String desc;
    public int getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }




}
