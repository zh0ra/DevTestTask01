package org.ozhorniak.devtesttask01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author OZhorniak
 *
 */
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
		int[] arr = TaskUtil.readInput();		
		taskTest01(arr, arr.length);
	}

	public static void taskTest01(int[] arr, int n) throws FileNotFoundException {

		System.out.println("Unsorted array:");
		//measureTime(() -> DevTask01.quickSort(arr, 0, n - 1), "Time to sorting: ");
		TaskUtil.measureTime(() -> Arrays.sort(arr), "Time to sorting");
		System.out.println("Sorted array:");
		TaskUtil.printArray(arr);

		int min = arr[0];
		int max = arr[n - 1];
		
		int distinct = countDistinct(arr);

		System.out.println("");
		System.out.println("count: " + n);
		System.out.println("distinct: " + distinct);
		System.out.println("min value in array: " + min);
		System.out.println("max value in array: " + max);
	}

	public static int countDistinct(int arr[]){
	    if(arr == null && arr.length == 0) return 0;
	        return (int) Arrays.stream(arr).distinct().count();
	    }
}
