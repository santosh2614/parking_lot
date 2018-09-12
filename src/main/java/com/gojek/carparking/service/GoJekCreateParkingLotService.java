package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.CarParkingLot;

import java.text.MessageFormat;

public class GoJekCreateParkingLotService implements GoJekParkingService {

    @Override
    public void doAction(ParkingParameter param) throws NumberFormatException {
        try {

            Integer capacity = Integer.valueOf((String) param.getValue()[1]);
            if (capacity > 0) {
                CarParkingLot carParkingLot = CarParkingLot.createParkingLot(capacity);
                System.out.println(MessageFormat.format(CommonConstant.PARKING_LOT_CREATED, capacity));
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println(CommonConstant.ERROR_PARKING_LOT);
        }

    }

}
