package com.example.system.springbasicconcept.service;

import com.example.system.springbasicconcept.DTO.CreateUserDTO;
import com.example.system.springbasicconcept.emums.Gender;
import com.example.system.springbasicconcept.entity.User;
import com.example.system.springbasicconcept.repository.UserRepository;
import com.example.system.springbasicconcept.utils.EnumUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserDTO createUserDTO){
        User user =  new User();
        user.setName(createUserDTO.getName());
//        user.setGender(EnumUtil.fromId(Gender.class,createUserDTO.getGenderId()));
        user.setGender(EnumUtil.fromLabel(Gender.class,createUserDTO.getGenderLabel()));
        return userRepository.save(user);
    }
}
