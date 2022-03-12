package com.danya.client.utils;

import com.danya.client.Entity.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JSONUtils {

    public static String toJSON(Client request) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(request);
    }

    public static Client JSONtoRequest(String jsonRequest) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonRequest, Client.class);
    }

}
