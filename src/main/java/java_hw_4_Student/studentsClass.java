package java_hw_4_Student;

public class studentsClass {
    public static void main(String[] args) {
        Student misha = new Student("Mykhailo", "Ovsov", 23);
        Student lesha = new Student("Alexey", "Popov", 46);
        Student vasiya = new Student("Vasiliy", "Ivanov", 19);
        Student masha = new Student("Mariia", "Sedova", 22);
        Student olya = new Student("Olga", "Belogorodko", 25);

        Student[] fiveStudents = {misha, lesha, vasiya, masha, olya};

        for (int i = 0; i < fiveStudents.length; i++) {
            System.out.println(fiveStudents[i].fullName());
        }

    }
}
