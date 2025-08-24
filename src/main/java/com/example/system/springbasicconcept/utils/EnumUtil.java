package com.example.system.springbasicconcept.utils;

import com.example.system.springbasicconcept.emums.BaseEnum;

public class EnumUtil {

    // Generic method to find enum by id
    public static <T extends Enum<T> & BaseEnum> T fromId(Class<T> enumClass, int id) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getId() == id) {
                return enumConstant;
            }
        }
        throw new RuntimeException("Invalid ID " + id + " for enum " + enumClass.getSimpleName());
    }

    // ✅ Find enum by label
    public static <T extends Enum<T> & BaseEnum> T fromLabel(Class<T> enumClass, String label) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getLabel().equalsIgnoreCase(label)) {
                return enumConstant;
            }
        }
        throw new RuntimeException("Invalid Label '" + label + "' for enum " + enumClass.getSimpleName());
    }
}
