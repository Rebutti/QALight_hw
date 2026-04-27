package java_hw_4_Team;

import java_hw_4_Student.Student;

import java.util.Arrays;

public class Team {
    private Student[] teamArray = {};


    public void addStudent(Student newStudent) {
        Student[] newTeam = new Student[this.teamArray.length + 1];

        for (int i = 0; i < this.teamArray.length; i++) {
            newTeam[i] = teamArray[i];
        }

        newTeam[this.teamArray.length] = newStudent;
        this.teamArray = newTeam;

    }

    public void createStudent(String name, String surname, int age){
        Student newStudent = new Student(name, surname, age);
        addStudent(newStudent);
    }

    public String allStudents(){
        String studentsList = "";
        for (int i = 0; i < this.teamArray.length; i++) {
            studentsList = studentsList + "Student`s full name - " + this.teamArray[i].getName() + " " + this.teamArray[i].getSurname()+"\n";
        }
        return studentsList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamArray=" + Arrays.toString(teamArray) +
                '}';
    }
}
