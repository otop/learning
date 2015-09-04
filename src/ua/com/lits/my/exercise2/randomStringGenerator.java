package ua.com.lits.my.exercise2;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author http://stackoverflow.com/questions/31260512/generate-a-secure-random-password-in-java-with-minimum-special-character-require
 *
 */
public class randomStringGenerator {

	private final List<StringSet> stSets;
	private final char[] allCharacters;
	private final int minLength;
	private final int maxLength;
	private final int presetCharacterCount;

	/**
	 * Generates random string
	 * @param origStSets
	 * @param minLength
	 * @param maxLength
	 */
	public randomStringGenerator(Collection<StringSet> origStSets, int minLength, int maxLength) {
		this.minLength = minLength;
		this.maxLength = maxLength;

		// Make a copy of the character arrays and min-values so they cannot be
		// changed after initialization
		int stCharacters = 0;
		int preallocatedCharacters = 0;
		List<StringSet> stSets = new ArrayList<StringSet>(origStSets.size());
		for (StringSet origStSet : origStSets) {
			StringSet newStSet = new StSet(origStSet);
			stSets.add(newStSet);
			stCharacters += newStSet.getCharacters().length;
			preallocatedCharacters += newStSet.getMinCharacters();
		}
		this.presetCharacterCount = preallocatedCharacters;
		this.stSets = Collections.unmodifiableList(stSets);

		if (minLength < presetCharacterCount) {
			throw new IllegalArgumentException("Combined minimum lengths " + presetCharacterCount
					+ " are greater than the minLength of " + minLength);
		}

		// Copy all characters into single array so we can evenly access all
		// members when accessing this array
		char[] allChars = new char[stCharacters];
		int currentIndex = 0;
		for (StringSet stSet : stSets) {
			char[] chars = stSet.getCharacters();
			System.arraycopy(chars, 0, allChars, currentIndex, chars.length);
			currentIndex += chars.length;
		}
		this.allCharacters = allChars;
	}
	
	/**
	 * generates array list of random strings
	 * @return array list of random strings
	 */
	public char[] generateString() {
		SecureRandom rand = new SecureRandom();

		// Set st length to minLength <= stLength <= maxLength
		int stLength = minLength + rand.nextInt(maxLength - minLength + 1);
		int randomCharacterCount = stLength - presetCharacterCount;

		// Place each index in an array then remove them randomly to assign
		// positions in the st array
		List<Integer> remainingIndexes = new ArrayList<Integer>(stLength);
		for (int i = 0; i < stLength; ++i) {
			remainingIndexes.add(i);
		}

		// Fill st array
		char[] st = new char[stLength];
		for (StringSet stSet : stSets) {
			addRandomCharacters(st, stSet.getCharacters(), stSet.getMinCharacters(), remainingIndexes, rand);
		}
		addRandomCharacters(st, allCharacters, randomCharacterCount, remainingIndexes, rand);
		return st;
	}

	/**
	 * Add random chars to the string in the list
	 * @param st
	 * @param characterSet
	 * @param numCharacters
	 * @param remainingIndexes
	 * @param rand
	 */
	private static void addRandomCharacters(char[] st, char[] characterSet, int numCharacters,
			List<Integer> remainingIndexes, Random rand) {
		for (int i = 0; i < numCharacters; ++i) {
			// Get and remove random index from the remaining indexes
			int stIndex = remainingIndexes.remove(rand.nextInt(remainingIndexes.size()));

			// Set random character from character index to pwIndex
			int randCharIndex = rand.nextInt(characterSet.length);
			st[stIndex] = characterSet[randCharIndex];
		}
	}

	public static interface StringSet {
		char[] getCharacters();

		int getMinCharacters();
	}

	/**
	 * Defensive copy of a passed-in PasswordCharacterSet
	 */
	private static final class StSet implements StringSet {
		private final char[] chars;
		private final int minChars;

		public StSet(StringSet stSet) {
			this.minChars = stSet.getMinCharacters();
			char[] stSetChars = stSet.getCharacters();
			// Defensive copy
			this.chars = Arrays.copyOf(stSetChars, stSetChars.length);
		}

		@Override
		public char[] getCharacters() {
			return chars;
		}

		@Override
		public int getMinCharacters() {
			return minChars;
		}
	}
}