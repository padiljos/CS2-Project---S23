/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

/**
 *
 * @author Vince Gnodle
 * Class creates treatment objects to be used on animal patients
 * Has 4 subclasses: Surgery, Recovery, Checkup, and Grooming
 */
class Treatment {
    int price; //instance variables price and name are unique to each subclass of treatment
    String name;

    /**
     * Treatment constructor creates the treatment object
     */
    public Treatment(){
    }
    
    /**
     * Method adds the treatment to the animal's treatment history
     * @param animal 
     */
    public void addTreatment(Animal animal){
        animal.treatHistory.add(this);
    }
    
    /**
     * Method overrides the toString method to format how we wish to print the treatment
     * @return 
     */
    @Override
    public String toString(){
        return("Treatment Name: " + name
                + "\nPrice: " + price + "\n");
    }
  
}
