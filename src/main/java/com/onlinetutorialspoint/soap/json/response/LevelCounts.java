package com.onlinetutorialspoint.soap.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelCounts{
    @JsonProperty("LevelCount") 
    public LevelCount levelCount;
}

