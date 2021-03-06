package com.onlinetutorialspoint.soap.json.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Record{
    @JsonProperty("contentId") 
    public String contentId;
    @JsonProperty("levelId") 
    public String levelId;
    @JsonProperty("levelGuid") 
    public String levelGuid;
    @JsonProperty("moduleId") 
    public String moduleId;
    @JsonProperty("parentId") 
    public String parentId;
    @JsonProperty("Field") 
    public List<Field> field;
}

