package com.wallace.spring.boot.padroes.projetos.application;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wallace.spring.boot.padroes.projetos.entities.User;
import com.wallace.spring.boot.padroes.projetos.repository.UserRepository;

@Component
public class Main implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User managerUser = new User();
            
            managerUser.setUserName("Wallace");
            managerUser.setPassword(passwordEncoder.encode("1234"));
            managerUser.setRoles(Arrays.asList("MANAGER"));
            userRepository.save(managerUser);

            System.out.println("Usuário 'admin' criado com sucesso!");
        }
    }

}
