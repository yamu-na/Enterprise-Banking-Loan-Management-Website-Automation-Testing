package com.qentelli.GroupFinalAssessment.api;

import io.restassured.response.Response;

public class AuthApi {

    private static String token;

    public static Response login(
            String username,
            String password) {

        String payload =

                "{\n"

                + "\"username\":\""
                + username
                + "\",\n"

                + "\"password\":\""
                + password
                + "\"\n"

                + "}";

        Response response =

                ApiClient.post(
                ApiRoutes.LOGIN,
                payload);

        if (response.getStatusCode() == 200) {

            token =
            response.jsonPath()
            .getString("token");
        }

        return response;
    }

    public static String getToken() {

        return token;
    }
}