package com.gojek.carparking.domain;

import com.gojek.carparking.common.CommonConstant;

import java.text.MessageFormat;
import java.util.*;

public class CarParkingLot {

	private int parkingLotCapacity = 0;

	private int availability;

	private TreeSet<Integer> freeSlots;

	private Map<Integer, Car> slotCarMap;

	private Map<String, Integer> regNoCarSlotMap;

	private Map<String, List<String>> colorCarMap;

	public int getParkingLotCapacity() {
		return parkingLotCapacity;
	}

	public void setParkingLotCapacity(int parkingLotCapacity) {
		this.parkingLotCapacity = parkingLotCapacity;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public TreeSet<Integer> getFreeSlots() {
		return freeSlots;
	}

	public void setFreeSlots(TreeSet<Integer> freeSlots) {
		this.freeSlots = freeSlots;
	}

	public Map<Integer, Car> getSlotCarMap() {
		return slotCarMap;
	}

	public void setSlotCarMap(Map<Integer, Car> slotCarMap) {
		this.slotCarMap = slotCarMap;
	}

	public Map<String, Integer> getRegNoCarSlotMap() {
		return regNoCarSlotMap;
	}

	public void setRegNoCarSlotMap(Map<String, Integer> regNoCarSlotMap) {
		this.regNoCarSlotMap = regNoCarSlotMap;
	}

	public Map<String, List<String>> getColorCarMap() {
		return colorCarMap;
	}

	public void setColorCarMap(Map<String, List<String>> colorCarMap) {
		this.colorCarMap = colorCarMap;
	}

	public static CarParkingLot getCarParkingLotProcessor() {
		return carParkingLotProcessor;
	}

	public static void setCarParkingLotProcessor(CarParkingLot carParkingLotProcessor) {
		CarParkingLot.carParkingLotProcessor = carParkingLotProcessor;
	}

	private static CarParkingLot carParkingLotProcessor = null;

	//Making the class singleton
	private CarParkingLot(int parkingLotCapacity) {
		this.parkingLotCapacity = parkingLotCapacity;
		availability = parkingLotCapacity;
		freeSlots = new TreeSet<Integer>();
		for (int index = 0; index < parkingLotCapacity; index++) {
			freeSlots.add(index);
		}
		slotCarMap = new HashMap<Integer, Car>();
		regNoCarSlotMap = new HashMap<String, Integer>();
		colorCarMap = new HashMap<String, List<String>>();
		System.out.println(MessageFormat.format(CommonConstant.PARKING_LOT_CREATED, parkingLotCapacity));
	}

	public static CarParkingLot createParkingLot(int noOfParkingSlots) {
		if (carParkingLotProcessor != null) {
			return carParkingLotProcessor;
		} else {
			carParkingLotProcessor =
					new CarParkingLot(noOfParkingSlots);
			return carParkingLotProcessor;
		}

	}


}