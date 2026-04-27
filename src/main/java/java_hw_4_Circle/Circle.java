package java_hw_4_Circle;

public class Circle {
    private double radius;

    public double circleSquare(){
        return radius*radius*Math.PI;
    }

    public double circlelength(){
        return radius*2*Math.PI;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
