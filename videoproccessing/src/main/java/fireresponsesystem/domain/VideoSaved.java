package fireresponsesystem.domain;

import fireresponsesystem.domain.*;
import fireresponsesystem.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class VideoSaved extends AbstractEvent {

    private Long videoId;
    private String reportId;
    private String originalVideoUri;
    private String encodedVideoUri;

    public VideoSaved(Video aggregate) {
        super(aggregate);
    }

    public VideoSaved() {
        super();
    }
}
//>>> DDD / Domain Event
