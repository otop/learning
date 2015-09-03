package ua.com.lits.my.utils;

/**
 * Write logs
 *
 */
public class Logger {
	private static boolean isDebugMode = true;
	public static void print(String str){
		if (isDebugMode) {
			System.out.println(str);
		}
	}
}
