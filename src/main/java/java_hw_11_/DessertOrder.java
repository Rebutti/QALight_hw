package java_hw_11_;

public class DessertOrder extends Order {
    private String dessertName;

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public DessertOrder(String dessertName) {
        this.dessertName = dessertName;
    }
    public double getPrice(){
        switch (this.dessertName) {
            case "cake":
                return 300;
            case "pancake":
                return 250;
            case "candies":
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
