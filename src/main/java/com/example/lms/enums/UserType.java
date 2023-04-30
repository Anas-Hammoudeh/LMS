package com.example.lms.enums;

public enum UserType {
    STUDENT("STUDENT"),
    FACULTY("FACULTY"),
    EMPLOYEE("EMPLOYEE");

    private final String userType;

    private UserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}
