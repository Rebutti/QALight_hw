package java_hw_2;

public class NumberSignChecker {
    public static void main(String[] args) {
        int number = 10;
        if (number < 0){
            System.out.println("Number is negative");
        } else if (number > 0) {
            System.out.println("Number is positive");
        }
        else{
            System.out.println("Number is zero");
        }
    }
}
