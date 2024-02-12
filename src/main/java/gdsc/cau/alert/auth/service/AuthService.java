package gdsc.cau.alert.auth.service;

import gdsc.cau.alert.auth.component.JwtTokenProvider;
import gdsc.cau.alert.auth.dto.ResponseJwtDto;
import gdsc.cau.alert.user.domain.User;
import gdsc.cau.alert.user.dto.CreateUserDto;
import gdsc.cau.alert.user.repository.UserRepository;
import gdsc.cau.alert.util.api.ResponseCode;
import gdsc.cau.alert.util.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입 여부 체크
    public boolean existsUserByUID(String uid) {
        return userRepository.existsUserByUid(uid);
    }

    // 회원가입 후 토큰 발급
    public ResponseJwtDto signUp(CreateUserDto dto) {
        User user = User.createUser(dto.getUserName(), dto.getUid(), dto.getAddress1(), dto.getAddress2(), dto.getType());
        Long id = userRepository.save(user).getId();
        return ResponseJwtDto.builder()
                .accessToken(jwtTokenProvider.createAccessToken(id.toString()))
                .build();
    }

    // 로그인 후 토큰 발급
    public ResponseJwtDto login(String uid) {
        User user = userRepository.findByUid(uid).orElseThrow(() -> new UserException(ResponseCode.USER_NOT_FOUND));
        return ResponseJwtDto.builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getId().toString()))
                .build();
    }
}
