/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidvaccineapp;

import java.util.ArrayList;

/**
 *
 * @author seanf
 */
public class PatientQueue implements PQInterface {
    private ArrayList<PQElement> PatientQueue;
    
    public PatientQueue(){
        PatientQueue = new ArrayList<PQElement>();
    }
    
    public boolean isEmpty(){ // check if the queue is empty
        return PatientQueue.isEmpty();
    }
    
    public int size(){ // return the size of the queue
        return PatientQueue.size();
    }
    
    private int findInsertPosition(int newkey){ //find the next position for a item in queue
        boolean found;
        PQElement elem;
        int position;
        found = false;
        position = 0;
        while (position<PatientQueue.size() && !found){
            elem = PatientQueue.get(position);
            if(elem.getKey()>newkey){
                position = position +1;
            }
            else{
                found = true;
            }
        }
        return position;
    }
    
    public void enqueue(int priorkey, Object item){ // insert Object type into the queue
        int index;
        PQElement elem = new PQElement(priorkey, (Patient)item);
        
        index = findInsertPosition(priorkey); // calling findInsertPosition 
        
        if(index == size()){
            PatientQueue.add(elem);
        }
        else{
            PatientQueue.add(index, elem);
        }
    }
    
    public String dequeue(){ // remove and return the next group of items with the same priority in a String format.
        String printGroup = new String();
        int nextGroupKey;
        PQElement elem;
        
        nextGroupKey = PatientQueue.get(0).getKey();
        
        boolean count = true; //while loop parameter boolean
        while(count == true){ // loops until count is false
            if(!PatientQueue.isEmpty() && PatientQueue.get(0).getKey() == nextGroupKey ){ //if the array is not empty and the current items key is the same as the nextGroups key.
                elem = PatientQueue.get(0); // get the first element of the queue and pass it as elem
     
                printGroup = printGroup.concat(elem.printPatient()+" "+"Priority: "+ elem.getKey()+"\n"); // printGroup String concatenates details of patient.
                PatientQueue.remove(0); // removes item at the top of the queue.
            }
            else{
                count = false; //sets count boolean to false and breaks the while loop.
            }
            
        }
        return printGroup; // returns the printGroup string after completing the dequeue and collecting the details of the nextGroup.
    }
}
