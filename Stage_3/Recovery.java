/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Vince Gnodle
 * Class creates a Recovery treatment to be applied to an Animal
 * Class is a subclass to the Treatment class
 */
public class Recovery extends Treatment{

    /**
     * Recovery constructor creates surgery object using the super constructor from 
     * its parent class Treatment. Initializes name as Recovery and Price as 170.
     */
    public Recovery() {
        super();
        name = "Recovery";
        price = 170;
    }
    
    /**
     * Method obtains supplies from the clinics inventory to use for recovery
     * @param inventory
     */
    public void getSupplies(Inventory inventory){
        inventory.changeMedications(-1);  //Recovery requires 1 medication and 1 medical supply item
        inventory.changeMedicalSupply(-1);
    }
    
    /**
     * Method charges the animals owner for the recovery by adding the price of 
     * recovery to the owners bill
     * @param animal
     */
    public void chargeOwner(Animal animal){
        animal.getOwner().bill += price;
    }
    
    /**
     * Method sends the animal patient to the waiting area after they have recovered
     * @param animal the patient
     * @param clinic the clinic that the patient is at
     */
    public void sendNext(Animal animal, Clinic clinic){
        clinic.sendWaiting(animal);
    }
    
}
