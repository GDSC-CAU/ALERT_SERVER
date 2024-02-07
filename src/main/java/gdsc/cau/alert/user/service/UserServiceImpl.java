package gdsc.cau.alert.user.service;

import gdsc.cau.alert.user.domain.User;
import gdsc.cau.alert.user.domain.UserNotification;
import gdsc.cau.alert.user.dto.ResponseUserDto;
import gdsc.cau.alert.user.dto.ResponseUserNotificationDto;
import gdsc.cau.alert.user.dto.UpdateUserDto;
import gdsc.cau.alert.user.repository.UserNotificationRepository;
import gdsc.cau.alert.user.repository.UserRepository;
import gdsc.cau.alert.util.api.ResponseCode;
import gdsc.cau.alert.util.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserNotificationRepository userNotificationRepository;

    // 회원정보 조회
    @Transactional(readOnly = true)
    public ResponseUserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(ResponseCode.USER_NOT_FOUND));
        return ResponseUserDto.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .address1(user.getAddress1())
                .address2(user.getAddress2())
                .build();
    }

    // 회원정보 수정
    @Transactional
    public void updateUser(Long id, UpdateUserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(ResponseCode.USER_NOT_FOUND));
        user.update(dto.getName(), dto.getAddress1(), dto.getAddress2());
        userRepository.save(user);
    }

    // 회원의 알림 조회
    @Transactional(readOnly = true)
    public List<ResponseUserNotificationDto> getUserNotification(Long id) {
        List<UserNotification> userNotifications = userNotificationRepository.findByUserId(id);
        return userNotifications.stream()
                .map(userNotification -> ResponseUserNotificationDto.builder()
                        .title(userNotification.getNotification().getTitle())
                        .content(userNotification.getNotification().getContent())
                        .createdAt(userNotification.getCreatedAt().toString())
                        .build())
                .toList();
    }

    // 회원의 알림 삭제
    @Transactional
    public void deleteUserNotification(Long id, Long notificationId) {
        if(userNotificationRepository.existsByUserIdAndNotificationId(id, notificationId)) {
            throw new UserException(ResponseCode.NOTIFICATION_NOT_FOUND);
        }
        userNotificationRepository.deleteByUserIdAndNotificationId(id, notificationId);
    }

    // 회원 탈퇴
    @Transactional
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id)) {
            throw new UserException(ResponseCode.USER_NOT_FOUND);
        }
        userRepository.deleteById(id);
    }
}
