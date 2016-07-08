package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DataLogger {
	
	protected List<Data> data;
	
	private final static long timespan = 86400000;
	private final static int records = 10;

	public DataLogger() {
		super();
		this.data = new ArrayList<Data>();
		long now = new Date().getTime();
		this.addData(RandomDataGenerator.generateRandomData(now - timespan, now, records));
	}

	public DataLogger(List<Data> data) {
		super();
		this.data = data;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
	
	public void addData(Data item) {
		if (data != null) {
			if (item != null) {
				data.add(item);
			}
		}
	}
	
	public void addData(List<Data> items) {
		if (data != null) {
			if (items != null && !items.isEmpty()) {
				data.addAll(items);
			}
		}
	}
	
	public List<Data> getData(long from, long to) {
		if (from == 0 && to == Long.MAX_VALUE) {
			return data;
		}
		System.out.println("List: " + data);
		System.out.println("From :" + new Date(from));
		System.out.println("To :" + new Date(to));
		int startIndex = getStartIndex(from);
		int endIndex = getEndIndex(to);
		if (startIndex >= 0) {
			return data.subList(startIndex, endIndex);
		} else {
			return new ArrayList<Data>();
		}
	}
	
	private int getStartIndex(long from) {
		int index = -1;
		for (Data d : data) {
			if(d.getTimestamp().compareTo(from) > 0) {
				index = data.indexOf(d);
				break;
			} else {
				index = 0;
			}
		}
		return index;
	}
	
	private int getEndIndex(long to) {
		int index = data.size()-1;
		for (Data d : data) {
			if(d.getTimestamp().compareTo(to) > 0) {
				index = data.indexOf(d)-1;
				break;
			} else {
				index = data.size()-1;
			}
		}
		return index;
	}
	
	public void removeData(Data item) {
		if (data != null) {
			if (data.contains(item)) {
				data.remove(item);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "DataLogger [data=" + data + "]";
	}

	
}
