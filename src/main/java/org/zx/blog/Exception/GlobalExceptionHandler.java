package org.zx.blog.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zx.blog.common.lang.Result;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result otherException(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());
        return Result.fail(e.getMessage());

    }
}
