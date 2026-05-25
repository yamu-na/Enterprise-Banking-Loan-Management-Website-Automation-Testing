package com.qentelli.GroupFinalAssessment.api;

import io.restassured.response.Response;

public class UserApi {

    public static Response createUser(
            String payload) {

        return ApiClient.post(
                ApiRoutes.USERS,
                payload);
    }

    public static Response getUser(
            int userId) {

        return ApiClient.get(
                ApiRoutes.USERS
                + "/"
                + userId);
    }
}