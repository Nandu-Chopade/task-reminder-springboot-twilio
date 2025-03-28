package com.taskmanager.services;

import com.taskmanager.entity.Task;
import com.taskmanager.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskReminderService {

    private final TaskRepository taskRepository;
    private final WhatsAppService whatsAppService;

    public TaskReminderService(TaskRepository taskRepository, WhatsAppService whatsAppService) {
        this.taskRepository = taskRepository;
        this.whatsAppService = whatsAppService;
    }

    @Scheduled(fixedRate = 60000)
    public void checkAndSendReminders() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextMinute = now.plusMinutes(1);

        System.out.println("[DEBUG] checkAndSendReminders running at: " + now);
        System.out.println("[DEBUG] Searching tasks between: " + now + " and " + nextMinute);

        List<Task> tasks = taskRepository.findByReminderTimeBetween(now, nextMinute);
        System.out.println("[DEBUG] Found " + tasks.size() + " tasks to remind.");

        for (Task task : tasks) {
            String message = "🔔 *      REMINDER      * 🔔\n\n" + task.getTaskName() + " - " + task.getDescription();
            System.out.println("[DEBUG] Sending message to " + task.getPhoneNumber() + ": " + message);
            whatsAppService.sendWhatsAppMessage(task.getPhoneNumber(), message);
        }
    }

}