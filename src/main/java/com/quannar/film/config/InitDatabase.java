package com.quannar.film.config;

import com.quannar.film.model.Actor;
import com.quannar.film.model.Category;
import com.quannar.film.model.Type;
import com.quannar.film.repository.ActorRepository;
import com.quannar.film.repository.CategoryRepository;
import com.quannar.film.repository.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.Month;
import java.util.Arrays;

@Configuration
public class InitDatabase {

    @Bean
    CommandLineRunner commandLineRunner(
            ActorRepository actorRepository,
            TypeRepository typeRepository,
            CategoryRepository categoryRepository
    ) {
        return args -> {
            Actor quan = new Actor("quan");
            quan.setDob(Date.valueOf("1999-08-17"));
            quan.setSummary("Nguyen Ba Quan");

            Actor nga = new Actor("nga");
            nga.setDob(Date.valueOf("1999-02-05"));
            nga.setSummary("Description of nga");

            System.out.println(nga.toString());

            Actor thirdActor = new Actor("3rd actor");

            actorRepository.saveAllAndFlush(Arrays.asList(quan, nga, thirdActor));

            Type type1 = new Type("Phim bộ");
            Type type2 = new Type("Phim chiếu rạp");
            Type type3 = new Type("Phim mới");
            typeRepository.saveAllAndFlush(Arrays.asList(type1, type2, type3));

            Category category1 = new Category("Phim tình cảm");
            Category category2 = new Category("Phim hành động");
            Category category3 = new Category("Phim cổ trang");

            categoryRepository.saveAllAndFlush(Arrays.asList(category1, category2, category3));
        };
    }
}
