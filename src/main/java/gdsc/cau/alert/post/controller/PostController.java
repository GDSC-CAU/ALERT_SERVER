package gdsc.cau.alert.post.controller;

import gdsc.cau.alert.util.api.ApiResponse;
import gdsc.cau.alert.util.api.ResponseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/post")
@RestController
public class PostController {

    @GetMapping
    public ApiResponse<Void> getPost() {
        return ApiResponse.success(null, ResponseCode.USER_CREATE_SUCCESS.getMessage());
    }

}
