package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.domain.CarParkingLot;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class GoJekParkACarService implements GoJekParkingService {

    @Override
    public void doAction(ParkingParameter param) {
        Integer availability = CarParkingLot.getCarParkingLotProcessor().getAvailability();

        if (availability == 0) {
            System.out.println(CommonConstant.PARKING_FULL);
            return;
        } else {
            Car car = new Car(param.getValue()[1], param.getValue()[2]);
            CarParkingLot object = CarParkingLot.getCarParkingLotProcessor();
            TreeSet<Integer> freeSlots = object.getFreeSlots();
            Integer slot = freeSlots.first();
            Map<Integer, Car> slotCarMap = object.getSlotCarMap();
            slotCarMap.put(slot, car);
            object.setSlotCarMap(slotCarMap);
            availability--;
            object.setAvailability(availability);
            freeSlots.remove(slot);
            object.setFreeSlots(freeSlots);
            Map<String, Integer> regNoCarSlotMap = object.getRegNoCarSlotMap();
            Map<String, List<String>> colorCarMap = object.getColorCarMap();
            regNoCarSlotMap.put(car.getRegistrationNo(), slot);
            object.setRegNoCarSlotMap(regNoCarSlotMap);
            if (colorCarMap.containsKey(car.getColor())) {
                List<String> regNoList = colorCarMap.get(car.getColor());
                colorCarMap.remove(car.getColor());
                regNoList.add(car.getRegistrationNo());
                colorCarMap.put(car.getColor(), regNoList);
            } else {
                // LinkedList because frequent updation is required . Time Complexity -> O(1)
                LinkedList<String> regNoList =
                        new LinkedList<String>();
                regNoList.add(car.getRegistrationNo());
                colorCarMap.put(car.getColor(), regNoList);
            }
            object.setColorCarMap(colorCarMap);
            System.out.println(MessageFormat.format(CommonConstant.PARKING_SPACE_BLOCKED, slot + 1,
                    car.getRegistrationNo()));
        }
    }

}
