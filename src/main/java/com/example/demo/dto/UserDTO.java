package com.example.demo.dto;

import com.example.demo.entity.Plant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String lastName;

//    private List<Plant> plantList;
}
