package com.gojek.carparking.service;

import com.gojek.carparking.common.CommonConstant;
import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.CarParkingLot;

import java.util.List;

public class GoJekRegistrationNoByColorService implements GoJekParkingService {

	@Override
	public void doAction(ParkingParameter param) {
		String color = param.getValue()[1];
		List<String> regNoList = CarParkingLot.getCarParkingLotProcessor().getColorCarMap().get(color);
		if(regNoList == null) {
			System.out.println(CommonConstant.NOT_FOUND);
		}
		else
		{
		for (int index = 0; index < regNoList.size(); index++) {
			if (!(index == regNoList.size() - 1)) {
				System.out.print(regNoList.get(index) + ",");
			} else {
				System.out.print(regNoList.get(index));
			}
		}
		System.out.println();
	}

	}

}