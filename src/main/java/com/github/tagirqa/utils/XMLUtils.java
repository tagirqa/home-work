package com.github.tagirqa.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.tagirqa.Request;
import com.github.tagirqa.Response;

public class XMLUtils {

    public static String toXML(Request request) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(request);
    }

    public static String toXML(Response response) throws JsonProcessingException {
        return new XmlMapper().writeValueAsString(response);
    }

    public static Request XMLtoRequest(String s) throws JsonProcessingException {
        return new XmlMapper().readValue(s, Request.class);
    }

    public static Response XMLtoResponse(String s) throws JsonProcessingException {
        return new XmlMapper().readValue(s, Response.class);
    }
}
