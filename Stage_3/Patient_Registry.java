/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Class maintains a list of all animal patients seen at the clinic
 */
public class Patient_Registry {
    
    private LinkedList<Animal> registry; //LinkedList that stores the animal objects
    
    /**
     * Patient_Registry constructor creates the object and initializes and empty
     * linked list to store the animal patients.
     */
    public Patient_Registry() {
        registry = new LinkedList<>();
    }
    
    /**
     * Method adds Animal object to the patient registry
     * @param animal Animal to be added to registry
     */
    public void addPT(Animal animal){
        registry.add(animal);
    }
    
    /**
     * Method searches the registry using the animals name and species
     * @return Animal
     */
    public Animal searchByAnimal(){
        Scanner in = new Scanner (System.in);
        
        //prompts user to enter animals name
        System.out.println("Enter in animals name: ");
        String name = in.nextLine();
        
        //prompts user to enter animals species
        System.out.println("Enter in animals species: ");
        String species = in.nextLine();
        
        /*for loop accesses all elements of the registry until it finds a match
        or reaches the end of the list*/
        for(int i = 0; i < registry.size(); i++){
            
            //retrieves animal at given index and stores under 'animal' for searching purposes
            Animal animal = registry.get(i); 
            
            /*If the animal at the current index has the same name and species 
            as the desired animal, regardless of case, a match has been found and
            the animal will be returned*/
            if(animal.getName().equalsIgnoreCase(name) && animal.getSpecies().equalsIgnoreCase(species)){
                return animal;
            }
        }
        /*If the list is searched and no matche is found, message will be printed
        and method will be called recursively*/
        System.out.println("Animal not found check your info and try again");
        searchByAnimal();
        return null;
    }
    
    /**
     * Method searches for animal using their owners full name and date of birth
     * @return Animal
     */
    public Animal searchByOwner(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter in owner's name: ");
        String name = in.nextLine();
        
        System.out.println("Enter in owner's DOB in format mm/dd/yyyy: ");
        String dob = in.next();
        in.nextLine();
        
        for(int i = 0; i < registry.size(); i++){
            Owner owner = registry.get(i).getOwner();
            if(owner.getName().equalsIgnoreCase(name) && owner.getDOB().equals(dob)){
                
                return registry.get(i);
               
            }
        }    
        
        System.out.println("Animal not found, check your info and try again.");
           
        this.searchByOwner();
        
        return null;  
        
    }
}
