package gdsc.cau.alert.auth.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import gdsc.cau.alert.auth.dto.ResponseJwtDto;
import gdsc.cau.alert.auth.service.AuthService;
import gdsc.cau.alert.user.dto.CreateUserDto;
import gdsc.cau.alert.util.api.ApiResponse;
import gdsc.cau.alert.util.api.ResponseCode;
import gdsc.cau.alert.util.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;
    private final FirebaseAuth firebaseAuth;

    // 로그인
    @PostMapping("/login")
    public ApiResponse<ResponseJwtDto> login(@RequestHeader String authToken) throws FirebaseAuthException {
        String uid = firebaseAuth.verifyIdToken(authToken).getUid();
        if (!authService.existsUserByUID(uid)) { // 가입되어 있지 않다면 신규 회원가입 요구
            throw new UserException(ResponseCode.USER_NOT_FOUND);
        }
        return ApiResponse.success(authService.login(uid), ResponseCode.USER_LOGIN_SUCCESS.getMessage());
    }

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<ResponseJwtDto> signUp(@RequestHeader String authToken, @RequestBody CreateUserDto dto) throws FirebaseAuthException {
        String uid = firebaseAuth.verifyIdToken(authToken).getUid();
        if (authService.existsUserByUID(uid)) { // 가입되어 있지 않다면 신규 회원가입 요구
            throw new UserException(ResponseCode.USER_ALREADY_EXISTS);
        }
        return ApiResponse.success(authService.signUp(dto), ResponseCode.USER_CREATE_SUCCESS.getMessage());
    }
}
