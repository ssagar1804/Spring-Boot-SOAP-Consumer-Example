package com.onlinetutorialspoint.soap.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class FieldDefinition{
    @JsonProperty("id") 
    public String id;
    @JsonProperty("guid") 
    public String guid;
    @JsonProperty("name") 
    public String name;
    @JsonProperty("alias") 
    public String alias;
}

