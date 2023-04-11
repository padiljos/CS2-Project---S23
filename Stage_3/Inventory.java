/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Vince Gnodle
 * Class creates an Inventory object to maintain a proper amount of supplies for the 
 * clinic to operate
 */
public class Inventory {
    
    private int medications = 0; //a count of medication items
    private int officeSupply = 0;  //a count of office supply items
    private int medSupply = 0;  //a count of medical supply items
    private int groomSupply = 0;  //a count of grooming supply items

    /**
     * Inventory constructor creates Inventory object
     */
    public Inventory() {
    }
    
    /**
     * Method changes the medication count of the inventory. This includes both
     * a decrease when used for treatments and an increase when more supplies is purchased.
     * @param items int, number of items to add to the count
     */
    public void changeMedications(int items){
        
        //adds given parameter items(int) to the current count, use negative numbers to subtract from count
        medications += items;  
    }
    
    /**
     * Method changes the office supply count of the inventory. This includes both
     * a decrease when used for treatments and an increase when more supplies is purchased.
     * @param items int, number of items to add to the count
     */
    public void changeOfficeSupply(int items){
        
        officeSupply += items;
    
    }
    
    /**
     * Method changes the medical supply count of the inventory. This includes both
     * a decrease when used for treatments and an increase when more supplies is purchased.
     * @param items int, number of items to add to the count
     */
    public void changeMedicalSupply(int items){
        
        medSupply += items;
        
    }
    
    /**
     * Method changes the grooming supply count of the inventory. This includes both
     * a decrease when used for treatments and an increase when more supplies is purchased.
     * @param items int, number of items to add to the count
     */
    public void changeGroomSupply(int items){
        
        groomSupply += items;
        
    }
    
    /**
     * Method performs a check on all current supply counts and suggests the 
     * number of each items that should be ordered to maintain an adequate
     * supply for a weeks operations.
     */
    public void checkInventory(){
        
        System.out.println("\nMedications in stock: " + medications
                + "\nOffice supplies in stock: " + officeSupply 
                + "\nMedical supplies in stock: " + medSupply
                + "\nGrooming supplies in stock: " + groomSupply + "\n");
        
        if(medications < 25){  //If medications below weekly minimum
            
            int needed = 25 - medications;  //calculates how many items are needed to meet minimum
            
            System.out.println("Order " + needed + " Medications to bring stock back up to Weekly Minimum");
            
        }
        
        if(officeSupply < 60){  //If office supplies below weekly minimum
            
            int needed = 60 - officeSupply;  //calculates how many items are needed to meet minimum
            
            System.out.println("Order " + needed + " Office supplies to bring stock back up to Weekly Minimum");
            
        }
        
        if(medSupply < 30){
            
            int needed = 30 - medSupply;
            
            System.out.println("Order " + needed + " Medical supplies to bring stock back up to Weekly Minimum");
            
        }
        
        if(groomSupply < 40){
            
            int needed = 40 - groomSupply;
            
            System.out.println("Order " + needed + " Grooming Supplies to bring stock back up to Weekly Minimum");
             
        }

        //surgery at 0900, recovery after that, checkup @0900,1000,1100,1300,1400,1500
        //2 hr grooming appointments @0900,1300,1500
        //clinic open Mon-friday 0800-1700, Sat 0800-1200, 2 groomings and 3 checkup on SAT
        //groomings at 0800 and 1000, checkups at 0900,1000, and 1100.
        //keep enough supplies for a weeks operation with a little buffer
    }
    
}
