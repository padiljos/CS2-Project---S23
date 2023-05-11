/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author Vince Gnodle
 * Class creates an Animal object that is to be used with a clinic to apply 
 * treatments, schedule appointments, assign a bill etc.
 */
public class Animal {
    
    private String name; 
    private int age;
    private final String species;
    private final String breed;
    private String location;  //Animal patients location in the clinic
    private Owner owner;  //Animals assigned Owner
    
    //the following are lists that track the Animal patients medical info and appointments
    protected ArrayList<String> allergies; 
    protected ArrayList<String> medications;
    protected ArrayList<String> drNotes;
    protected LinkedList<String> appointments;
    protected ArrayList<Treatment> treatHistory;

    /**
     * Animal constructor creates the animal object with the name, age, species,
     * and breed initialized using the input parameters.
     * @param name animals name
     * @param age animals age
     * @param species animals species (Dog, cat, bird, fish, etc)
     * @param breed animals breed if known
     */
    public Animal(String name, int age, String species, String breed){
        this.name = name;
        this.age = age;
        this.species = species;
        this.breed = breed;
        this.location = "Home"; //animals location is set to "home" until the arrive at the clinic
        
        
        //empty array lists to store animals medical info and appointments
        allergies = new ArrayList<>();
        medications = new ArrayList<>();
        drNotes = new ArrayList<>();
        appointments = new LinkedList<>();
        treatHistory = new ArrayList<>();
    }

    
    /**
     * Method assigns an Owner object as the owner of the animal
     * @param owner animals owner
     */
    public void addOwner(Owner owner){
        this.owner = owner;  //assigns given owner parameter as the animals owner
        this.owner.setAnimal(this);
    }
    
    /**
     * Method retrieves the animals assigned Owner object
     * @return owner
     */
    public Owner getOwner(){
        return owner;
    }
    
    /**
     * Method retrieves the animals name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method retrieves the age of the animal
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Method retrieves the animals species (Dog, Cat, Bird, etc.)
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Method retrieves the animals breed
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Method retrieves the animals current location. Will return "home" if animal
     * is not at the clinic.
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Method retrieves a list of the animal patients allergies
     * @return allergies
     */
    public ArrayList<String> getAllergies() {
        return allergies;
    }

    /**
     * Method retrieves a list of the animal patients medications
     * @return medications
     */
    public ArrayList<String> getMedications() {
        return medications;
    }

    /**
     * Method retrieves a list of the animal patients Dr. Notes
     * @return drNotes
     */
    public ArrayList<String> getDrNotes() {
        return drNotes;
    }

    /**
     * Method retrieves a list of the animal patients appointments
     * @return appointments
     */
    public LinkedList<String> getAppointments() {
        return appointments;
    }
    
    /**
     * Method retrieves a list of the animal patients treatment history
     * @return treatHistory
     */
    public ArrayList<Treatment> getTreatHistory() {
        return treatHistory; 
    }

    /**
     * Method sets the animals name as the given parameter
     * @param name name to be assigned
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method sets the animals age as the given parameter
     * @param age 
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Method changes the animals location to the given parameter
     * Location is somewhere in the clinic or at home
     * @param location 
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void addApt(String Apt){
        this.appointments.add(Apt);
    }
    
    /**
     * Method overrides the toString method to format how we wish to print the
     * animals info.
     * @return 
     */
    @Override
    public String toString(){
        
        return "Animal Name: " + name + "\n"
            + "Animal Species: " + species + "\nAnimal Breed: " + breed
            + "\nAnimal Age: " + age + "\nAnimal's Owner: " + this.getOwner().getName()
            + "\nAnimal Location: " + location;
       
    }
    
    
}
