package com.qentelli.GroupFinalAssessment.api;

import com.qentelli.GroupFinalAssessment.utils.RandomDataUtils;

public class PayloadManager {

    public static String createUserPayload(

            String firstname,
            String lastname,
            String email) {

        String username =

                firstname.toLowerCase()

                + RandomDataUtils
                .generateRandomNumber();

        return "{\n"

                + "\"email\":\""
                + email
                + "\",\n"

                + "\"username\":\""
                + username
                + "\",\n"

                + "\"password\":\"Password@123\",\n"

                + "\"name\":{\n"

                + "\"firstname\":\""
                + firstname
                + "\",\n"

                + "\"lastname\":\""
                + lastname
                + "\"\n"

                + "}\n"

                + "}";
    }
}