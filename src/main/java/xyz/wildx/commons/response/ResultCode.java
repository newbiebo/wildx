package xyz.wildx.commons.response;

/**
 * 枚举了一些常用API操作码
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    COMMON_SUCCESS(200, "操作成功"),
    COMMON_FAILED(9999, "操作失败"),//通用错误码，返回文案可自定义
    COMMON_VALIDATE_FAILED(8888, "参数检验失败"),
    COMMON_UNAUTHORIZED(401, "暂未登录或token已经过期"),
    COMMON_FORBIDDEN(403, "没有相关权限"),
    TOKEN_INVALID(10300, "token失效"),
    /**
     * -----------------------3开头钉钉通知相关返回码-----------------------------
     */
    NOTIFY_USER_SUCCESS(301,"通知用户成功"),
    NOTIFY_USER_FAIL(399,"通知用户失败")
    ;
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
