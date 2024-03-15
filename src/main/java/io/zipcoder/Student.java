package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(List.of(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScore() {
        StringBuilder s = new StringBuilder();
        int i = 0;
        for (Double d : examScores) {
            i++;
            String result = "Exam " + i + " -> " + d.intValue();
//         Exam 1 -> 100
            s.append(result).append("\n");

        }
        return s.toString().trim();
    }

    public int getExamScoresNumber() {
        return examScores.size();
    }

    public void setExamScores(int index, double value) {
        try {
            examScores.set(index, value);
        } catch (Exception e) {
            System.out.println("Array list doesn't have the index number");
        }
    }


    private String toString(Double aDouble) {
        return examScores.toString();
    }

    public Double getAverageExamScore() {
        double result = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            result += examScores.get(i);
        }
        return result / examScores.size();
    }

    public void addExamScore(double score) {
        examScores.add(score);
    }

   @Override
   public String toString() {
       StringBuilder sb = new StringBuilder();
       String studentFirst = getFirstName();
       String studentLast = getLastName();
       int average = getAverageExamScore().intValue();
       String examScore = getExamScore();
       sb.append("Student Name: " +studentFirst+" ").append(studentLast+"\n").
               append("> Average Score: "+average+"\n").
               append("> Exam Scores:"+"\n"+examScore);
      return sb.toString();
   }
}

