package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private List<Student> students;
    private int maxNumberOfStudents;
    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new ArrayList<>();

    }
    public Classroom(Student[] students){
        this.students = new ArrayList<>(List.of(students));
    }
    public Classroom(){
        Student[] students = new Student[30];
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public Double getAverageExamScore(){
        Double d1 = students.get(0).getAverageExamScore();
        Double d2 = students.get(1).getAverageExamScore();
        return (d1+d2)/students.size();
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(String firstName, String lastName){
        for(int i =0; i< students.size();i++){
            Student stud = students.get(i);
            if(stud.getFirstName().equals(firstName) && stud.getLastName().equals(lastName)){
                students.remove(i);
                break;
            }
        }
    }
    public String getStudentsByScore(){
        students.

    }
}

