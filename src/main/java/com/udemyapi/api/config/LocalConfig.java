package com.udemyapi.api.config;


import com.udemyapi.api.domain.User;
import com.udemyapi.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("Local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

     @Bean
     public void startDb(){
         User u1 = new User(null, "Ralph", "ralph@email.com", "1234");
         User u2 = new User(null, "Roger", "roger@email.com", "1234");
            repository.saveAll(List.of(u1, u2));

    }

}

