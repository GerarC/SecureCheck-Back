package co.edu.udea.securecheck.configuration.utils;

import co.edu.udea.securecheck.configuration.utils.exceptions.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonParser {

    private JsonParser(){
        throw new IllegalStateException("Utility class");
    }

    public static String toJson(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
