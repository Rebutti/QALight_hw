package java_hw_2;

public class SumToN {
    public static void main(String[] args) {
        int i = 1;
        int n = 123;
        int sum = 0;
        while (i <= n && n > 0) {
            sum += i;
            i++;
        }
        if (sum != 0) {
            System.out.println("sum from 1 till " + n + " = " + sum);
        } else {
            System.out.println("Number N is less then one");
        }

    }
}
