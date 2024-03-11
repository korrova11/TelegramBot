package pro.sky.telegrambot.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Notification_task;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification_task,Long> {
    List<Notification_task> findAllByDateTime(LocalDateTime localDateTime);
}
