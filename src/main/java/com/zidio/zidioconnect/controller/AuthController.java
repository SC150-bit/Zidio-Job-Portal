
package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.AuthRequest;
import com.zidio.zidioconnect.dto.AuthResponse;
import com.zidio.zidioconnect.dto.RegisterRequest;
import com.zidio.zidioconnect.model.User;
import com.zidio.zidioconnect.security.JwtUtil;
import com.zidio.zidioconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired private UserService userService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userService.findByEmail(req.getEmail()).isPresent()) return ResponseEntity.badRequest().body("Email already used");
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword());
        u.setRole(req.getRole() == null ? com.zidio.zidioconnect.model.Role.STUDENT : req.getRole());
        User saved = userService.register(u);
        saved.setPassword(null);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        Optional<User> u = userService.findByEmail(req.getEmail());
        if (u.isEmpty()) return ResponseEntity.status(401).body("Invalid credentials");
        User user = u.get();
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) return ResponseEntity.status(401).body("Invalid credentials");
        String token = jwtUtil.generateToken(user.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
