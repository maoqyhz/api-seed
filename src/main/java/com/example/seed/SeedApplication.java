package com.example.seed;

import com.example.seed.dao.repo.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.TimeZone;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "com.example.seed.dao.repo",
        repositoryBaseClass = BaseRepositoryImpl.class)
@SpringBootApplication
public class SeedApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SeedApplication.class, args);
    }

}
