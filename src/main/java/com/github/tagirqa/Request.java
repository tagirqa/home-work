package com.github.tagirqa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Request {
    private String atmNumber;

    @JsonCreator
    public Request(@JsonProperty("atmNumber") String atmNumber) { this.atmNumber = atmNumber;}
}
