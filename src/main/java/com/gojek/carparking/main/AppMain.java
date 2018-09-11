package com.gojek.carparking.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {

	public static void main(String[] args) {

		switch (args.length) {
		case 0:
			System.out.println("Please enter 'exit' to quit");
			System.out.println("Waiting for input...");

			for (;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("exit")) {
						break;
					} else if ((inputString == null) || (inputString.isEmpty())) {

					} else {
						CommandFileParser.parseTextInput(inputString.trim());
					}
				} catch (IOException e) {
					System.out.println("Oops! Error in reading the input from console.");
					e.printStackTrace();
				}
			}
			break;
		case 1:
			CommandFileParser.parseInputFile(args[0]);
			break;
		default:
			String filePath = "src/main/resources/input.txt";
			CommandFileParser.parseInputFile(filePath);
		}

	}

}
