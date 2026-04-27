package java_hw_4_Circle;

import java_hw_4_Student.Student;

public class circleCalculation {
    public static void main(String[] args) {
        Circle circleOne = new Circle(5);
        Circle circleTwo = new Circle(5.5);
        Circle circleThree = new Circle(1.235);
        Circle circleFour = new Circle(534.487);



        Circle[] fiveCircles = {circleOne, circleTwo, circleThree, circleFour};


        System.out.println(circleOne.circleSquare());
        System.out.println(circleOne.circlelength());

        int circleNumber = 0;
        for (int i = 0; i < fiveCircles.length; i++) {
            circleNumber = i + 1;
            System.out.println("Circle "+circleNumber+" has length: "+fiveCircles[i].circlelength());
            System.out.println("Circle "+circleNumber+" has square: "+fiveCircles[i].circleSquare());
        }
    }
}
