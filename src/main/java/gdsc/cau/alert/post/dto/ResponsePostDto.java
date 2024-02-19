package gdsc.cau.alert.post.dto;

import gdsc.cau.alert.post.domain.Post;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

@Data
@Builder
public class ResponsePostDto {

    private Long postId;
    private String title;
    private String content;
    private String location;
    private String captureDate;
    private String image;
    private String species;
    private int agreeCount;
    private int disagreeCount;

    public static ResponsePostDto of(Post post) {
        Pair<Integer, Integer> p = post.getVoteCounts();
        return ResponsePostDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .location(post.getLocation())
                .captureDate(post.getCapturedAt())
                .image(post.getImageUrl())
                .species(post.getSpecies())
                .agreeCount(p.getLeft())
                .disagreeCount(p.getRight())
                .build();
    }
}
