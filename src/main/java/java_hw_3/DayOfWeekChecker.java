package java_hw_3;

import java.util.Scanner;

public class DayOfWeekChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Write down number from 1 till 7, 0 - quit: ");
        int number = sc.nextInt();

        while (number != 0) {
            System.out.println(WeekChecker(number));
            System.out.println("Write down number from 1 till 7, 0 - quit: ");
            number = sc.nextInt();
        };
        System.out.println("Bye!");



    }
    public static String WeekChecker(int number) {
        switch (number) {
            case 1: return "Понеділок";
            case 2: return "Вівторок";
            case 3: return "Середовище";
            case 4: return "Четвер";
            case 5: return "П'ятниця";
            case 6: return "Субота";
            case 7: return "Неділя";
            default: return "Введено некоректне значення.";
        }
    }
}
