package com.yuanbao.park.common.resultUtils;

/**
 * @author: CrazyZhou
 * @description: 全局的异常消息与异常提示code
 * @date: 2018-07-04 13:44
 * @param:
 */
public class Message {
    public static final String SUCCESS = "成功";

    public static final String SUCCESS_CODE = "1000";

    public static final String FAILURE = "失败";

    public static final String FAILURE_CODE = "9999";

    public static final String PARMA_SPECIAL_CHAR = "参数包含特殊字符";

    public static final String PARMA_SPECIAL_CHAR_CODE = "1001";

    public static final String PARMA_IS_EMPTY = "参数为空";

    public static final String PARMA_IS_EMPTY_CODE = "1002";

    public static final String PARMA_FORMAT_ERROR = "参数格式错误";

    public static final String PARMA_FORMAT_ERROR_CODE = "1003";

    public static final String ACCESS_TOKEN_ERROR = "access_token 错误";

    public static final String ACCESS_TOKEN_ERROR_CODE = "1004";

    public static final String ACCESS_TOKEN_NOT_FOUND = "access_token 已过期失效";

    public static final String ACCESS_TOKEN_NOT_FOUND_CODE = "1005";

    public static final String REFRESH_TOKEN_ERROR = "refresh_token 无效";

    public static final String REFRESH_TOKEN_ERROR_CODE = "1009";

    public static final String REFRESH_TOKEN_EXPIRE = "refresh_token 过期失效";

    public static final String REFRESH_TOKEN_EXPIRE_CODE = "1010";

    public static final String ACCESS_OUT_LIMITS = "访问次数超限，请稍后再试";

    public static final String ACCESS_OUT_LIMITS_CODE = "1006";

    public static final String PERMISSION_DENIED = "权限不足";

    public static final String PERMISSION_DENIED_CODE = "1007";

    public static final String SET_PRIVILEGE_FAIL = "设置用户权限失败";

    public static final String SET_PRIVILEGE_FAIL_CODE = "1008";

    public static final String USER_NOT_EXIST = "用户不存在";

    public static final String USER_NOT_EXIST_CODE = "1011";

    public static final String PARMA_RANGE_ERROR = "参数取值范围错误";

    public static final String PARMA_RANGE_ERROR_CODE = "1012";

    public static final String REDIS_OPERATION_FAIL = "Redis 操作失败";

    public static final String REDIS_OPERATION_FAIL_CODE = "1013";

    public static final String IP_INFO_ERROR = "IP 地址错误";

    public static final String IP_INFO_ERROR_CODE = "1014";

    public static final String USER_FREEZE = "账号已冻结";

    public static final String USER_FREEZE_CODE = "1015";

    public static final String USER_NOT_FOLLOW_SELF = "自己就不要关注自己啦";

    public static final String USER_NOT_FOLLOW_SELF_CODE = "1016";

    public static final String USER_NOT_PRAISE_SELF = "自己就不要点赞自己啦";

    public static final String USER_NOT_PRAISE_SELF_CODE = "1017";

    public static final String USER_NOT_VISIT_SELF = "自己访问自己就不要保存啦";

    public static final String USER_NOT_VISIT_SELF_CODE = "1018";

    public static final String USER_NOT_REMARK_SELF = "自己就不需要备注啦";

    public static final String USER_NOT_REMARK_SELF_CODE = "1019";

    public static final String VERIFY_CODE_ERROR = "验证码错误";

    public static final String VERIFY_CODE_ERROR_CODE = "1020";

    public static final String REQUEST_WX_FAIL = "请求微信接口失败";

    public static final String REQUEST_WX_FAIL_CODE = "1300";

    public static final String REQUEST_WX_JM_FAIL = "请求微信加密串不对，请重试";

    public static final String REQUEST_WX_JM_FAIL_CODE = "1301";

    public static final String UPLOAD_FILE_EMPTY = "上传文件不能为空";

    public static final String UPLOAD_FILE_EMPTY_CODE = "1990";

    public static final String UPLOAD_FILE_FORMAT_EROOR = "上传文件类型错误";

    public static final String UPLOAD_FILE_FORMAT_EROOR_CODE = "1991";

    public static final String UPLOAD_FILE_TOOMAX = "上传文件过大";

    public static final String UPLOAD_FILE_TOOMAX_CODE = "1992";

    public static final String UPLOAD_FILE_ERROR = "上传文件失败";

    public static final String UPLOAD_FILE_ERROR_CODE = "1993";

    public static final String UPLOAD_FILE_FORMAT_ERROR = "上传文件格式错误，请核对！";

    public static final String UPLOAD_FILE_FORMAT_ERROR_CODE = "1994";

    public static final String UPLOAD_FILE_HAS_NULL_VALUE = "上传文件内容有空值，请补全后上传！";

    public static final String UPLOAD_FILE_HAS_NULL_VALUE_CODE = "1995";

