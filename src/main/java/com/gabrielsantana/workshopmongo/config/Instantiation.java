package com.gabrielsantana.workshopmongo.config;

import com.gabrielsantana.workshopmongo.domain.Post;
import com.gabrielsantana.workshopmongo.domain.User;
import com.gabrielsantana.workshopmongo.repository.PostRepository;
import com.gabrielsantana.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User igao = new User(null, "Igao", "igaomotoboy@gmail.com");
        User pedro = new User(null, "Pedrola", "pedrola@gmail.com");
        User luiz = new User(null, "Luizim", "luizimcristao@gmail.com");
        User dhara = new User(null, "Dhara", "dhara@gmail.com");
        User guga = new User(null, "Guga", "guga@gmail.com");
        User gabas = new User(null, "Gabas69", "gabas69@gmail.com");

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Estourei a fimose", "Hoje estourei a fimose!" +
                " Nem doeu tanto assim,só fiquei com a bunda assada!", pedro);

        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Moggei os Betas", "Seloco familia, farmei" +
                " aura em cima desses betinhas, muito sigma", gabas);



        userRepository.saveAll(Arrays.asList(igao, pedro, luiz, dhara, guga, gabas));
        postRepository.saveAll(Arrays.asList(p1,p2));
    }
}
