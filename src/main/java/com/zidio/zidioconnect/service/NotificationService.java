
package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.model.Notification;
import com.zidio.zidioconnect.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired private NotificationRepository repo;

    public Notification create(Notification n) { return repo.save(n); }
    public List<Notification> byUser(Long userId) { return repo.findByUserId(userId); }
}
