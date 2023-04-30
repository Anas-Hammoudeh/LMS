package com.example.lms.enums;

public enum ItemType {
    BOOK("BOOK"),
    JOURNAL("JOURNAL");
    private final String type;

    private ItemType(String type) {
        this.type = type;
    }

    public String getItemType() {
        return type;
    }
}
