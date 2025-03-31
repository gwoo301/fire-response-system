package fireresponsesystem.domain;

import fireresponsesystem.NotificationApplication;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "UserAlarm_table")
@Data
//<<< DDD / Aggregate Root
public class UserAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userAlarmId;

    private Long userId;

    private Long alarmId;

    private Long eventId;

    private Float longitude;

    private Float latitude;

    private String createdAt;

    private String reportId;

    private String content;

    public static UserAlarmRepository repository() {
        UserAlarmRepository userAlarmRepository = NotificationApplication.applicationContext.getBean(
            UserAlarmRepository.class
        );
        return userAlarmRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyVideoAnalysisFailed(
        VideoAnalysisFailed videoAnalysisFailed
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        UserAlarm userAlarm = new UserAlarm();
        repository().save(userAlarm);

        */

        /** Example 2:  finding and process
        
        repository().findById(videoAnalysisFailed.get???()).ifPresent(userAlarm->{
            
            userAlarm // do something
            repository().save(userAlarm);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyByLocation(FireEventNotified fireEventNotified) {
        //implement business logic here:

        /** Example 1:  new item 
        UserAlarm userAlarm = new UserAlarm();
        repository().save(userAlarm);

        */

        /** Example 2:  finding and process
        
        repository().findById(fireEventNotified.get???()).ifPresent(userAlarm->{
            
            userAlarm // do something
            repository().save(userAlarm);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
