package com.model;

import java.io.Serializable;

public class DeviceStats  implements Serializable  {
	
	int device_id;
	int battery;
	int temp;
	int humidity;
	int wifi;
	long time;
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
		
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
	public int getWifi() {
		return wifi;
	}
	public void setWifi(int wifi) {
		this.wifi = wifi;
	}
	@Override
	public String toString() {
		return "device_id=" + device_id + ", battery=" + battery + ", temp=" + temp + ", humidity=" + humidity
				+ ", time=" + time + ", wifi=" + wifi + "\n";
	}
	

}
