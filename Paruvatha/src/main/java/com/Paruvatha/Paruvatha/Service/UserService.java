package com.Paruvatha.Paruvatha.Service;

import com.Paruvatha.Paruvatha.Model.User;
import com.Paruvatha.Paruvatha.Repository.UserRepository;
import com.Paruvatha.Paruvatha.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final String super_admin_email = "sathishsuganesan23@gmail.com";

    public User getUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean isSuperAdmin(String token) {
        String email = jwtUtil.extractEmailFromToken(token);
        return super_admin_email.equalsIgnoreCase(email);
    }
}
