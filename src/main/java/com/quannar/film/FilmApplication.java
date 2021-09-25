package com.quannar.film;

import com.quannar.film.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class FilmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmApplication.class, args);
	}

}
