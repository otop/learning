package ua.com.lits.my.exercise2;

import java.util.ArrayList;

import java.util.Date;

import ua.com.lits.my.utils.Logger;

public class UsingRandom {
	private static String characters = "1234567890";

	public static void main(String[] args) {
		RandomGenerator randomString = new RandomGenerator();
		int arrayLength = randomString.randBetween(5, 20);
		ArrayList<String> stringArray = new ArrayList<String>();
		for (int i = 0; i < arrayLength; i++) {
			String string = randomString.generateString(randomString.randBetween(6, 15), characters);
			stringArray.add(string);
		}

		Logger.print("Array List of random generated strings: " + "\n" + stringArray + "\n");
		Logger.print("-----------------------------------------------------------------");
		Logger.print("Parsing long to date:" + "\n");
		for (int j = 0; j < stringArray.size(); j++) {
			System.out.println(new Date(Long.parseLong(stringArray.get(j))));
		}
	}

}
