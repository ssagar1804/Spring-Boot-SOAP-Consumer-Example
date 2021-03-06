package com.onlinetutorialspoint.soap.json.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata{
    @JsonProperty("FieldDefinitions") 
    public List<FieldDefinition> fieldDefinitions;
}

