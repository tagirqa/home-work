package com.github.tagirqa;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Response {
    private String statusCode;

    @JsonCreator
    public Response(@JsonProperty("statusCode") String statusCode) { this.statusCode = statusCode;}

}
