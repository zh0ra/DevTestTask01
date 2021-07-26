package org.ozhorniak.devtesttask01;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GenUtil {
	public static void getenerateRandomIntSet(int size) throws FileNotFoundException{
        System.out.println("Generate large set of itegers ...");
      try (PrintWriter printWriter = new PrintWriter("input_int.txt")) {
          int[] a = new int[size];
          Random random = new Random();
          
          for(int i = 0; i < size; i++) {
              a[i] = random.nextInt();
          }
          for (int i = 0; i < a.length; i++) {
              printWriter.print(" " + a[i]);
          }
      }
}
}
