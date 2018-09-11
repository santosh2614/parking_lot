package com.gojek.carparking.service;

import com.gojek.carparking.common.ParkingParameter;
import com.gojek.carparking.domain.CarParkingLot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoJekParkingLotByRegistrationNoServiceTest {

	private GoJekParkingLotByRegistrationNoService lotByRegNoService;

	private GoJekParkACarService parkingService;
	
	private GoJekCreateParkingLotService lotService;

	@Before
	public void setUp() throws Exception {
		parkingService = new GoJekParkACarService();
		lotByRegNoService = new GoJekParkingLotByRegistrationNoService();
		lotService = new GoJekCreateParkingLotService();
	}

	@After
	public void tearDown() throws Exception {
		CarParkingLot.setCarParkingLotProcessor(null);
	}

	@Test
	public void testDoAction() {
		
		ParkingParameter param = new ParkingParameter();
		param.setValue(new String[] { "create_parking_lot", "6" });
		lotService.doAction(param);
	
		
		param.setValue(new String[] { "park", "KA-01-HH-1234", "White" });
		parkingService.doAction(param);

		param.setValue(new String[] { "slot_number_for_registration_number", "KA-01-HH-3141" });
		lotByRegNoService.doAction(param);

		param.setValue(new String[] { "slot_number_for_registration_number", "KA-01-HH-1234" });
		lotByRegNoService.doAction(param);

	}

}
