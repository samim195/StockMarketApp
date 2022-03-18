package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataObjectMapperImpl implements DataObjectMapper {

    ObjectMapper objectMapper;

    @Override
    public <T> T mapDataToObject(String dataOutput, Class<T> className) throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        return objectMapper.readValue(dataOutput, className);

    }
}
