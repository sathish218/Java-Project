package com.Paruvatha.Paruvatha.Service;

import com.Paruvatha.Paruvatha.Model.Auth;
import com.Paruvatha.Paruvatha.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public void register(Auth auth) {
        Optional<Auth> existing = authRepository.findByEmail(auth.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        authRepository.save(auth);
    }

    public Optional<Auth> login(String email, String password) {
        Optional<Auth> auth = authRepository.findByEmail(email);
        return auth.filter(a -> a.getPassword().equals(password));
    }
}
