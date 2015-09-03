package ua.com.lits.my.exercise2;

import java.util.Random;

public class RandomGenerator {
	
	public String generateString(int length, String characters) {
		
		Random rng = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	public int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
