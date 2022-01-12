package xyz.wildx.enums;

public enum ResponseCode implements IResponseCode{
    /***登录成功返回码*/
    SUCCESS(2000, "成功"),
    /***用户token失效*/
    TOKEN_INVALID(1001, "用户token失效"),
    /***账号或密码错误*/
    ACCOUNT_OR_PWD_ERROR(1002, "账号或密码错误"),
    /***密码格式错误*/
    PASSWORD_FORMAT_INVALID(1003, "密码格式错误"),
    /***用户token不允许为空*/
    TOKEN_NOT_NULL(1005, "用户token不允许为空"),
    /***参数错误*/
    PARAM_ERROR(1006, "参数错误"),
    /***没有权限*/
    PERMISSION_DENIED(1007, "暂无权限，拒绝访问"),
    /***该用户已存在*/
    USER_ALREADY_EXISTS(1008,"该用户已存在"),
    /***对象不存在*/
    OBJECT_IS_NULL(2003, "对象不存在"),
    /***更新失败，用户是否存在 */
    FLUSH_NICK_NAME_FAIL(2004, "更新失败，确认用户是否存在"),

    /***系统异常*/
    SYSTEM_ERROR(5000, "系统异常");

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