    public static final String USERNAME_OR_PASSWORD_ERROR = "用户名或密码错误";
    public static final String USERNAME_OR_PASSWORD_ERROR_CODE = "2000";
    public static final String THIS_USER_IS_FREEZED = "用户被冻结，请联系管理员";
    public static final String THIS_USER_IS_FREEZED_CODE = "2001";
    public static final String USER_HAS_NO_MENU = "用户没有绑定菜单，请联系管理员";
    public static final String USER_HAS_NO_MENU_CODE = "2001";
    public static final String UUID_ERROR = "用户uuid错误";
    public static final String UUID_ERROR_CODE = "2003";
    public static final String USERNAME_IS_EXIST = "用户名已存在";
    public static final String USERNAME_IS_EXIST_CODE = "2005";
    public static final String USERNAME_IS_NOT_CHINESE = "用户名不能是中文";
    public static final String USERNAME_IS_NOT_CHINESE_CODE = "2020";
    public static final String USERPHOTO_IS_EMPTY = "用户头像不能为空";
    public static final String USERPHOTO_IS_EMPTY_CODE = "2021";
    public static final String PHONE_FORMAT_ERROR = "手机号格式错误";
    public static final String PHONE_FORMAT_ERROR_CODE = "2006";
    public static final String PHONE_NOT_EXIST = "手机号不存在";
    public static final String PHONE_NOT_EXIST_CODE = "2007";
    public static final String PHONE_IS_EMPTY = "手机号为空";
    public static final String PHONE_IS_EMPTY_CODE = "2008";
    public static final String PHONE_IS_EXIST = "手机号已存在";
    public static final String PHONE_IS_EXIST_CODE = "2009";
    public static final String VERIFY_CODE_FAIL = "手机验证码错误";
    public static final String VERIFY_CODE_FAIL_CODE = "2010";
    public static final String PASSWORD_FORMAT_ERROR = "密码格式错误";
    public static final String PASSWORD_FORMAT_ERROR_CODE = "2011";
    public static final String PASSWORD_IS_ERROR = "密码错误";
    public static final String PASSWORD_IS_ERROR_CODE = "2012";
    public static final String PASSWORD_IS_EMPTY = "密码为空";
    public static final String PASSWORD_IS_EMPTY_CODE = "2013";
    public static final String PAYPWD_FORMAT_ERROR = "支付密码格式错误";
    public static final String PAYPWD_FORMAT_ERROR_CODE = "2014";
    public static final String BIRTHDAY_FORMAT_ERROR = "生日格式错误";
    public static final String BIRTHDAY_FORMAT_ERROR_CODE = "2015";
    public static final String SEX_FORMAT_ERROR = "性别格式错误";
    public static final String SEX_FORMAT_ERROR_CODE = "2016";
    public static final String INVITATION_CODE_ERROR = "无效的推荐码";
    public static final String INVITATION_CODE_ERROR_CODE = "2017";
    public static final String POLICY_MARK_EMPTY = "没有选择标签";
    public static final String POLICY_MARK_EMPTY_CODE = "3000";
    public static final String NEWPASS_FORMAT_ERROR = "新密码格式错误";
    public static final String NEWPASS_FORMAT_ERROR_CODE = "2016";
    public static final String NEWPASS_IS_ERROR = "新密码错误";
    public static final String NEWPASS_IS_ERROR_CODE = "2017";
    public static final String NEWPASS_IS_EMPTY = "新密码为空";
    public static final String NEWPASS_IS_EMPTY_CODE = "2018";
    public static final String IDCARD_IS_ERROR = "身份证号不合法";
    public static final String IDCARD_IS_ERROR_CODE = "2019";
    public static final String IDCARD_REALNAME_ERROR = "身份证号真实姓名不对";
    public static final String IDCARD_REALNAME_ERROR_CODE = "2020";
    public static final String DATE_IS_ERROR = "日期格式错误";
    public static final String DATE_IS_ERROR_CODE = "2021";
    public static final String MQ_SEND_FAIL = "消息队列发送失败";
    public static final String MQ_SEND_FAIL_CODE = "5000";
    public static final String FUND_ACCOUNT_BALANCE_ERROR = "帐户余额不足";
    public static final String FUND_ACCOUNT_BALANCE_ERROR_CODE = "4002";
    public static final String PERMISSIONS_MISSING = "不是管理员或该信息创建人无法操作";
    public static final String PERMISSIONS_MISSING_CODE = "5000";
    public static final String GET_SERVER_IP_ERROR = "无法获取服务器IP";
    public static final String GET_SERVER_IP_ERROR_CODE = "9992";
    public static final String PLEASE_REPLY = "请重试！";
    public static final String PLEASE_REPLY_CODE = "9993";
    public static final String TEMPLATE_ERROR = "velocity template_执行错误";
    public static final String TEMPLATE_ERROR_CODE = "9994";
    public static final String DATABASE_ERROR = "db操作异常";
    public static final String DATABASE_ERROR_CODE = "9995";
    public static final String SIGN_ERROR = "接口签名错误";
    public static final String SIGN_ERROR_CODE = "9996";
    public static final String SYSTEM_INTERNAL_ERROR = "系统异常";
    public static final String SYSTEM_INTERNAL_ERROR_CODE = "9997";
    public static final String SYSTEM_UNKNOWN_ERROR = "系统未知异常";
    public static final String SYSTEM_UNKNOWN_ERROR_CODE = "9998";

    public static final String COMPANY_IS_EXIST = "公司名已存在!!!";

    public static final String COMPANY_IS_EXIST_CODE = "111111";

    public static final String COMPANY_IS_NOT_EXIST = "公司名不存在";

    public static final String COMPANY_IS_NOT_EXIST_CODE = "000000";

}
