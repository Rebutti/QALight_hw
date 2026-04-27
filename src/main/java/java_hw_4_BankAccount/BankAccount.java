package java_hw_4_BankAccount;

import java.util.Random;

public class BankAccount {
    private long bankId;
    private String name;
    private String surname;
    private long customerBalance;


    public void topUp(long amount) {
        this.customerBalance += amount;
        return;
    }

    public String withdraw(long amount) {
        if (amount <= this.customerBalance) {
            this.customerBalance -= amount;
            return "Issued: "+amount+"$";
        }
        else {
            return "You don't have that much money";
        }
    }

    public BankAccount(String name, String surname, long customerBalance) {
        this.name = name;
        this.surname = surname;
        this.customerBalance = customerBalance;
        Random random = new Random();
        this.bankId = Math.abs(random.nextLong());
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "bankId=" + bankId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", customerBalance=" + customerBalance +
                '}';
    }
}
