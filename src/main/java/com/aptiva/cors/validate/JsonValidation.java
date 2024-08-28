package com.aptiva.cors.validate;

import java.io.InputStream;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.networknt.schema.SpecVersion;
import com.aptiva.model.Customer;
import com.aptiva.model.GPSData;
import com.aptiva.model.Sales;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JsonValidation {

	public static Set<ValidationMessage> validateJsonMessage(Object message, String type) {
		// TODO Auto-generated method stub
		Set<ValidationMessage> errors = null;
		if (type.equals("GPS")) {
			GPSData gpsMsg = (GPSData) message;
			InputStream schemaAsStream = JsonValidation.class.getClassLoader()
					.getResourceAsStream("schemas/gpsJsonSchema.json");
			JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(schemaAsStream);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = null;
			try {
				json = ow.writeValueAsString(gpsMsg);
				log.info("json String {}", json);
				log.info("json toString {}", json.toString());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(json);
				errors = schema.validate(jsonNode);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (type.equals("Sales")) {
			Sales gpsMsg = (Sales) message;
			InputStream schemaAsStream = JsonValidation.class.getClassLoader()
					.getResourceAsStream("schemas/salesJsonSchema.json");
			JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(schemaAsStream);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = null;
			try {
				json = ow.writeValueAsString(gpsMsg);
				log.info("json sales String {}", json);
				log.info("json toString {}", json.toString());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(json);
				errors = schema.validate(jsonNode);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (type.equals("Customer")) {
			Customer gpsMsg = (Customer) message;
			InputStream schemaAsStream = JsonValidation.class.getClassLoader()
					.getResourceAsStream("schemas/customerJsonSchema.json");
			JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(schemaAsStream);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = null;
			try {
				json = ow.writeValueAsString(gpsMsg);
				log.info("json String {}", json);
				log.info("json toString {}", json.toString());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(json);
				errors = schema.validate(jsonNode);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return errors;
	}

}
