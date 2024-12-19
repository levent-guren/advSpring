package com.advspring.actuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.stereotype.Component;

import com.advspring.dto.GlobalResponse;

@Component
@Endpoint(id = "bilgi")
public class ActuatorInfo {
	private static Map<String, TimeInfo> times = new HashMap<String, TimeInfo>();

	public static void addTime(String name, double time) {
		TimeInfo timeInfo = times.get(name);
		if (timeInfo == null) {
			timeInfo = new TimeInfo();
			times.put(name, timeInfo);
		}
		timeInfo.addTime(time);
	}

	@ReadOperation
	WebEndpointResponse<Map<String, TimeInfo>> info() {
		int status = 200;
		return new WebEndpointResponse<Map<String, TimeInfo>>(times, status);
	}

	@DeleteOperation
	WebEndpointResponse<GlobalResponse> clearAllTimes() {
		times.clear();
		int status = 200;
		return new WebEndpointResponse<GlobalResponse>(new GlobalResponse(), status);
	}

}
