package xyz.wildx.commons.response;

/**
 * 通用返回对象
 * Created by macro on 2019/4/19.
 */
public class ResultModel<T> {
    private long code;
    private String message;
    private T data;

    protected ResultModel() {
    }

    public ResultModel(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultModel<T> success(T data) {
        return new ResultModel<T>(ResultCode.COMMON_SUCCESS.getCode(), ResultCode.COMMON_SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResultModel<T> success(T data, String message) {
        return new ResultModel<T>(ResultCode.COMMON_SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResultModel<T> failed(IErrorCode errorCode) {
        return new ResultModel<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }


    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> ResultModel<T> failed(IErrorCode errorCode, String message) {
        return new ResultModel<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultModel<T> failed(String message) {
        return new ResultModel<T>(ResultCode.COMMON_FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultModel<T> failedByException(long code, String message) {
        return new ResultModel<T>(code, message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultModel<T> failed() {
        return failed(ResultCode.COMMON_FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultModel<T> validateFailed() {
        return failed(ResultCode.COMMON_VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResultModel<T> validateFailed(String message) {
        return new ResultModel<T>(ResultCode.COMMON_VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResultModel<T> unauthorized(T data) {
        return new ResultModel<T>(ResultCode.COMMON_UNAUTHORIZED.getCode(), ResultCode.COMMON_UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultModel<T> forbidden(T data) {
        return new ResultModel<T>(ResultCode.COMMON_FORBIDDEN.getCode(), ResultCode.COMMON_FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
