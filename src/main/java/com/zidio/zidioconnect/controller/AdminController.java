
package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.model.Notification;
import com.zidio.zidioconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired private NotificationService notificationService;

    @PostMapping("/notify")
    public Notification notifyUser(@RequestBody Notification n) { return notificationService.create(n); }

    @GetMapping("/notifications/{userId}")
    public List<Notification> notifications(@PathVariable Long userId) { return notificationService.byUser(userId); }
}
