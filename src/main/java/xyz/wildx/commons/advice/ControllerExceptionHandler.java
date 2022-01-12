package xyz.wildx.commons.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import xyz.wildx.commons.exception.WildxException;
/**
 * wildx 全局异常处理.
 *
 * @author wangbo
 * @date 2021/6/13
 */
//表示所有的被扫描到的controller都有效，表示controller中所有的方法，相当于给所有的方法写了try
//service抛出异常向上抛出本应被虚拟机捕获，但是这里使用注解捕获并做处理
@ControllerAdvice
public class ControllerExceptionHandler {

    //配合上面注解使用，相当于catch
    @ExceptionHandler(WildxException.class)
    public ResponseEntity<String> handlerException(WildxException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

}
