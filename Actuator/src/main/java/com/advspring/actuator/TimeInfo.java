package com.advspring.actuator;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TimeInfo {
	private List<Double> times = new ArrayList<>();

	public void addTime(double time) {
		times.add(time);
		if (times.size() > 10000) {
			times.remove(0);
		}
	}

	public int getCount() {
		return times.size();
	}

	public double getAverage() {
		double sum = times.stream().reduce(0.0, Double::sum);
		return sum / getCount();
	}

	public void clear() {
		times.clear();
	}

	public List<Double> getTimes() {
		return times;
	}
}
