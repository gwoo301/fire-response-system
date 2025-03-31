package fireresponsesystem.domain;

import fireresponsesystem.VideoproccessingApplication;
import fireresponsesystem.domain.VideoSaved;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Video_table")
@Data
//<<< DDD / Aggregate Root
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long videoId;

    private String reportId;

    private String originalVideoUri;

    private String encodedVideoUri;

    @PostPersist
    public void onPostPersist() {
        VideoSaved videoSaved = new VideoSaved(this);
        videoSaved.publishAfterCommit();
    }

    public static VideoRepository repository() {
        VideoRepository videoRepository = VideoproccessingApplication.applicationContext.getBean(
            VideoRepository.class
        );
        return videoRepository;
    }
}
//>>> DDD / Aggregate Root
