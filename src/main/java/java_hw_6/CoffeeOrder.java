package java_hw_6;

public class CoffeeOrder extends Order {
    private String size;

    public double getPrice(){
        switch (this.size) {
            case "SMALL":
                return 34;
            case "MEDIUM":
                return 39;
            case "LARGE":
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

}
