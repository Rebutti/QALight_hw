package java_hw_10;

public class TeaOrder extends Order {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TeaOrder(String type) {
        this.type = type;
    }

    @Override
    public void printOrderInfo(){
        System.out.println("ID: " + super.getOrderNumber() + " tea, type - " + this.type);
    }

    public double getPrice(){
        switch (this.type) {
            case "black":
                return 37;
            case "green":
                return 35;
            case "herbal":
                return 40;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "TeaOrder{" +
                "type='" + type + '\'' +
                "status='" + super.getStatus() + '\'' +
                '}';
    }
}
