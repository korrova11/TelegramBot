package pro.sky.telegrambot.cron;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationCron {
    private final TelegramBot telegramBot;
    private final NotificationService notificationService;

    public NotificationCron(TelegramBot telegramBot, NotificationService notificationService) {
        this.telegramBot = telegramBot;
        this.notificationService = notificationService;
    }
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void doReminder(){
        notificationService.findAllByLocalDateTime(LocalDateTime.now()
                .truncatedTo(ChronoUnit.MINUTES))
                .forEach(reminder->{
                    telegramBot.execute(new SendMessage(reminder.getChat_id(),
                            reminder.getNotification()));
                    notificationService.deleteFromRepo(reminder);
                });
    }


}
