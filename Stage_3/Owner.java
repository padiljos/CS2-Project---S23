/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedList;

/**
 *
 * @author Vince Gnodle
 * Class creates an owner object to assign to an animal patient and also use for billing
 * and other purposes.
 */
public class Owner {
    private String name;  //owners first and last name
    private String dob;  //owners date of birth
    private String phoneNumber;
    protected int bill = 0;  //initializes bill as $0
    private Animal animal;  //is assigned an animal pet
    protected LinkedList<String> payments;  //tracks the owners payments

    /**
     * Owner constructor creates owner object
     * @param name owners assigned name
     * @param dob owners date of birth
     * @param phoneNumber owners contact number
     */
    public Owner(String name, String dob, String phoneNumber) {
        
        //Owner's name, dob, and phone number are intialized with given parameters
        this.name = name;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        payments = new LinkedList<>();  //empty linked list initialized 
    }
    
    /**
     * Method assigns an Animal object as the pet of the owner
     * @param animal
     */
    public void addAnimal(Animal animal){
        
        this.animal = animal;  //assigns the given animal parameter as the owners animal
        
        animal.addOwner(this);  //calls to assign the owner as the animals owner
    }
    
    /**
     * Method retrieves the owners animal pet
     * @return animal
     */
    public Animal getAnimal(){
        return animal;
    }

    /**
     * Method retrieves the Owners first and last name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method retrieves the owners date of birth
     * @return dob
     */
    public String getDOB() {
        return dob;
    }

    /**
     * Method retrieves the owners phone number
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method retrieves the owners current bill
     * @return bill
     */
    public int getBill() {
        return bill;
    }

    /**
     * Method retrieves a list of the owners payments that they have made
     * @return payments
     */
    public LinkedList getTransactions() {
        return payments;
    }
    
    /**
     * Method overrides the toString method to format how we wish to print the 
     * owners info.
     * @return 
     */
    @Override
    public String toString(){
        return ("Owner's Name: " + name
            + "\nOwner's DOB: " + dob + "\nOwner's Phone Number: " + phoneNumber);
    }
}
