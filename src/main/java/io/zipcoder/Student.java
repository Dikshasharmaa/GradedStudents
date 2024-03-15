package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Student {
   String firstName = "";
   String lastName ="";
   ArrayList<Double> examScores = new ArrayList<>();

   public Student(String firstName, String lastName, ArrayList<Double> examScores){
      this.firstName = firstName;
      this.lastName = lastName;
      this.examScores = examScores;
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
      String result = "";
      for(int i =0;i<examScores.size();i++){
         result += toString(examScores.get(i));
      }
      return result;
   }

   private String toString(Double aDouble) {
      return examScores.toString();
   }

   public Double getAverageExamScore() {
      return null;
   }
}

