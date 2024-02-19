package gdsc.cau.alert.post.domain;

import gdsc.cau.alert.user.domain.User;
import gdsc.cau.alert.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    private String imageUrl;

    private String location;

    private String species;

    private String capturedAt;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Vote> votes = new ArrayList<>();

    public static Post createPost(User user, String title, String content, String imageUrl, String location, String species, String capturedAt) {
        Post post = new Post();
        post.imageUrl = imageUrl;
        post.user = user;
        post.title = title;
        post.content = content;
        post.location = location;
        post.species = species;
        post.capturedAt = capturedAt;
        return post;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Pair<Integer, Integer> getVoteCounts(){
        int agreeCount = 0;
        for(Vote vote : votes){
            agreeCount += vote.isAgree() ? 1 : 0;
        }
        return Pair.of(agreeCount, votes.size() - agreeCount);
    }
}
