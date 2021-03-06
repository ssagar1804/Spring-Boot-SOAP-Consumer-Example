package com.onlinetutorialspoint.soap.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Field{
    @JsonProperty("id") 
    public String id;
    @JsonProperty("guid") 
    public String guid;
    @JsonProperty("type") 
    public String type;
    @JsonProperty("text") 
    public String text;
    @JsonProperty("ListValues") 
    public ListValues listValues;
}

