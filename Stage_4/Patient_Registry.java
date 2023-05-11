/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Class maintains a list of all animal patients seen at the clinic
 */
public class Patient_Registry {
    
    private HashMap<String, Animal> animal_registry; //HashMap that stores the animal objects
    private HashMap<String, Owner> owner_registry;  //HashMap that stores the animals' owners
    
    /**
     * Patient_Registry constructor creates the object and initializes empty
     * HashMaps to store the animal patients in one registry, and the owners in
     * the other registry.
     */
    public Patient_Registry() {
        animal_registry = new HashMap<>();
        owner_registry = new HashMap<>();
    }
    
    /**
     * Method adds Animal object to the patient registry
     * @param name Animals name used as the key
     * @param animal Animal to be added to registry
     */
    public void addPT(String name, Animal animal){
        animal_registry.put(name, animal);
    }
    
    /**
     * Method adds customer/owner to the owner registry
     * @param userID User created ID to act as the key to access their profile
     * @param owner owner object that is to be added to the HashMap registry
     */
    public void addCustomer(String userID, Owner owner){
        owner_registry.put(userID, owner);
    }
    
    /**
     * Method searches the registry using the animals name
     * @param name
     * @return Animal
     */
    public Animal searchByAnimal(String name){
        
        return animal_registry.get(name);
    }
    
    /**
     * Method searches for owner/customer using their user Id as the key
     * @param userID key used to search Map
     * @return Owner the owner/customer
     */
    public Owner searchByOwner(String userID){
        
        return owner_registry.get(userID);
    }
    
    public HashMap getOwners(){
        return owner_registry;
    }
    
    public HashMap getPets(){
        return animal_registry;
    }
    
    public void removeOwner(String userID){
        owner_registry.remove(userID);
    }
    
    public void removePet(String name){
        animal_registry.remove(name);
    }
}
