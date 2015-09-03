package ua.com.lits.my.exercise2;

import java.util.*;

import ua.com.lits.my.utils.Logger;

import java.text.*;

public class UsingDate {
	public static void main(String args[]) {
		// parsing the date according to defined format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateToParse = "1987-15-13";
		Date date;
		try {
			date = dateFormat.parse(dateToParse);
			Logger.print(dateToParse + " Parses as " + date);
			Logger.print("--------------------------------------------------------------------");
			//times subtraction
			long start = System.currentTimeMillis();
			Logger.print(new Date() + "\n");
			Thread.sleep(5 * 60 * 20);
			Logger.print(new Date() + "\n");
			long end = System.currentTimeMillis();
			long diff = end - start;
			Logger.print("Difference is : " + diff);
		} catch (ParseException ex) {
			Logger.print("Impossible to parse " + dateToParse + " value");
		} catch (Exception e) {
			Logger.print("Got an exception!");
		}
	}
}
