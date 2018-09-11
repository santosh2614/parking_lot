package com.gojek.carparking.main;

import java.util.HashMap;
import java.util.Map;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.service.GoJekParkACarService;
import com.gojek.carparking.service.GoJekCreateParkingLotService;
import com.gojek.carparking.service.GoJekParkingService;

public class RequestHandler {

	private static Map<String, GoJekParkingService> commandMap;

	public static void handleRequest(String action, String[] values) {
		if (commandMap == null) {
			prepareCommandMap();
		}
		
		GoJekParkingService service = commandMap.get(action);
		ParkingParameter param = new ParkingParameter();
		param.setValue(values);
		service.doAction(param);
	}

	public static void prepareCommandMap() {
		commandMap = new HashMap<>();

		commandMap.put("create_parking_lot", new GoJekCreateParkingLotService());
		commandMap.put("park", new GoJekParkACarService());
	}

}
