package com.advspring.actuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bilgi")
public class ActuatorInfo {
	@ReadOperation
	WebEndpointResponse<Map<String, String>> bilgi() {
		Map<String, String> body = new HashMap<String, String>();
		body.put("bilgi 1", "mesaj 1");
		body.put("bilgi 2", "mesaj 2");
		int status = 200;
		return new WebEndpointResponse<Map<String, String>>(body, status);
	}

}
