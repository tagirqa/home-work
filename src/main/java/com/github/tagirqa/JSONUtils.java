package com.github.tagirqa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtils {

    public static String toJSON(Request request) throws IOException {
        return new ObjectMapper().writeValueAsString(request);
    }

    public static String toJSON(Response response) throws IOException {
        return new ObjectMapper().writeValueAsString(response);
    }

    public static Request JSONtoRequest(String s) throws JsonProcessingException {
        return new ObjectMapper().readValue(s, Request.class);
    }


    public static Response JSONtoResponse(String s) throws JsonProcessingException {
        return new ObjectMapper().readValue(s, Response.class);
    }
}
