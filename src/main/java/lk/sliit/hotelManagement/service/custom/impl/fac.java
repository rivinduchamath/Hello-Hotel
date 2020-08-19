package lk.sliit.hotelManagement.service.custom.impl;



import java.util.Scanner;

public class fac {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter No Of count ");
        int count = scan.nextInt();

        int[] list = new int[count];
        for (int i = 0; i < list.length; i++) {
            list[i] = scan.nextInt();
        }
        int length = list.length;
        length = removeDuplicateElements(list, length);
        //printing array elements
        for (int i=0; i<length; i++)  {
            System.out.println(factorial(list[i]));
        }
    }

    // method to find factorial of given number
    static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
    public static int removeDuplicateElements(int arr[], int n){
        if (n==0 || n==1){
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }

}
