package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClassroomTest {
    @Test
    public void getAverageScores(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Double actual = classroom.getAverageExamScore();
        double expected = 125;

        // Then
        //System.out.println(student.getAverageExamScore());
        Assert.assertEquals(expected, actual,0.0000001);
    }

    @Test
    public void getAverageScores2(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double[] s3Scores = { 250.0, 50.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student[] students = {s1,s2, s3};
        Classroom classroom = new Classroom(students);

        // When
        Double actual = classroom.getAverageExamScore();
        double expected = 133.33;//(125+125+150)/3;

        Assert.assertEquals(expected, actual,0.01);
    }


    @Test
    public void addStudent(){
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents().toArray(new Student[0]);
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents().toArray(new Student[0]);

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        String expected ="[]";
        String actual =preEnrollmentAsString;
        Assert.assertEquals(expected,actual);

        String expected1 ="[Student Name: Leon Hunter\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "Exam 1 -> 100\n" +
                "Exam 2 -> 150\n" +
                "Exam 3 -> 250\n" +
                "Exam 4 -> 0]";
        String actual1 = postEnrollmentAsString;
        Assert.assertEquals(expected1,actual1);


    }
    @Test
    public void removeStudent(){
        // : Given
        //int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom();
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);
        Integer expected =0;
        classroom.removeStudent("Leon","Hunter");
        Integer actual = classroom.getStudents().size();

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void getStudentsByScore(){
        Double[] examScores1 = { 100.0, 10.0, 25.0, 0.0 };
        Student student1 = new Student("Leon", "Hunter", examScores1);
        Double[] examScores2 = { 100.0, 10.0, 25.0, 0.0 };
        Student student2 = new Student("Tom", "Hunter", examScores2);
        Double[] examScores3 = { 120.0, 18.0, 270.0, 0.0 };
        Student student3 = new Student("Bob", "Hunter", examScores3);

        Student[] s ={student1,student2,student3};
        Classroom classroom = new Classroom(s);

//        Student[] expected = {student3,student1,student2};
        List<Student> expected = new ArrayList<>();
        expected.add(student3);
        expected.add(student1);
        expected.add(student2);
        List<Student> actualCall = classroom.getStudentsByScore();
        Assert.assertEquals(expected,actualCall);

    }
    @Test
    public void getPercentile(){
        Double[] examScores1 = { 100.0, 80.0, 50.0, 60.0 };
        Student student1 = new Student("Leon", "Hunter", examScores1);
        Double[] examScores2 = { 100.0, 10.0, 25.0, 10.0 };
        Student student2 = new Student("Tom", "Hunter", examScores2);
        Double[] examScores3 = { 120.0, 18.0, 70.0, 10.0 };
        Student student3 = new Student("Bob", "Hunter", examScores3);
        Student[] s ={student1,student2,student3};
        Classroom classroom = new Classroom(s);
        //System.out.println(student1.getAverageExamScore());
        Double actual = classroom.calculatePercentile(72.5);//36.25, 54.5
        Double expected = 66.67;
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void getGradeBook(){
        Double[] examScores1 = { 100.0, 80.0, 50.0, 60.0 };
        Student student1 = new Student("Leon", "Hunter", examScores1);
        Double[] examScores2 = { 100.0, 10.0, 25.0, 10.0 };
        Student student2 = new Student("Tom", "Hunter", examScores2);
        Double[] examScores3 = { 120.0, 18.0, 70.0, 10.0 };
        Student student3 = new Student("Bob", "Hunter", examScores3);
        Student[] s ={student1,student2,student3};
        Classroom classroom = new Classroom(s);
        HashMap<Student, Character> actual = classroom.getGradeBook();
        Character expected = 'C';
        Assert.assertEquals(expected,actual.get(student1));
    }


}
