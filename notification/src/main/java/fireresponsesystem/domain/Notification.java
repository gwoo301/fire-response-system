package fireresponsesystem.domain;

import fireresponsesystem.NotificationApplication;
import fireresponsesystem.domain.FireEventNotified;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alarmId;

    private Long eventId;

    private Float longitude;

    private Float latitude;

    private Date createdAt;

    private String content;

    @PostPersist
    public void onPostPersist() {
        FireEventNotified fireEventNotified = new FireEventNotified(this);
        fireEventNotified.publishAfterCommit();
    }

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyFireEvent(
        IdentifiedAsFireEvent identifiedAsFireEvent
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(identifiedAsFireEvent.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyFireEventUpdated(StatusUpdated statusUpdated) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(statusUpdated.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
