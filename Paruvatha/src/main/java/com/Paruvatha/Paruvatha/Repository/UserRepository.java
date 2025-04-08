package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
