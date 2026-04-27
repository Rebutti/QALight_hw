package java_hw_3;

import java.util.Arrays;

public class NegativeToZeroReplacer {
    public static void main(String[] args) {
        int[] arrayOfDigits = {-10, -1, -2, -13, -5, 6};
        System.out.println("arrayOfDigits with negative digits: " + Arrays.toString(arrayOfDigits));
        for (int i = 0; i < arrayOfDigits.length; i++) {
            if (arrayOfDigits[i] < 0) {
                arrayOfDigits[i] = 0;
            }
        }
        System.out.println("arrayOfDigits without negative digits: " + Arrays.toString(arrayOfDigits));
    }
}
