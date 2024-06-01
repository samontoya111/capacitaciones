package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.config.LocalDateTypeAdapter;


import java.time.LocalDate;

public class JsonUtils {
    private JsonUtils() {
    }
    public static Object jsonToObject(String json, Class<?> type) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).serializeNulls().create();
        return gson.fromJson(json, type);
    }

    public static String objectToJson(Object object)  {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).serializeNulls().create();
        return gson.toJson(object);
    }
}
