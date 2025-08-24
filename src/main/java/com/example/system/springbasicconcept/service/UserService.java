package com.example.system.springbasicconcept.service;

import com.example.system.springbasicconcept.DTO.CreateUserDTO;
import com.example.system.springbasicconcept.emums.Gender;
import com.example.system.springbasicconcept.emums.Status;
import com.example.system.springbasicconcept.entity.User;
import com.example.system.springbasicconcept.repository.UserRepository;
import com.example.system.springbasicconcept.utils.EnumUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

       public User createUser(CreateUserDTO request) {
        User user = new User();
        user.setName(request.getName());

        // gender conversion
        if (request.getGenderId() != 0) {
            user.setGender(EnumUtil.fromId(Gender.class, request.getGenderId()));
        } else if (request.getGenderLabel() != null) {
            user.setGender(EnumUtil.fromLabel(Gender.class, request.getGenderLabel()));
        }

        // ✅ status conversion
        if (request.getStatusId() != 0) {
            user.setStatus(EnumUtil.fromId(Status.class, request.getStatusId()));
        } else if (request.getStatusLabel() != null) {
            user.setStatus(EnumUtil.fromLabel(Status.class, request.getStatusLabel()));
        }

        return userRepository.save(user);
    }
}
