/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Vince Gnodle
 * Class creates a Grooming treatment to be applied to an animal
 * Is a subclass of the Treatment class.
 */
class Grooming extends Treatment{
    
    /**
     * Grooming constructor creates surgery object using the super constructor from 
     * its parent class Treatment. Initializes name as Grooming and Price as 100.
     */
    public Grooming() {
        super();
        name = "Grooming";
        price = 100;
    }
    
    /**
     * Method obtains supplies from the clinics inventory to use for the grooming
     * @param inventory
     */
    public void getSupplies(Inventory inventory){
        inventory.changeGroomSupply(-2);  //grooming requires 2 grooming supply items and 1 office supply item
        inventory.changeOfficeSupply(-1);
    }
    
    /**
     * Method charges the animals owner for the grooming by adding the price of 
     * the grooming to the owners bill
     * @param animal
     */
    public void chargeOwner(Animal animal){
        animal.getOwner().bill += price;
    }
    
    /**
     * Method sends the animal patient to the waiting area after grooming
     * @param animal the patient
     * @param clinic the clinic that the patient is at
     */
    public void sendNext(Animal animal, Clinic clinic){
        clinic.sendWaiting(animal);
    }
}
