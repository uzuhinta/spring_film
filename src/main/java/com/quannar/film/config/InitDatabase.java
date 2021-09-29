package com.quannar.film.config;

import com.quannar.film.model.Actor;
import com.quannar.film.model.Type;
import com.quannar.film.repository.ActorRepository;
import com.quannar.film.repository.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.Arrays;

@Configuration
public class InitDatabase {

    @Bean
    CommandLineRunner commandLineRunner(
            ActorRepository actorRepository,
            TypeRepository typeRepository
    ) {
        return args -> {
            Actor quan = new Actor("quan");
            quan.setDob(Date.valueOf("1999-08-17"));
            quan.setSummary("Nguyen Ba Quan");


            Actor nga = new Actor("nga");
            nga.setDob(Date.valueOf("1999-02-05"));
            nga.setSummary("Description of nga");

            Actor thirdActor = new Actor("3rd actor");

            actorRepository.saveAllAndFlush(Arrays.asList(quan, nga, thirdActor));

            Type type1 = new Type("Phim bộ");
            Type type2 = new Type("Phim chiếu rạp");
            Type type3 = new Type("Phim mới");
            typeRepository.saveAllAndFlush(Arrays.asList(type1, type2, type3));
        };
    }
}
