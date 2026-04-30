package java_hw_11_;

public class CoffeeOrder extends Order {
    private CoffeeSize size;

    public double getPrice() {
        switch (this.size) {
            case CoffeeSize.S:
                return 34;
            case CoffeeSize.M:
                return 39;
            case CoffeeSize.L:
                return 44;
        }
        return 0;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }

    public CoffeeOrder(CoffeeSize size) {
        this.size = size;
    }

    @Override
    public void printOrderInfo() {
        System.out.println("ID: " + super.getOrderNumber() + " coffee, size - " + this.size);
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "ID='" + super.getOrderNumber() + "' " +
                "Status='" + super.getStatus() + "' " +
                "size='" + size + "' " +
                '}';
    }
}
