package com.example.todoapplication.notification;

import com.example.todoapplication.annotation.CurrentUser;
import com.example.todoapplication.user.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;




    @GetMapping(value = "/subscribe", produces = "text/event-stream")
    public SseEmitter subscribe(@CurrentUser Account account,
                                @RequestHeader(value = "Last-Event-ID", required = false, defaultValue = "") String lastEventId) {
        return notificationService.subscribe(account.getId(), lastEventId);
    }


}
