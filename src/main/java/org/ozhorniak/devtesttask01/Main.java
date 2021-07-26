package org.ozhorniak.devtesttask01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(">> Dev test. Task 1");
		long startTime = System.currentTimeMillis();
		new Main().run();
		long allTimes = System.currentTimeMillis() - startTime;
		System.out.println("\n>> " + allTimes + " ms.");
	}

	private void run() throws FileNotFoundException {
		// GenUtil.getenerateRandomIntSet(100000);
		int[] arr = readInput();
				
		taskTest01(arr, arr.length);
	}

	/**
	 * Task01 expected result: For the input: 1 10 20 20 2 5 --ozhorniak-- generated
	 * in file input_int.txt for run application with input date by command prompt
	 * we should change Scanner(System.in) expected output is: 1 2 5 10 20 count: 6
	 * distinct: 5 min: 1 max: 20
	 *
	 * @throws FileNotFoundException
	 *
	 */
	public static void taskTest01(int[] arr, int n) throws FileNotFoundException {

		System.out.println("Unsorted array:");
		// printArray(arr);
		measureTime(() -> DevTask01.quickSort(arr, 0, n - 1), "Time for quick sorting: ");
		System.out.println("Sorted array:");
		printArray(arr);

		int min = arr[0];
		int max = arr[n - 1];

		// measureTime(() -> DevTask01.countDistinct(arr), "Time for count distinct
		// elements: ");
		int distinct = DevTask01.countDistinct(arr);

		System.out.println("");
		System.out.println("count: " + n);
		System.out.println("distinct: " + distinct);
		System.out.println("min value in array: " + min);
		System.out.println("max value in array: " + max);
	}

	private static int[] generateIntArray(int size) {

		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			// arr[i] = (int) Math.round(Math.random() * 10000);
			arr[i] = random.nextInt();
		}
		return arr;
	}

	private static void printArray(final int[] arr) {

		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("[");
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				stringBuffer.append(", ");
			}
			stringBuffer.append(arr[i]);
		}
		stringBuffer.append("]");
		System.out.print(stringBuffer.toString());
	}

	public static int[] readInput() throws FileNotFoundException {

		List<Integer> inputList = new ArrayList<>();

		Scanner in = new Scanner(new File("input_int.txt"));

		//Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			inputList.add(in.nextInt());
		}

		in.close();
		int[] arr = new int[inputList.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) inputList.get(i);
		}

		return arr;
	}

	private static void measureTime(Runnable task, String notice) {
		long startTime = System.currentTimeMillis();
		task.run();
		long resultTime = System.currentTimeMillis() - startTime;
		System.out.println(notice + resultTime + " ms.");
	}
}
