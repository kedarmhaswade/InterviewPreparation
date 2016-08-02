package com.preparation.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumNoOfCoins {

	public static Integer getMinCoins(Integer value, Integer[] availableCoinDenominations) {
		int coins = 0;
		Arrays.sort(availableCoinDenominations, Collections.reverseOrder(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int returnValue;
				if (o1 == o2) {
					returnValue = 0;
				}
				if (o1 > o2) {
					returnValue = 1;
				} else {
					returnValue = -1;
				}
				return returnValue;
			}
		}));
		int length = availableCoinDenominations.length;
		while (value > 0) {
			boolean found = false;
			for (int i = 0; i < length; i++) {
				if (availableCoinDenominations[i] <= value) {
					found = true;
					value -= availableCoinDenominations[i];
					coins++;
					break;
				}
			}
			if (!found) {
				coins++;
				break;
			}
		}
		return coins;
	}

	public static int getMinCoins2(int value, int[] availbaleCoinDenominations) {
		// This is a very interesting solution.
		// Create two arrays, of length = value + 1.
		// That is each value between 1 to 'value' has an index in each of the
		// arrays.
		// Therefore arrays will be of length value + 1. (indexes for 0 to n)

		int[] valueArray = new int[value + 1];
		// Initialize this array with Infinity, i.e with Integer.Max value.
		Arrays.fill(valueArray, Integer.MAX_VALUE - 1);
		valueArray[0] = 0;
		int[] resultArray = new int[value + 1];
		Arrays.fill(resultArray, -1);

		// Thus, the arrays are now initialized. This is a bottom up solution.
		// Why?
		// Because the solution is built in the bottom up fashion, meaning
		// the min no. of coins are calculated for all the values between 1 to
		// n.

		// The algorithm goes like this,
		// For every coin denomination, check, if using this coin will make the
		// number of coins minimum for the total under consideration.

		// The loop is run for all the available coin denominations.
		for (int i = 0; i < availbaleCoinDenominations.length; i++) {
			// Check if this coin helps in building minimum coins for the
			// total.
			for (int j = 1; j <= value; j++) {
				// check the ith coin can be useful to form the value of j.
				if (j >= availbaleCoinDenominations[i]) {
					if (valueArray[j - availbaleCoinDenominations[i]] + 1 < valueArray[j]) {
						valueArray[j] = 1 + valueArray[j - availbaleCoinDenominations[i]];
						resultArray[j] = i;
					}
				}
			}
		}

		return valueArray[value];
	}

	public static void main(String[] args) {
		System.out.println(getMinCoins(7, new Integer[] { 1, 2, 3 }));
		System.out.println(getMinCoins2(7, new int[] { 1, 2, 3 }));
	}
}
