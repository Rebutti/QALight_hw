package java_hw_3;

public class ArraySumCalculator {
    public static void main(String[] args) {
        int[] arrayOfDigits = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        for (int i = 0; i < arrayOfDigits.length; i++) {
            sum += arrayOfDigits[i];
        }
        System.out.println("Sum of all digits in arrayOfDigits: " + sum);
    }
}
