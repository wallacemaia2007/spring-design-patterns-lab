package com.wallace.spring.boot.padroes.projetos.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallace.spring.boot.padroes.projetos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}