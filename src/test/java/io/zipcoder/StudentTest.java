package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    @Test
    public void getExamScores(){
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expectedScores = "Exam Scores:\n\t\tExam 1 -> 100\n" +
                "\t\tExam 2 -> 95\n" +
                "\t\tExam 3 -> 123\n" +
                "\t\tExam 4 -> 96";

        Assert.assertEquals(expectedScores,student.getExamScore());
    }

    @Test
    public void addExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);
        student.addExamScore(90.0);
        String expected = "Exam 1 -> 90";

        // When
        String actual = student.getExamScore();

        // Then

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScores(0,150.0);
        String actual = student.getExamScore();
        String expected = "Exam Scores:\n\t\tExam 1 -> 150";

        // Then
        //System.out.println(student.getExamScore());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAverageScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        //Double output = student.getAverageExamScore();
        Double actual = student.getAverageExamScore();
        Double expected = 125.0;

        // Then
        //System.out.println(student.getAverageExamScore());
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void StringToString(){
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        String actual = student.toString();
        String expected = "Student Name: Leon Hunter\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 100\n" +
                "\t\tExam 2 -> 150\n" +
                "\t\tExam 3 -> 250\n" +
                "\t\tExam 4 -> 0";

        Assert.assertEquals(expected,actual);
    }




}