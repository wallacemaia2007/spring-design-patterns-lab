package com.wallace.spring.boot.padroes.projetos.security.config;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wallace.spring.boot.padroes.projetos.entities.User;
import com.wallace.spring.boot.padroes.projetos.repository.UserRepository;

@Service
public class UserInformations implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserInformations(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + userName));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                user.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList())
        );
    }
}