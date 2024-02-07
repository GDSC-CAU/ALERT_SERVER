package gdsc.cau.alert.user.service;

import gdsc.cau.alert.user.dto.ResponseUserDto;
import gdsc.cau.alert.user.dto.ResponseUserNotificationDto;
import gdsc.cau.alert.user.dto.UpdateUserDto;

import java.util.List;

public interface UserService {

    // 회원정보 조회
    ResponseUserDto getUser(Long id);

    // 회원정보 수정
    void updateUser(Long id, UpdateUserDto dto);

    // 회원의 알림 조회
    List<ResponseUserNotificationDto> getUserNotification(Long id);

    // 회원의 알림 삭제
    void deleteUserNotification(Long id, Long notificationId);

    // 회원 탈퇴
    void deleteUser(Long id);
}
