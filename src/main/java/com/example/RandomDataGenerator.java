package com.example;

import java.util.ArrayList;
import java.util.List;

public class RandomDataGenerator {
	
	private final static double tempMin = 18.0;
	private final static double tempMax = 32.0;

	public static Data generateRandomData() {
		return null;
	}

	public static List<Data> generateRandomData(Long from, Long to, int items) {
		List<Data> data = new ArrayList<Data>();
		long timespan = (Math.abs(to-from))/(items + 1);
		for(int i = 1 ; i <= items; i++) {
			double temp = randomDoubleInRange(tempMin, tempMax);
			long timestamp = from + (i * timespan);
			data.add(new Data(temp, timestamp));
		}
		return data;
	}

	private static double randomDoubleInRange(double min, double max)
	{
		double range = (max - min);     
		return (Math.random() * range) + min;
	}
}
