package com.example.demo.repository;

import com.example.demo.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

    @Query(value = "select o from Plant o where o.user.id= :id")
    public List<Plant> getPlantsByOwner(@Param("id") int id);
}
