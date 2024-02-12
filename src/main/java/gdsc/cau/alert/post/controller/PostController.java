package gdsc.cau.alert.post.controller;

import gdsc.cau.alert.post.service.PostService;
import gdsc.cau.alert.util.api.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/post")
@RestController
public class PostController {

    @GetMapping
    public ApiResponse<Void> createPost() {
        return ApiResponse.success(null, "게시글이 성공적으로 생성되었습니다.");
    }
}
