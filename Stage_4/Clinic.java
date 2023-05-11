/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Class creates a veterinary clinic that stores an inventory, transaction records,
 * a patient registry, and multiple Calendars for different treatment types.
 */
public class Clinic{
    
    private String name;
    protected Transaction transactions; //maintains an account of the clinics financial records
    protected Patient_Registry registry; //a list that contains all animals seen at the clinic
    protected Inventory inventory;  //keeps a count of supplies necessary for clinic's operation
    protected Calendar checkupCalendar;  //schedule for dr's visits
    protected Calendar groomingCalendar; //grooming schedule
    protected Calendar surgeryCalendar; //surgery schedule
    protected String treatmentList; //list of current treatments provided by the clinic
    
    /**
     * Clinic constructor creates the clinic object and initializes the name as
     * the given parameter. Also initializes an empty registry, inventory, financial
     * report, and calendars.
     * @param name name of the clinic
     */
    Clinic(String name){
        this.name = name;
        registry = new Patient_Registry();
        inventory = new Inventory();
        checkupCalendar = new Calendar();
        groomingCalendar = new Calendar();
        surgeryCalendar = new Calendar();
        transactions = new Transaction();
    }
    
    /**
     * Clinic constructor #2 creates the clinic object with no parameter given
     * to initialize name. Name defaults to "Noodles Vet Clinic".
     * Also initializes an empty registry, inventory, financial report, and calendars.
     */
    Clinic(){
        name = "Noodles Vet Clinic";  //defaulted name if no parameter given
        registry = new Patient_Registry();
        inventory = new Inventory();
        checkupCalendar = new Calendar();
        groomingCalendar = new Calendar();
        surgeryCalendar = new Calendar();
        transactions = new Transaction();
        treatmentList = ("1. Grooming\n2. Surgery\n3. Checkup");  //defaulted treatment list
    }
    
    /**
     * Method prints the clinics current treatment list
     * @return treatmentList
     */
    public String printTreatList(){
        return treatmentList;
    }

    /**
     * Method sets or changes the clinics current treatment list using a scanner
     */
    public void setTreatmentList() {
        Scanner in = new Scanner (System.in);
        
        System.out.println("Enter in your desired list of treatments seperated by '\n': "); //add numbering if desired
        
        treatmentList = in.nextLine();  //next line becomes the treatment list, do not hit enter until full list completed. 
        
    }
    
    /**
     * Method "performs" surgery on the patient. Method sets animal location
     * to surgery, gets needed supplies, and charges the animals owner. 
     * @param animal 
     */
    public void sendSurgery(Animal animal){
        
        animal.setLocation("Surgery");
        System.out.print(animal.getName() + " is in surgery.\n"); //Displays animals updated location
        
        Surgery surgery = new Surgery();  //creates a surgery object to use on patient
        
        /*uses surgery object to get needed supplies, charge the owner, and send 
        the animal to its next location.*/
        surgery.getSupplies(inventory);  
        surgery.chargeOwner(animal);
        surgery.sendNext(animal, this);
        
    }
    
    /**
     * Method helps the patient recover from surgery. Method sets animal location
     * to recovery, gets needed supplies, and charges the animals owner. 
     * @param animal 
     */
    public void sendRecovery(Animal animal){
        
        animal.setLocation("Recovery");
        System.out.print (animal.getName() + " is recovering.\n");
        
        Recovery recovery = new Recovery();  //creates a recovery object to use on patient
        
        /*uses recovery object to get needed supplies, charge the owner, and send 
        the animal to its next location.*/
        recovery.getSupplies(inventory);
        recovery.chargeOwner(animal);
        recovery.sendNext(animal, this);
    }
    
    /**
     * Method performs Grooming on the animal. Method sets animal location
     * to grooming, gets needed supplies, and charges the animals owner. 
     * @param animal 
     */
    public void sendGrooming(Animal animal){
        
        animal.setLocation("Grooming");
        System.out.print (animal.getName() + " is being groomed.\n");
        
        Grooming grooming = new Grooming();
        
        grooming.getSupplies(inventory);
        grooming.chargeOwner(animal);
        grooming.sendNext(animal, this);
    }
    
    /**
     * Method performs a check up on the animal. Method sets animal location
     * to Dr's Office, gets needed supplies, and charges the animals owner. 
     * @param animal 
     */
    public void sendDrOffice(Animal animal){
        
        animal.setLocation("Dr's Office");
        System.out.print (animal.getName() + " is getting its checkup.\n");
        
        Checkup checkup = new Checkup();  //creates a new Checkup object to use on animal
        
        checkup.getSupplies(inventory);
        checkup.chargeOwner(animal);
        checkup.sendNext(animal, this);
        
    }
    
    /**
     * Method sends the patient to the waiting area after the treatment is complete. 
     * Method sets animal location to waiting, then sends the animal home. 
     * @param animal 
     */
    public void sendWaiting(Animal animal){
        
        animal.setLocation("Waiting");
        System.out.print (animal.getName() + " is waiting.\n");
        
        this.sendHome(animal);
    }
    
    /**
     * Method sends the animal patient home when they are ready. Method sets 
     * animal location to home. 
     * @param animal 
     */
    public void sendHome(Animal animal){
        
        animal.setLocation("Home");
        System.out.print (animal.getName() + " is going home.\n");
    
    }
}
