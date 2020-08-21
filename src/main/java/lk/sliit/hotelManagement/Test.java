package lk.sliit.hotelManagement;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Test {

    // Complete the solve function below.
    static boolean test(double n1, double k) {
       if(n1 == 1){
           return false;
       }

        double N=  (n1/k);


        for (int x=2; x<N; x++) {
            if (N % x == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        //computePrimeNumbers(P_LIMIT, primeNumbers);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] NArray = new long[T];
        long[] KArray = new long[T];
        for(int i = 0; i < T; i++) {
            NArray[i] = sc.nextLong();
            KArray[i] = sc.nextLong();
        }


        for(int i = 0; i < T; i++) {

            if(test(NArray[i],KArray[i])) {
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }
}