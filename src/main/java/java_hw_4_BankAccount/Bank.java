package java_hw_4_BankAccount;

import java_hw_4_Student.Student;

public class Bank {
    public static void main(String[] args) {
        BankAccount customerOne = new BankAccount("Mykhailo", "Ovsov", 23);
        System.out.println(customerOne);
        customerOne.topUp(1);
        System.out.println(customerOne);
        System.out.println(customerOne.withdraw(1));
        System.out.println(customerOne);
        System.out.println(customerOne.withdraw(25));
        System.out.println(customerOne);
    }
}
