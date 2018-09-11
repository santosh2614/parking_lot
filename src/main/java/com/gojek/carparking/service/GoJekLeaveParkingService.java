package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.domain.CarParkingLot;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class GoJekLeaveParkingService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {

		try {
			Integer slot = Integer.parseInt(param.getValue()[1]) - 1;
			CarParkingLot object = CarParkingLot.getCarParkingLotProcessor();
			Map<Integer,Car> slotCarMap = object.getSlotCarMap();
			Car car = slotCarMap.get(slot);
			if (car == null) {
				System.out.println(CommonConstant.NOT_FOUND);
				return;
			}
			else {
				slotCarMap.remove(slot);
				Map<String,Integer> regNoCarSlotMap = object.getRegNoCarSlotMap();
				regNoCarSlotMap.remove(car.getRegistrationNo());
				Map<String,List<String>> colorCarMap = object.getColorCarMap();
				List<String> regNoList = colorCarMap.get(car.getColor());
				if (regNoList.contains(car.getRegistrationNo())) {
					regNoList.remove(car.getRegistrationNo());
				}
				// Add the Lot No. back to available sorted slot set .
				TreeSet<Integer> freeSlots = object.getFreeSlots();
				freeSlots.add(slot);
				object.setAvailability(object.getAvailability()+1);
				System.out.println(MessageFormat.format(CommonConstant.SLOT_FREE, slot+1));
			}
		}
		catch (NumberFormatException ex) {
			System.out.println(CommonConstant.ERROR_INVALID_SPACE_NO);
			return;
		}

	}

}
