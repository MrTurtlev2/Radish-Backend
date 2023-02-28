package com.example.demo.dto;

import com.example.demo.entity.Plant;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

public class UserDTO {

    private String name;
    private String lastName;

    private List<Plant> plantList;
}
