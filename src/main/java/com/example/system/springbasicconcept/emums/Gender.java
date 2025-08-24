package com.example.system.springbasicconcept.emums;


import lombok.Getter;

@Getter
public enum Gender implements BaseEnum{

    MALE(1,"MALE"),
    FEMALE(2,"FEMALE"),
    OTHER(3,"OTHER");

    private final int id;
    private final String label;

    Gender(int id, String label) {
         this.id = id;
         this.label = label;
    }

    public static Gender getGenderById(int id) {
        for(Gender gender : values()){
            if (gender.getId() == id){
                return gender;
            }
        }
        throw new IllegalArgumentException("Gender with id " + id + " not found");
    }

    public static Gender fromLabel(String label) {
        for (Gender gender : values()){
            if (gender.getLabel().equalsIgnoreCase(label)){
                return gender;
            }
        }
        throw new IllegalArgumentException("Gender with label " + label + " not found");
    }

    @Override
    public String getLabel() {
        return label;
    }
}