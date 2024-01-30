package gdsc.cau.alert.util.exception;

import gdsc.cau.alert.util.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ApiResponse<Void> handleUserException(UserException e) {
        log.info("UserException: {}", e.getMessage());
        return ApiResponse.fail(e.getResponseCode(), null);
    }

    @ExceptionHandler(PostException.class)
    public ApiResponse<Void> handlePostException(PostException e) {
        log.info("PostException: {}", e.getMessage());
        return ApiResponse.fail(e.getResponseCode(), null);
    }
}
