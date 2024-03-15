package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    @Test
    public void getExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        //Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 95.0, 123.0, 96.0)) ;
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double output = student.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScore = new ArrayList<>(Arrays.asList(100.0, 95.0, 123.0, 96.0)) ;
        Student student = new Student(firstName, lastName, examScore);

        // When
        //String output = student.getExamScore();

        // Then
        // System.out.println(student.getExamScore());
        Assert.assertEquals(examScore, student.getExamScore());
    }

    @Test
    public void setExamScores(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScore = new ArrayList<>(Arrays.asList(100.0, 95.0, 123.0, 96.0)) ;
        Student student = new Student(firstName, lastName, examScore);

        // When
        //String output = student.getExamScore();

        // Then
        System.out.println(student.getExamScore());
        //Assert.assertEquals(examScore, student.getExamScore());
    }
    @Test
    public void getAverageScores(){
//        // : Given
//        String firstName = "Leon";
//        String lastName = "Hunter";
//        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
//        Student student = new Student(firstName, lastName, examScores);
//
//        // When
//        Double output = student.getAverageExamScore();
//
//        // Then
//        System.out.println(output);
    }





}