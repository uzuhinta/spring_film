package com.quannar.film.repository.fake;

import com.quannar.film.model.Type;
import com.quannar.film.repository.TypeRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class FakeTypeRepository{

    public List<Type> getAllType() {
        Type type1 = new Type("Phim bộ");
        Type type2 = new Type("Phim chiếu rạp");
        Type type3 = new Type("Phim mới");
        return Arrays.asList(type1, type2, type3);
    }
}
