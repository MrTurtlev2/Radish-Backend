package com.example.demo;

import com.example.demo.entity.RoleEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public DataLoader(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void run(ApplicationArguments args) {

        List<RoleUtil> roleUtils = new ArrayList<>();
        roleUtils.add(RoleUtil.ROLE_USER);
        roleUtils.add(RoleUtil.ROLE_COURIER);
        roleUtils.add(RoleUtil.ROLE_DEPOSIT_COLLECTOR);

        roleUtils.forEach(roleUtil -> {
            RoleEntity byName = roleRepository.findByName(roleUtil);
            if(byName == null){
                RoleEntity entity = RoleEntity.builder()
                        .name(roleUtil).build();
                roleRepository.save(entity);
            }
        });
    }
}