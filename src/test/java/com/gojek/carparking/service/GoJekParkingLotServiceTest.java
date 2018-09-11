package com.gojek.carparking.service;

import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.Car;
import com.gojek.carparking.domain.CarParkingLot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoJekParkingLotServiceTest {

	private GoJekCreateParkingLotService service;

	@Before
	public void setUp() throws Exception {
		service = new GoJekCreateParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
		CarParkingLot.setCarParkingLotProcessor(null);
	}

	@Test
	public void testDoAction() {
		int maxSize = 6;
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doAction(param);
		Integer availablity = CarParkingLot.getCarParkingLotProcessor().getAvailability();
		assertTrue(maxSize == availablity);

	}

}
