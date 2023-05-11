/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

/**
 *
 * @author Vince Gnodle
 * Class creates a Checkup treatment to be applied to an animal.
 * Class is a subclass to the Treatment class
 */
public class Checkup extends Treatment{

    /**
     * Checkup constructor creates Checkup object using Treatment super constructor.
     * Initializes name as "Checkup" and price as $100
     */
    public Checkup() {
        super();
        name = "Checkup";
        price = 30;
    }
    
    /**
     * Method obtains supplies from the clinics inventory to use for the Dr's Visit
     * @param inventory
     */
    public void getSupplies(Inventory inventory){
        
        inventory.changeOfficeSupply(-1);  //check up only requires 1 office supply item
    }
    
    /**
     * Method charges the animals owner for the check up by adding the price of 
     * the checkup to the owners bill
     * @param animal
     */
    public void chargeOwner(Animal animal){
        animal.getOwner().bill += price;
    }
    
    /**
     * Method sends the animal patient to the waiting area after their checkup
     * @param animal the patient
     * @param clinic the clinic that the patient is at
     */
    public void sendNext(Animal animal, Clinic clinic){
        clinic.sendWaiting(animal);
    }
}
