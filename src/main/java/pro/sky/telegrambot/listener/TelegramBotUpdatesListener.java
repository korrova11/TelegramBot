package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.Notification_task;
import pro.sky.telegrambot.repositiries.NotificationRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    private NotificationRepository repository;

    public TelegramBotUpdatesListener(NotificationRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);

            // Process your updates here
            Pattern pattern1 = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)");
            if (update.message().text().equals("/start")) {
                SendMessage message = new SendMessage(update.message().chat().id(),
                        "Здравствуй, " + update.message().chat().firstName()
                                + "!");
                SendResponse response = telegramBot.execute(message);
            }
            Matcher matcher = pattern1.matcher(update.message().text());
            if (matcher.matches()) {
                String dateTime = matcher.group(1);
                String text = matcher.group(3);
                LocalDateTime localDateTime = LocalDateTime.parse(dateTime,
                        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
               /* repository.save(new Notification_task(update.message().chat().id(),text,
                       localDateTime ));
                */
            }

        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
