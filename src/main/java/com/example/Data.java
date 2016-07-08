package com.example;

import java.util.Date;

public class Data {

	protected Double temperature;
	protected Long timestamp;
	
	public Data() {
		super();
		this.timestamp = new Date().getTime();
		this.temperature = 25.5;
	}
	
	public Data(long timestamp) {
		super();
		this.timestamp = timestamp;
	}

	public Data(Double temperature, Long timestamp) {
		super();
		this.temperature = temperature;
		this.timestamp = timestamp;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [temperature=" + temperature + ", timestamp=" + new Date(timestamp) + "]";
	}

}
