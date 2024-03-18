package io.zipcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

       // students.get(0).getAverageExamScore();
        Collections.sort(students, new SortByAverage());



        return students;
    }
}

class SortByAverage implements Comparator<Student>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Student a, Student b)
    {
        double a_average = a.getAverageExamScore();
        double b_average = b.getAverageExamScore();
        if(a_average != b_average){
            return Double.compare(b.getAverageExamScore(), a.getAverageExamScore());
        }
        return a.getFirstName().compareTo(b.getFirstName());
    }
}

//Collections.sort(students, new Comparator<Student>() {
//    @Override
//    public int compare(Student student1, Student student2) {
//        double avg1 = student1.calculateAverageScore();
//        double avg2 = student2.calculateAverageScore();
//
//        if (avg1 != avg2) {
//            return Double.compare(avg1, avg2);
//        } else {
//            return student1.name.compareTo(student2.name);
//        }
//    }
//});