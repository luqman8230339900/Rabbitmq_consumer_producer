package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuel")
public class IOTController {

	
	@GetMapping("/getdeviceData/{deviceId}")
	public String getDataFromMultipleDataSources(@PathVariable String deviceId){
		return deviceId;
	} 

}
