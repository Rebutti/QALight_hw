package java_hw_5.Passangers;

public class Vehicle {
    private String name;
    private int speed;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String move() {
        return this.name +" is moving with speed " + this.speed + " kilometres in an hour";
    }

    public String stop() {
        return "Vehicle "+ this.name +" stopped ";
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
