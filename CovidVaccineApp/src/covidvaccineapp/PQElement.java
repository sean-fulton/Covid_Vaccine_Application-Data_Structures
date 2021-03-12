/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidvaccineapp;

/**
 *
 * @author seanf
 */
public class PQElement {
   private int key;
   private Patient element;
   
   public PQElement(int priority, Patient p){
       key = priority;
       element = p;
   }
   
   public int getKey(){
       return key;
   }
   
   public void setKey(int val){
       key = val;
   }
   
   public Patient getElement(){
       return element;
   }
   
   public void setElement(Patient p){
       element = p;
   }
   
   public String printPatient(){
       String details;
       details = "Patient Name: " + element.getName() + "," + " Age: " + element.getAge() + "," + " Condition (Y/N): " + element.getCondition() + ",";
       return details;
   }
}
