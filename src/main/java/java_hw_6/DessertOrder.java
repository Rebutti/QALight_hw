package java_hw_6;

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
}
