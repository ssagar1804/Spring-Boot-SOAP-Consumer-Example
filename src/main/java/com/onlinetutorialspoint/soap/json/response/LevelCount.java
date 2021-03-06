package com.onlinetutorialspoint.soap.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelCount{
    @JsonProperty("id") 
    public String id;
    @JsonProperty("guid") 
    public String guid;
    @JsonProperty("count") 
    public String count;
}

