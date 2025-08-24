package com.example.system.springbasicconcept.DTO;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateUserDTO {
    private String name;
//    private int genderId;
    @NonNull
    private String genderLabel;
}
