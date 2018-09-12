package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.CarParkingLot;

public class GoJekParkingLotByRegistrationNoService implements GoJekParkingService {

    @Override
    public void doAction(ParkingParameter param) {

        String registrationNo = param.getValue()[1];
        Integer result = CarParkingLot.getCarParkingLotProcessor().getRegNoCarSlotMap().get(registrationNo);
        if (result == null) {
            System.out.println(CommonConstant.NOT_FOUND);
        } else {
            System.out.println(result + 1);
        }

    }
}