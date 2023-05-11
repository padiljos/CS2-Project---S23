/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Class creates a linked list as a calendar object to store appointments that 
 * have been scheduled
 */
public class Calendar {
    protected HashMap<String, HashMap<Integer, HashMap<Integer, Boolean>>> schedule;

    /**
     * Calendar constructor creates a calendar object with an empty linked list
     * to store the schedule
     */
    public Calendar() {
        
        schedule = new HashMap<>();
        
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (String month : months) {
            schedule.put(month, new HashMap<>());
            
            if(month.equals("Feb")){
                for(int i = 1; i <= 28; i++){
                    (schedule.get(month)).put(i, new HashMap<>());
                    
                    for(int j = 9; j < 17; j++){
                        ((schedule.get(month)).get(i)).put(j, true);
                    }
                   
                }
                
            }
            else if(month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov")){
                for(int i = 1; i <= 30; i++){
                    (schedule.get(month)).put(i, new HashMap<>());
                    
                    for(int j = 9; j < 17; j++){
                        ((schedule.get(month)).get(i)).put(j, true);
                    }
                   
                }
            }
            else{
                for(int i = 1; i <= 31; i++){
                    (schedule.get(month)).put(i, new HashMap<>());
                    
                    for(int j = 9; j < 17; j++){
                        ((schedule.get(month)).get(i)).put(j, true);
                    }
                   
                }
            }
        }
    }
    
    /**
     * Method checks the HashMap to check if the month, day, and time of appointment
     * is available or not.
     * @param month of appointment
     * @param day of appointment
     * @param time of appointment
     * @return true or false
     */
    public boolean isAvailable(String month, int day, int time){
        
        if(time < 9 || time > 16){
            return false;
        }
        else{
            return this.schedule.get(month).get(day).get(time);
        }
    }
    
    /**
     * Method calls the isAvailable method to check if appointment is open.If it
     * is, the appointment will be scheduled and added to the current schedule.Method will call itself recursively until an available appointment is found.
     * @param animal
     * @param month 
     * @param day 
     * @param time 
     * @return true if appointment was scheduled, false if not
     */
    public boolean Schedule(Animal animal, String month, int day, int time){
        
        if(this.isAvailable(month, day, time)){ //if available appointment is scheduled
            
            System.out.println("Your appointment has been accepted, thank you!");
            
            schedule.get(month).get(day).put(time, false);
        
            String add = month + " " + String.valueOf(day) + " " + String.valueOf(time);
            animal.addApt(add);  //appointment added to animals list of appointments
            return true;
        }
        else{  
            return false;
        }  
    }
    
    /**
     * Method will delete desired appointment if it exists in the list and in the
     * input animals appointment list
     * @param animal the animal whose appointment is being deleted
     * @param month
     * @param day
     * @param time
     * @return false if appointment doesn't exist, true if successfully deleted
     */
    public boolean deleteApt(Animal animal, String month, int day, int time){
        
        /*First checks if the entered appointment is in the animals appointments
        list. If it is, the schedule will then be searched. If it is present there to 
        then the appointment will be deleted.*/
        if(this.isAvailable(month, day, time)){
     
            return false;
            
        }
        else{
            
            System.out.println("Appointment has been cancelled!");
            schedule.get(month).get(day).put(time, true);
            //animal.appointments.remove(appointment);
            return true;
        }
        
        
    }
}
