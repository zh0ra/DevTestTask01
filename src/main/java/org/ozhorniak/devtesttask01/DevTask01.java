package org.ozhorniak.devtesttask01;

import java.util.Arrays;

public class DevTask01 {
	 public static int countDistinct(int arr[]){
		    if(arr == null && arr.length == 0) return 0;
		        return (int) Arrays.stream(arr).distinct().count();
		    }
		    
		    public static void quickSort(int[] arr, int start, int end) {

		        if (start < end) {

		            int partIndex = partition(arr, start, end);

		            quickSort(arr, start, partIndex - 1);

		            quickSort(arr, partIndex, end);
		        }
		    }

		    private static int partition(int[] arr, int start, int end) {

		        int leftIndex = start;
		        int rightIndex = end;

		        int pivot = arr[start + (end - start) / 2];
		        //int pivot = arr[0];
		        while (leftIndex <= rightIndex) {
		            while (arr[leftIndex] < pivot) {
		                leftIndex++;
		            }
		            while (arr[rightIndex] > pivot) {
		                rightIndex--;
		            }

		            if (leftIndex <= rightIndex) {
		                swap(arr, rightIndex, leftIndex);
		                leftIndex++;
		                rightIndex--;
		            }
		        }
		        return leftIndex;
		    }

		    private static void swap(int[] arr, int indx1, int indx2) {
		        int tmp = arr[indx1];
		        arr[indx1] = arr[indx2];
		        arr[indx2] = tmp;
		    }
}
