package com.onlinetutorialspoint.soap.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("count") 
    public String count;
    @JsonProperty("Metadata") 
    public Metadata metadata;
    @JsonProperty("LevelCounts") 
    public LevelCounts levelCounts;
    @JsonProperty("Record") 
    public Record record;
}

