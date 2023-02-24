package com.makitigroup.training.model;

public enum BookingItemStatusEnum {
    BOOKED("booked"),

    PENDING("pending"),

    REFUSED("refused");

    private final String value;

    BookingItemStatusEnum(String displayName) {
        this.value = displayName;
    }

    public String getValue() {
        return value;
    }
}
