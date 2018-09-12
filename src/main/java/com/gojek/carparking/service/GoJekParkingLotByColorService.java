package com.gojek.carparking.service;

import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.CarParkingLot;

import java.util.ArrayList;
import java.util.List;


public class GoJekParkingLotByColorService implements GoJekParkingService {

    @Override
    public void doAction(ParkingParameter param) {
        String color = param.getValue()[1];
        CarParkingLot object = CarParkingLot.getCarParkingLotProcessor();
        List<String> regNoList = object.getColorCarMap().get(color);
        List<Integer> slotList = new ArrayList<Integer>();
        for (int index = 0; index < regNoList.size(); index++) {
            slotList.add(Integer.valueOf(object.getRegNoCarSlotMap().get(regNoList.get(index))));
        }
        for (int index = 0; index < slotList.size(); index++) {
            if (!(index == slotList.size() - 1)) {
                System.out.print(slotList.get(index) + 1 + ", ");
            } else {
                System.out.print(slotList.get(index) + 1);
            }
        }
        System.out.println();
    }

}
