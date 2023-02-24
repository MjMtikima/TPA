package com.makitigroup.training.model;

public enum BookingStatusEnum {
    PLACED("placed"),

    IN_PROGRESS("in progress"),

    ENDED("ended"),

    CANCELED("canceled");

    private String value;

    BookingStatusEnum(String displayName) {
        this.value = displayName;
    }

    public String getValue() {
        return value;
    }

}
