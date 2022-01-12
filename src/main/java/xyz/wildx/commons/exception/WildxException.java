package xyz.wildx.commons.exception;

import lombok.Getter;

/**
 * wildx 自定义异常.
 *
 * @author wangbo
 * @date 2021/6/13
 */
@Getter
public class WildxException extends RuntimeException {
    /**
     * 自定义异常状态码信息
     */
    private int status;

    public WildxException(int status) {
        this.status = status;
    }

    public WildxException(int status, String message) {
        super(message);
        this.status = status;
    }

    public WildxException(int status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public WildxException(int status, Throwable cause) {
        super(cause);
        this.status = status;
    }
}