package com.onlinetutorialspoint.soap.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListValue{
    @JsonProperty("id") 
    public String id;
    @JsonProperty("displayName") 
    public String displayName;
    @JsonProperty("text") 
    public String text;
}

