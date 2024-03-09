package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Notification_task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long chat_id;
    String notification;
    LocalDateTime dateTime;

    public Notification_task(Long id,Long chat_id, String notification, LocalDateTime dateTime) {
        this.chat_id = chat_id;
        this.notification = notification;
        this.dateTime = dateTime;
        this.id = id;
    }

    public Notification_task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification_task that = (Notification_task) o;
        return Objects.equals(id, that.id) && Objects.equals(chat_id, that.chat_id) && Objects.equals(notification, that.notification) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chat_id, notification, dateTime);
    }

    @Override
    public String toString() {
        return "NotificationTask{" +
                "id=" + id +
                ", chat_id=" + chat_id +
                ", notification='" + notification + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
