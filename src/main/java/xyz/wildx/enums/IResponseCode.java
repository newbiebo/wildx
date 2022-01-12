package xyz.wildx.enums;

/**
 * 返回码接口,所有返回码类需要实现该接口
 *
 * 2000表示成功，其他均表示失败返回码
 * <p>
 *
 * @author wangbo
 */
public interface IResponseCode {

    /**
     * 返回码
     *
     * @return
     */
    int getCode();

    /**
     * 返回码对应的描述
     *
     * @return
     */
    String getMessage();

}
