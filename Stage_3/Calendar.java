/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Class creates a linked list as a calendar object to store appointments that 
 * have been scheduled
 */
public class Calendar {
    
    protected LinkedList<String> schedule;

    /**
     * Calendar constructor creates a calendar object with an empty linked list
     * to store the schedule
     */
    public Calendar() {
        
        schedule = new LinkedList<>();
    }
    
    /**
     * Method checks if the desired appointment, entered as a parameter, is already
     * in the schedule and is therefore unavailable
     * @param appointment String, date and time of desired appointment
     * @param schedule linked list being searched
     * @return true or false
     */
    public boolean isAvailable(String appointment, LinkedList schedule){
        
        /*For loop accessing all nodes in the linked list and compares their values
        to the desired appointment. If a match is found, a value of false will be returned.
        Else, it will return true*/
        for(int i = 0; i < schedule.size(); i++){
            if(schedule.get(i).equals(appointment)){
                
                return false;
            
            }  
        }
        
        return true;
    }
    
    /**
     * Method calls the isAvailable method to check if appointment is open. If it
     * is, the appointment will be scheduled and added to the current schedule. 
     * Method will call itself recursively until an available appointment is found.
     * @param animal 
     */
    public void schedule(Animal animal){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter in desired appointment date in format mm/dd/yyyy");
        String appointment_date = in.next();
        in.nextLine();
        
        System.out.println("Enter in desired appointment time in format hh:mm");
        String appointment_time = in.next();
        in.nextLine();
        
        //appointment combines date and time strings with an '_' connecting them for searching purposes
        String appointment = appointment_date + "_" + appointment_time;
        
        if(this.isAvailable(appointment, this.schedule)){ //if available appointment is scheduled
            
            System.out.println("Your appointment has been accepted, thank you!");
        
            schedule.add(appointment);
        
            animal.appointments.add(appointment);  //appointment added to animals list of appointments
        }
        else{  //if unavailable
            
            System.out.println("\nAppointment is Unavailable, please enter in another time slot: ");
            
            this.schedule(animal);
        }
        
        
        
    }
    
    /**
     * Method will delete desired appointment if it exists in the list and in the
     * input animals appointment list
     * @param animal the animal whose appointment is being deleted
     */
    public void deleteApt(Animal animal){
        Scanner in = new Scanner(System.in);
        
        //prompts user to enter desired date
        System.out.println("Enter in desired appointment date in format mm/dd/yyyy");
        String appointment_date = in.next();
        in.nextLine();
        
        //prompts user to enter in desired time
        System.out.println("Enter in desired appointment time in format hh:mm");
        String appointment_time = in.next();
        in.nextLine();
        
        //combines date and time with '_' for searching purposes
        String appointment = appointment_date + "_" + appointment_time;
        
        /*First checks if the entered appointment is in the animals appointments
        list. If it is, the schedule will then be searched. If it is present there to 
        then the appointment will be deleted.*/
        if(this.isAvailable(appointment, animal.appointments)){
     
            System.out.println("No such appointment is scheduled for this animal");
            
        }
        else{
            
            if(this.isAvailable(appointment, this.schedule)){

                System.out.println("Appointment does not exist.\n"); 

            }
            else{
                System.out.println("Appointment has been cancelled!");
                schedule.remove(appointment); 
                animal.appointments.remove(appointment);
            }
        }
        
    }
}
