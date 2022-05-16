package com.example.demo.config;

import com.example.demo.Recipe;
import com.example.demo.RecipeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class Config {
    @Bean
    public RecipeRepository helloWorld(){
        return new RecipeRepository() {
            @Override
            public <S extends Recipe> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Recipe> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Recipe> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Recipe> findAll() {
                return null;
            }

            @Override
            public Iterable<Recipe> findAllById(Iterable<Integer> integers) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Recipe entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Recipe> entities) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }
}
