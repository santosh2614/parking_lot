package com.gojek.carparking.service;

import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.CarParkingLot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoJekLeaveParkingServiceTest {

	GoJekLeaveParkingService leaveParkingService;

	private GoJekParkACarService parkingService;

	private GoJekCreateParkingLotService service;

	@Before
	public void setUp() throws Exception {
		leaveParkingService = new GoJekLeaveParkingService();
		parkingService = new GoJekParkACarService();
		service = new GoJekCreateParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
		CarParkingLot.setCarParkingLotProcessor(null);
	}

	@Test
	public void testDoAction() {

		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		service.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parkingService.doAction(param);

		param.setValue(new String[] { "leave", "1" });
		leaveParkingService.doAction(param);

		param.setValue(new String[] { "park", "KA-01-HH-1235", "White" });
		parkingService.doAction(param);

	}

}
