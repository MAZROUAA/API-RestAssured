package Helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helpers {
    public  static String getObjectasstring(Object object)
    {
        ObjectMapper objectMapper =new ObjectMapper();
        String payload="";
        try {
            payload=objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
          //  throw new RuntimeException(e);
        }
        return payload;
    }
}
