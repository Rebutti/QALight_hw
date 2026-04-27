package java_hw_3;

public class TriangleChecker {
    public static void main(String[] args) {
        System.out.println(isTriangle(3, 4, 5));

    }

    public static String isTriangle(int a, int b, int c) {
        if (a + b > c && c + b > a && a + c > b) {
            return "It`s triangle";
        }else {
            return "It is not triangle";
        }
    }

}
