package pro.sky.telegrambot.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.model.Notification_task;

public interface NotificationRepository extends JpaRepository<Notification_task,Long> {
}
