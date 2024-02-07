package gdsc.cau.alert.user.controller;

import gdsc.cau.alert.user.dto.ResponseUserDto;
import gdsc.cau.alert.user.dto.ResponseUserNotificationDto;
import gdsc.cau.alert.user.dto.UpdateUserDto;
import gdsc.cau.alert.user.service.UserService;
import gdsc.cau.alert.util.api.ApiResponse;
import gdsc.cau.alert.util.api.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 회원정보 조회
    @GetMapping
    public ApiResponse<ResponseUserDto> getUser(Long id) {
        return ApiResponse.success(userService.getUser(id), ResponseCode.USER_READ_SUCCESS.getMessage());
    }

    // 회원정보 수정
    @PostMapping
    public ApiResponse<Void> updateUser(Long id, UpdateUserDto dto) {
        userService.updateUser(id, dto);
        return ApiResponse.success(null, ResponseCode.USER_UPDATE_SUCCESS.getMessage());
    }

    // 회원의 알림 조회
    @GetMapping("/notification")
    public ApiResponse<List<ResponseUserNotificationDto>> getUserNotification(Long id) {
        return ApiResponse.success(userService.getUserNotification(id), ResponseCode.NOTIFICATION_READ_SUCCESS.getMessage());
    }

    // 회원의 알림 삭제
    @DeleteMapping("/notification")
    public ApiResponse<Void> deleteUserNotification(Long id, Long notificationId) {
        userService.deleteUserNotification(id, notificationId);
        return ApiResponse.success(null, ResponseCode.NOTIFICATION_DELETE_SUCCESS.getMessage());
    }

    // 회원 탈퇴
    @DeleteMapping
    public ApiResponse<Void> deleteUser(Long id) {
        userService.deleteUser(id);
        return ApiResponse.success(null, ResponseCode.USER_DELETE_SUCCESS.getMessage());
    }
}
