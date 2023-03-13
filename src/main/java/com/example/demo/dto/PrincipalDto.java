package com.example.demo.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
@Value
@Builder
public class PrincipalDto {
    Long id;
    String username;
    String accessToken;
    List<String> roles;
}