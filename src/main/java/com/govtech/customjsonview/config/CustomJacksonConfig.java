package com.govtech.customjsonview.config;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomJacksonConfig {

    /*
    * For custom view we don't need to create separate DTOs
    * We can use @JsonView annotation and for this we need to disable DEFAULT_VIEW_INCLUSION
    * Otherwise non-annotated field will also serialize in controller endpoint.
    * */
    @Bean
    public ObjectMapper objectMapper() {
       return JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .disable(MapperFeature.DEFAULT_VIEW_INCLUSION)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
                .build();
    }

}
