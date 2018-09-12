package com.gojek.carparking.main;

import java.util.HashMap;
import java.util.Map;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.service.*;

public class RequestHandler {

    private static Map<String, GoJekParkingService> commandMap;

    public static void handleRequest(String action, String[] values) {
        if (commandMap == null) {
            prepareCommandMap();
        }

        GoJekParkingService service = commandMap.get(action);
        if (service == null) {
            System.out.println(CommonConstant.WRONG_COMMAND);
            return;
        } else {
            ParkingParameter param = new ParkingParameter();
            param.setValue(values);
            service.doAction(param);
        }
    }

    public static void prepareCommandMap() {
        commandMap = new HashMap<>();

        commandMap.put("create_parking_lot", new GoJekCreateParkingLotService());
        commandMap.put("park", new GoJekParkACarService());
        commandMap.put("leave", new GoJekLeaveParkingService());
        commandMap.put("status", new GoJekParkingStatusService());
        commandMap.put("registration_numbers_for_cars_with_colour", new GoJekRegistrationNoByColorService());
        commandMap.put("slot_numbers_for_cars_with_colour", new GoJekParkingLotByColorService());
        commandMap.put("slot_number_for_registration_number", new GoJekParkingLotByRegistrationNoService());
    }

}
