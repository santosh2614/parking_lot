package com.gojek.carparking.service;

import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.domain.CarParkingLot;

public class GoJekParkingStatusService implements GoJekParkingService {

    @Override
    public void doAction(ParkingParameter param) {
        CarParkingLot object = CarParkingLot.getCarParkingLotProcessor();
        if (object.getSlotCarMap().isEmpty()) {
            System.out.println("Parking lot is empty");
            return;
        } else {
            System.out.println("Lot No" + "    " + "Registration No" + "    " + "Color");
            Car car;
            for (int index = 0; index < object.getParkingLotCapacity() - object.getAvailability(); index++) {
                if (object.getSlotCarMap().containsKey(index)) {
                    car = object.getSlotCarMap().get(index);
                    System.out.println(index + 1 + "\t" + car.getRegistrationNo() + "\t" + car.getColor());
                }
            }
            System.out.println();
        }
    }

}
