package com.hyuk84.common.serde;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class JsonSerdeFactory {

    public static <T> Serde<T> serdeFor(Class<T> clazz, ObjectMapper objectMapper) {
        JsonSerializer<T> serializer = new JsonSerializer<>(objectMapper);
        JsonDeserializer<T> deserializer = new JsonDeserializer<>(clazz, objectMapper);
        deserializer.addTrustedPackages("*");
        return Serdes.serdeFrom(serializer, deserializer);
    }
}
