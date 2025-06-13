package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.DTO.LoginRequest;
import com.Paruvatha.Paruvatha.DTO.SignupRequest;
import com.Paruvatha.Paruvatha.Model.Auth;
import com.Paruvatha.Paruvatha.Service.AuthService;
import com.Paruvatha.Paruvatha.Service.UserService;
import com.Paruvatha.Paruvatha.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth") // ✅ unique base path
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    // ✅ Signup endpoint
    @PostMapping("/signup")
    public Map<String, String> signup(@RequestBody SignupRequest request) {
        Auth auth = new Auth();
        auth.setName(request.name);
        auth.setEmail(request.email);
        auth.setPhone(request.phone);
        auth.setPassword(request.password);
        authService.register(auth);
        return Map.of("message", "Signup successful!");
    }

    // ✅ Login endpoint
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        Optional<Auth> auth = authService.login(request.email, request.password);
        if (auth.isPresent()) {
            String token = jwtUtil.generateToken(auth.get().getEmail());
            return Map.of("token", token, "fullName", auth.get().getName());
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

    // ✅ Logout endpoint (client-side only)
    @PostMapping("/logout")
    public Map<String, String> logout() {
        return Map.of("message", "Logged out successfully. Please clear token on client side.");
    }

    // ✅ Super Admin access check
    @GetMapping("/super-admin/check")
    public Map<String, String> checkSuperAdmin(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String token = authHeader.replace("Bearer ", "");

        boolean isAdmin = userService.isSuperAdmin(token);

        if (isAdmin) {
            return Map.of("message", "Access granted: Super Admin");
        } else {
            throw new RuntimeException("Access denied: Not a super admin");
        }
    }
}
