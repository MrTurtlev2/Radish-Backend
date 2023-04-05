package com.example.demo.service;

import com.example.demo.dto.PrincipalDto;
import com.example.demo.dto.UserCredentialsDto;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.jwt.UserDetailsImpl;
import com.example.demo.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

//   @Autowired
//    UserRepository userRepository;


    private static final int TEMP_PASSWORD_LENGTH = 10;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository,
                       JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public PrincipalDto logIn(UserCredentialsDto userCredentialsDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userCredentialsDto.getEmail(), userCredentialsDto.getPassword()));
        return buildPrincipal(authentication);
    }


    private PrincipalDto buildPrincipal(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return PrincipalDto.builder()
                .id(userDetails.getId())
                .username(userDetails.getUsername())
                .accessToken(jwt)
                .roles(roles)
                .build();
    }


    public User getUserFromSessionStorage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userRepository.findByEmail(userDetails.getUsername()).orElse(null);
    }


}