package com.gabrielsantana.workshopmongo.config;

import com.gabrielsantana.workshopmongo.domain.User;
import com.gabrielsantana.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User igao = new User(null, "Igao", "igaomotoboy@gmail.com");
        User pedro = new User(null, "Pedrola", "pedrola@gmail.com");
        User luiz = new User(null, "Luizim", "luizimcristao@gmail.com");
        User dhara = new User(null, "Dhara", "dhara@gmail.com");
        User guga = new User(null, "Guga", "guga@gmail.com");
        User gabas = new User(null, "Gabas69", "gabas69@gmail.com");

        userRepository.saveAll(Arrays.asList(igao, pedro, luiz, dhara, guga, gabas));

    }
}
