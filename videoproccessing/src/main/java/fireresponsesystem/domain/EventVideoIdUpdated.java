package fireresponsesystem.domain;

import fireresponsesystem.domain.*;
import fireresponsesystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class EventVideoIdUpdated extends AbstractEvent {

    private String reportId;
    private String eventId;
    private String userId;
    private Float longitude;
    private Float latitude;
    private String videoUri;
    private String description;
    private Date uploadedAt;
    private String status;
}
