package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.Model.LoginResponse;
import com.Paruvatha.Paruvatha.Model.User;
import com.Paruvatha.Paruvatha.Service.UserService;
import com.Paruvatha.Paruvatha.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        if (user.getPassWord() == null || user.getPassWord().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be empty");
        }

        if (userService.getUserEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        userService.saveUser(user);
        return ResponseEntity.ok("Registered Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = userService.getUserEmail(user.getEmail());

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        if (!existingUser.getPassWord().equals(user.getPassWord())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

        String token = jwtUtil.generateToken(existingUser.getEmail());

        return ResponseEntity.ok().body(new LoginResponse(token, existingUser.getName(), existingUser.getEmail()));
    }
}
