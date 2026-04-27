package java_hw_7;

public class CoffeeOrder extends Order {
    private String size;

    public double getPrice(){
        switch (this.size) {
            case "S":
                return 34;
            case "M":
                return 39;
            case "L":
                return 44;
        }
        return 0;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public CoffeeOrder(String size) {
        this.size = size;
    }

    @Override
    public void printOrderInfo(){
        System.out.println(super.getOrderNumber());
    }
}
