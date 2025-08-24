package com.example.system.springbasicconcept.emums;

import lombok.Getter;

@Getter
public enum Status implements BaseEnum {

    ACTIVE(1, "ACTIVE"),
    INACTIVE(2, "INACTIVE");

    private final int id;
    private final String label;

    private Status(int id, String label) {
        this.id = id;
        this.label = label;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
