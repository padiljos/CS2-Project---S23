/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Vince Gnodle
 * Class creates a Surgery treatment to be applied to an animal
 * Is a subclass of the Treatment class
 */
public class Surgery extends Treatment{

    /**
     * Surgery constructor creates surgery object using the super constructor from 
     * its parent class Treatment. Initializes name as Surgery and Price as 600.
     */
    public Surgery() {
        super();
        name = "Surgery";
        price = 600;
    }
    
    /**
     * Method obtains supplies from the clinics inventory to use for the surgery
     * @param inventory
     */
    public void getSupplies(Inventory inventory){
        inventory.changeMedications(-3);  //surgery requires 3 medications and 4 medical supply items
        inventory.changeMedicalSupply(-4);
    }
    
    /**
     * Method charges the animals owner for the surgery by adding the price of 
     * the surgery to the owners bill
     * @param animal
     */
    public void chargeOwner(Animal animal){
        animal.getOwner().bill += price;
    }
    
    /**
     * Method sends the animal patient to recover after surgery
     * @param animal the patient
     * @param clinic the clinic that the patient is at
     */
    public void sendNext(Animal animal, Clinic clinic){
        clinic.sendRecovery(animal);
    }
}
