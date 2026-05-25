package com.qentelli.GroupFinalAssessment.models;

public class UserData {

    private static int userId;

    public static void setUserId(int id) {

        userId = id;
    }

    public static int getUserId() {

        return userId;
    }
}