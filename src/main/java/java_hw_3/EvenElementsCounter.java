package java_hw_3;

public class EvenElementsCounter {
    public static void main(String[] args) {
        int[] arrayOfDigits = {-10, -1, -2, -13, -5, 6};
        int evenDigits = 0;
        for (int i = 0; i < arrayOfDigits.length; i++) {
            if(arrayOfDigits[i]%2 == 0){
                evenDigits++;
            }
        }
        System.out.println("Emount of even digits in arrayOfDigits: " + evenDigits);
    }
}
