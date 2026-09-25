package com.highschool.backend.config;

import com.highschool.backend.entity.SchoolClass;
import com.highschool.backend.repository.SchoolClassRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeClasses(
            SchoolClassRepository schoolClassRepository) {

        return args -> {

            for (int classNumber = 6; classNumber <= 10; classNumber++) {

                if (schoolClassRepository
                        .findByClassNumber(classNumber)
                        .isEmpty()) {

                    schoolClassRepository.save(
                            new SchoolClass(classNumber)
                    );
                }
            }
        };
    }
}