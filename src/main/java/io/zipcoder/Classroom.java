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
        // create var to store sum of students score averages
        Double totalAverage = 0.0;

        // iterate throught the list of students
        for(Student s1 : this.students){
            // add average of current score to var
            totalAverage += s1.getAverageExamScore();
        }
        // return total sum divided by students size
        return totalAverage/students.size();
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
    public List<Student> getStudentsByScore(){

        students.get(0).getAverageExamScore();

    return null;
    }
}

