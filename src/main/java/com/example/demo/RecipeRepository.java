package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Recipe;
import org.springframework.stereotype.Repository;

//
//        import org.springframework.data.repository.CrudRepository;
//
//        import com.example.accessingdatamysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}