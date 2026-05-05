package java_hw_11_;

import java_hw_11_.enums.DessertName;

public class DessertOrder extends Order {
    private DessertName dessertName;

    public DessertName getDessertName() {
        return dessertName;
    }

    public void setDessertName(DessertName dessertName) {
        this.dessertName = dessertName;
    }

    public DessertOrder(DessertName dessertName) {
        this.dessertName = dessertName;
    }
    public double getPrice(){
        switch (this.dessertName) {
            case CAKE:
                return 300;
            case PANCAKE:
                return 250;
            case CANDIES:
                return 51;
        }
        return 0;
    }

    @Override
    public void printOrderInfo(){
        System.out.println("ID: " + super.getOrderNumber() + " dessert - " + this.dessertName);
    }

    @Override
    public String toString() {
        return "DessertOrder{" +
                "ID='" + super.getOrderNumber() + "' " +
                "Status='" + super.getStatus() + "' " +
                "dessertName='" + dessertName + '\'' +
                '}';
    }
}
