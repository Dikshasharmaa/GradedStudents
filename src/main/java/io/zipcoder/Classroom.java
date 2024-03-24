package io.zipcoder;

import java.util.*;

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
    public HashMap<Student,Character> getGradeBook(){
        HashMap<Student,Character> grades = new HashMap<>();
        for(Student s: this.students){
            Double percentile = calculatePercentile(s.getAverageExamScore());
            if(percentile >= 90){
                grades.put(s,'A');
            } else if (percentile >= 71 && percentile <= 89) {
                grades.put(s,'B');
            }else if (percentile >= 50 && percentile <= 70) {
                grades.put(s, 'C');
            }else if (percentile >= 11 && percentile <= 51) {
                grades.put(s,'D');
            }
            else{
                grades.put(s,'F');
            }

        }

        return grades;
    }

    public Double calculatePercentile(Double score){
        List<Double> scoresList = new ArrayList<>();
        for(Student s1 : this.students){
            scoresList.add(s1.getAverageExamScore());
        }
        Collections.sort(scoresList);
        double count = 0.0;
        for(Double d1 : scoresList){
            if (d1.equals(score)){
                break;
            }
            else {
                count++;

            }

        }
        Double percentile = (count/scoresList.size()*100);
        return percentile;

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