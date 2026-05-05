package java_hw_11_;

import java_hw_11_.enums.TeaType;

public class TeaOrder extends Order {
    private TeaType type;

    public TeaType getType() {
        return type;
    }

    public void setType(TeaType type) {
        this.type = type;
    }

    public TeaOrder(TeaType type) {
        this.type = type;
    }

    @Override
    public void printOrderInfo(){
        System.out.println("ID: " + super.getOrderNumber() + " tea, type - " + this.type);
    }

    public double getPrice(){
        switch (this.type) {
            case BLACK:
                return 37;
            case GREEN:
                return 35;
            case HERBAL:
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
