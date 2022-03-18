package utils;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DataObjectMapper {
    public <T> T mapDataToObject(String dataOutput, Class<T> className) throws JsonProcessingException;
}
