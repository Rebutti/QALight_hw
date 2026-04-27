package java_hw_2;

public class ScoreEvaluator {
    public static void main(String[] args) {
        int score = 55;
        if (score >= 0 && score <= 49) {
            System.out.println("Не задовільно");
        } else if (score > 49 && score <= 69) {
            System.out.println("Задовільно");
        } else if (score > 69 && score <= 89) {
            System.out.println("Добре");
        } else if (score > 89 && score <= 100) {
            System.out.println("Відмінно");
        } else {
            System.out.println("Отримано неправильний бал");
        }
    }
}
