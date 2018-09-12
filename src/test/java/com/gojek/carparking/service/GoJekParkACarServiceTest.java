package com.gojek.carparking.service;

import com.gojek.carparking.domain.Car;
import com.gojek.carparking.domain.CarParkingLot;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.gojek.carparking.common.ParkingParameter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoJekParkACarServiceTest {

    private GoJekCreateParkingLotService lotService;

    private GoJekParkACarService service;

    @Before
    public void setUp() throws Exception {
        service = new GoJekParkACarService();
        lotService = new GoJekCreateParkingLotService();
    }

    @After
    public void tearDown() throws Exception {
        CarParkingLot.setCarParkingLotProcessor(null);
    }

    @Test
    public void testDoAction() {

        ParkingParameter param = new ParkingParameter();
        param.setValue(new String[]{"create_parking_lot", "6"});
        lotService.doAction(param);

        param.setValue(new String[]{"park", "KA-01-HH-1234", "White"});
        service.doAction(param);
        int availablity = CarParkingLot.getCarParkingLotProcessor().getAvailability();
        Assert.assertEquals(5, availablity);
    }

}
