package anderk222.grades.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import anderk222.grades.validation.advice.JsonValidationRequestBodyControllerAdvice;
import anderk222.grades.validation.provider.DefaultJsonSchemaProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonSchemaValidationAutoConfiguration {

    @Autowired
    private DefaultJsonSchemaProvider jsonSchemaProvider;

    @Bean
    @ConditionalOnMissingBean
    public JsonValidationRequestBodyControllerAdvice jsonValidationRequestBodyControllerAdvice(ObjectMapper objectMapper) {
        return new JsonValidationRequestBodyControllerAdvice(objectMapper, jsonSchemaProvider);
    }

}
