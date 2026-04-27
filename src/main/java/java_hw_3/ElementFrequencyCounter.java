package java_hw_3;

import java.util.Scanner;

import java.util.Arrays;

public class ElementFrequencyCounter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Write down number which frequency you want find in array: ");
        int number = sc.nextInt();
        System.out.println(number);

        int[] arrayOfDigits = {-10, -1, 2, -13, -5, 6, 6, 2, -13, -5, -13};
        int amountOfNumberFrequency = 0;

        for (int i = 0; i < arrayOfDigits.length; i++) {
            if (number == arrayOfDigits[i]) {
                amountOfNumberFrequency++;
            }
        }
        System.out.println("frequency of number " + number + ": " + amountOfNumberFrequency);
    }
}
