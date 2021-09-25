package com.quannar.film.repository.fake;

import com.quannar.film.model.Actor;
import com.quannar.film.repository.ActorRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class FakeActorRepository {


    public List<Actor> getAllActor() {
        Actor quan = new Actor("quan");
        quan.setId(1L);
        quan.setDob(Date.valueOf("1999-08-17"));
        quan.setSummary("Nguyen Ba Quan");


        Actor nga = new Actor("nga");
        nga.setId(2L);
        nga.setDob(Date.valueOf("1999-05-02"));
        nga.setSummary("Description of nga");

        return Arrays.asList(quan, nga);
    }
}
