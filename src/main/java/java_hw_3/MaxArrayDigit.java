package java_hw_3;

public class MaxArrayDigit {
    public static void main(String[] args) {
        int[] arrayOfDigits = {-10, -1, -3, -13, -5, 6};
        int maxDigit = 0;
        int i = 0;
        do {
            if (maxDigit < arrayOfDigits[i] && i != 0) {
                maxDigit = arrayOfDigits[i];

            } else if (i == 0) {
                maxDigit = arrayOfDigits[i];
            }
            i++;
        } while (i < arrayOfDigits.length);
        System.out.println("Max digit in arrayOfDigits: " + maxDigit);
    }
}
