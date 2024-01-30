package gdsc.cau.alert.util.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiResponse<T> {

    private int code;
    private T data;
    private String msg;

    private static final int SUCCESS = 200;
    private static final int CREATED = 201;

    private ApiResponse(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(SUCCESS, data, message);
    }

    public static <T> ApiResponse<T> created(T data, String message) {
        return new ApiResponse<>(CREATED, data, message);
    }

    public static <T> ApiResponse<T> fail(ResponseCode responseCode, String message) {
        return new ApiResponse<>(responseCode.getHttpStatus().value(), null, message);
    }
}
