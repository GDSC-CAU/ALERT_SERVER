package gdsc.cau.alert.util.api;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ResponseCode {

    // 400 Bad Request
    BAD_REQUEST(HttpStatus.BAD_REQUEST, false, "잘못된 요청입니다."),

    // 401 Unauthorized

    // 403 Forbidden
    FORBIDDEN(HttpStatus.FORBIDDEN, false, "권한이 없습니다."),

    // 404 Not Found
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, false, "사용자를 찾을 수 없습니다."),
    NOTIFICATION_NOT_FOUND(HttpStatus.NOT_FOUND, false, "알림을 찾을 수 없습니다."),
    ANIMAL_NOT_FOUND(HttpStatus.NOT_FOUND, false, "동물을 찾을 수 없습니다."),

    // 405 Method Not Allowed
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, false, "허용되지 않은 메소드입니다."),

    // 409 Conflict
    USER_ALREADY_EXISTS(HttpStatus.CONFLICT, false, "이미 존재하는 사용자입니다."),
    ANIMAL_ALREADY_EXISTS(HttpStatus.CONFLICT, false, "이미 존재하는 동물입니다."),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, "서버에 오류가 발생하였습니다."),

    // 200 OK
    USER_READ_SUCCESS(HttpStatus.OK, true, "사용자 조회 성공"),
    USER_UPDATE_SUCCESS(HttpStatus.OK, true, "사용자 수정 성공"),
    USER_DELETE_SUCCESS(HttpStatus.OK, true, "사용자 삭제 성공"),
    NOTIFICATION_READ_SUCCESS(HttpStatus.OK, true, "알림 조회 성공"),
    NOTIFICATION_DELETE_SUCCESS(HttpStatus.OK, true, "알림 수정 성공"),
    ANIMAL_READ_SUCCESS(HttpStatus.OK, true, "동물 조회 성공"),
    ANIMAL_CREATE_SUCCESS(HttpStatus.OK, true, "동물 생성 성공"),
    ANIMAL_UPDATE_SUCCESS(HttpStatus.OK, true, "동물 수정 성공"),
    ANIMAL_DELETE_SUCCESS(HttpStatus.OK, true, "동물 삭제 성공"),
    USER_LOGIN_SUCCESS(HttpStatus.OK, true, "사용자 로그인 성공"),
    USER_SIGNUP_SUCCESS(HttpStatus.OK, true, "사용자 회원가입 성공"),

    // 201 Created
    USER_CREATE_SUCCESS(HttpStatus.CREATED, true, "사용자 생성 성공");


    private final HttpStatus httpStatus;
    private final Boolean success;
    private final String message;
}
