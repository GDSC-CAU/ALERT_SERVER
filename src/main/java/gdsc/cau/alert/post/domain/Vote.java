package gdsc.cau.alert.post.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(Vote.PK.class) // 복합키 클래스
@Getter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "post_id"})
})
@Entity
public class Vote {

    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "post_id", insertable = false, updatable = false)
    private Long postId;

    private boolean isAgree;

    public static Vote createVote(Long userId, Long postId, boolean isAgree) {
        Vote vote = new Vote();
        vote.userId = userId;
        vote.postId = postId;
        vote.isAgree = isAgree;
        return vote;
    }

    public static class PK implements Serializable {
        Long userId;
        Long postId;
    }
}
