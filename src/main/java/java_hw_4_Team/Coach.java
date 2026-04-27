package java_hw_4_Team;

import java_hw_4_Student.Student;

import java.util.Scanner;

public class Coach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student misha = new Student("Mykhailo", "Ovsov", 23);
        Student lesha = new Student("Alexey", "Popov", 46);

        String name;
        String surname;
        int age;

        Team teams = new Team();
        teams.addStudent(misha);
        System.out.println(teams);
        teams.addStudent(lesha);
        System.out.println(teams);
        System.out.println(teams.allStudents());

        teams.createStudent("Oleg", "Nikolaev", 58);

        System.out.println(teams.allStudents());

        System.out.println("write name new Student: ");
        name = sc.nextLine();
        System.out.println("write surname new Student: ");
        surname = sc.nextLine();
        System.out.println("write age new Student: ");
        age = sc.nextInt();

        teams.createStudent(name, surname, age);
        System.out.println(teams.allStudents());
        System.out.println(teams.toString());


    }
}
