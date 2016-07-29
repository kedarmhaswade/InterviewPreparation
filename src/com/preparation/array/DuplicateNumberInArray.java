package com.preparation.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateNumberInArray {
	public static void printDuplicate1(int[] array) {
		System.out.println("Simpe way to find the duplicate elements");
		System.out.println("Using nested loops");
		System.out.println("Time complexity = O(n^2) , Space Complexity = O(1)");
		System.out.println("This solution does not assume any prior conditions. Will work on any conditions.");
		Set<Integer> duplicates = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					duplicates.add(array[i]);
					break;
				}
			}
		}
		System.out.println("The duplicates are: ");
		System.out.println(duplicates.toString());
	}

	public static void printDuplicate2(int[] array) {
		System.out.println("Will \"ASSUME\" that the input is within some given range.");
		System.out.println("And that range is 0 to size");
		int[] count = new int[array.length + 1];
		int c = 0;
		System.out.println("Traverse the array once and populate the count for each element");
		for (int i = 0; i < array.length; i++) {
			count[array[i]] += 1;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 1) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 3, 5, 6, 6, 7, 3, 4, 9, 1, 2 };
		printDuplicate1(array);
		int[] array2 = new int[] { 1, 2, 6, 5, 5, 6, 7 };
		printDuplicate2(array2);
	}
}
