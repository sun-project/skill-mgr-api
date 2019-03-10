package jp.co.sunarch.skillmgr.entity.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonArrayConverter implements AttributeConverter<List<String>, String> {

	private Log logger = LogFactory.getLog(JsonArrayConverter.class);

	private final ObjectMapper objectMapper =
            new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
        	logger.warn(e);
        }
        return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, ArrayList.class);
        } catch (IOException e) {
        	logger.warn(e);
        }
        return null;
	}

}
