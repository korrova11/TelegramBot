package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Notification_task;
import pro.sky.telegrambot.repositiries.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {

        this.repository = repository;
    }
    public Notification_task addInRepo(Notification_task notification_task){
        return repository.save(notification_task);

    }
    public List<Notification_task> findAllByLocalDateTime(LocalDateTime localDateTime){
        return repository.findAllByDateTime(localDateTime);

    }
    public void deleteFromRepo(Notification_task notification_task){

        repository.delete(notification_task);
    }



}
