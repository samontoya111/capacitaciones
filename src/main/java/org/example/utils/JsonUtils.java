package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.example.config.LocalDateTypeAdapter;

import java.time.LocalDate;

@Slf4j
public class JsonUtils {
    private JsonUtils() {
    }

    public static Object jsonToObject(String json, Class<?> type) throws JsonSyntaxException {
        Object result = null;
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).serializeNulls().create();
            result = gson.fromJson(json, type);
        } catch (JsonSyntaxException je) {
            log.error(je.getMessage());
        }
        return result;
    }

    public static String objectToJson(Object object)  {
        String json = "";
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).serializeNulls().create();
            json = gson.toJson(object);
        } catch (JsonSyntaxException je) {
            log.error(je.getMessage());
        }
        return json;
    }
}
