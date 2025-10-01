
package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.model.User;
import com.zidio.zidioconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> me(org.springframework.security.core.Authentication auth) {
        if (auth == null) return ResponseEntity.status(401).body("Unauthorized");
        String email = auth.getName();
        Optional<User> u = userService.findByEmail(email);
        if (u.isEmpty()) return ResponseEntity.status(404).body("User not found");
        User user = u.get();
        user.setPassword(null);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public List<User> all() { return userService.all(); }
}
