package com.qentelli.GroupFinalAssessment.utils;

import org.json.JSONObject;

public class JsonUtils {

    // Convert string to JSON object
    public static JSONObject
    convertStringToJson(
            String payload) {

        return new JSONObject(payload);
    }
}