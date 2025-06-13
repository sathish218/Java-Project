package com.Paruvatha.Paruvatha.Repository;

import com.Paruvatha.Paruvatha.Model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByEmail(String email);
}

//This file is your Data Access Layer (DAL), often called the Repository layer in Spring Boot.
//
//It acts as the bridge between your application and your database.
//
//It uses Spring Data JPA to perform CRUD operations automatically—without writing any SQL manually.


///Detects JpaRepository, and dynamically creates a class behind this interface.
///
/// Looks at your method name: findByEmail(String email)
///
/// Spring’s parser breaks it into:
///
/// find = SELECT
///
/// ByEmail = WHERE email = ?
///
/// Uses JPA + Hibernate + SQL → executes the query.