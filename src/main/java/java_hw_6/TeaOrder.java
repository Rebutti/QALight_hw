package java_hw_6;

public class TeaOrder extends Order{
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

}
