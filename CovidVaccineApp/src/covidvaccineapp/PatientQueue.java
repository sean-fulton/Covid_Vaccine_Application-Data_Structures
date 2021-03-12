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
    
    public boolean isEmpty(){
        return PatientQueue.isEmpty();
    }
    
    public int size(){
        return PatientQueue.size();
    }
    
    private int findInsertPosition(int newkey){
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
    
    public void enqueue(int priorkey, Object item){
        int index;
        PQElement elem = new PQElement(priorkey, (Patient)item);
        
        index = findInsertPosition(priorkey);
        
        if(index == size()){
            PatientQueue.add(elem);
        }
        else{
            PatientQueue.add(index, elem);
        }
    }
    
    public Object dequeue(){
        return PatientQueue.remove(0);
    }
    
    public String printList(){
        String printQueue = new String();
        PQElement elem;
        for(int i = 0; i<PatientQueue.size(); i++){
            elem = PatientQueue.get(i);
            printQueue = printQueue.concat(elem.printPatient()+" "+"Priority: "+ elem.getKey()+"\n");
        }
        return printQueue;
    }
}
