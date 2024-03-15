package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

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

}
