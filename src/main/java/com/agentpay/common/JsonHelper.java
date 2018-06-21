package com.agentpay.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
    public static String objToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String json= objectMapper.writeValueAsString(object);
        return json;
    }

    public static Object jsonToObj(String json){
        return  null;
    }
}
