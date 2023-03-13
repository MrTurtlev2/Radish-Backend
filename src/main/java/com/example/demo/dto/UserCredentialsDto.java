package com.example.demo.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCredentialsDto {
    String email;
    String password;
}