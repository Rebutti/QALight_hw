package java_hw_2;

public class NumberComparator {
    public static void main(String[] args) {
        int firstNumber = 1;
        int secondNumber = 2;
        if (firstNumber > secondNumber) {
            System.out.println("The first number (" + firstNumber + ") is bigger then the second number (" + secondNumber + ")");
        } else if (firstNumber < secondNumber) {
            System.out.println("The first number (" + firstNumber + ") is lower then the second number (" + secondNumber + ")");
        } else {
            System.out.println("The first number (" + firstNumber + ") is equal to the second number (" + secondNumber + ")");
        }
    }
}
