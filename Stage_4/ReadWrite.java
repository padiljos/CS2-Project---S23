/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vet_clinic_gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Vince Gnodle
 * Class to read from and write to files
 */
public class ReadWrite {
    
    private Patient_Registry storage;
    private String filename;
    private final String delimiter = ",";
    private Object object;
    ReadWrite(Patient_Registry registry, String file, Object obj){
    
        object =obj;
        storage = registry;
        filename = file;
        
    }
    
    /**
     *
     */
    protected void readCSV()
    {
        try
        {
            
                File file = new File(filename);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line = "";
                String[] tempArr;
                while ( (line = br.readLine()) != null)
                {
                    tempArr = line.split(delimiter);
                    for (String field : tempArr)
                    {
                        System.out.println(field + " ");
                    }

                    if(object instanceof Owner){
                        String userID = tempArr[0];
                        String name = tempArr[1];
                        String DOB = tempArr[2];
                        String phone = tempArr[3];
                        String petsName = tempArr[4];

                        Owner owner = new Owner(userID, name, DOB, phone);

                        storage.addCustomer(userID, owner);

                        System.out.println();
                    }
                    if(object instanceof Animal){
                        String name = tempArr[0];
                        int age = Integer.parseInt(tempArr[1]);
                        String species = tempArr[2];
                        String breed = tempArr[3];
                        String ownersID = tempArr[4];

                        Animal animal = new Animal(name, age, species, breed);
                        animal.addOwner(CustomerMenu.clinic.registry.searchByOwner(ownersID));

                        storage.addPT(name, animal);
                        

                        System.out.println();
                    }
                    
                    
                    br.close();
                }
           
        }
        catch(IOException e)
        {
            //JOptionPane.showMessageDialog(this, "Error reading the file");
        }
    }
    
    protected void updateCSV()
    {
        try
        {
            
            // Make a copy of the original file
            
//            File oldFile = new File(filename);
//            File new_file = new File(filename+".bkp");
//            
//            Files.copy(oldFile.toPath(), new_file.toPath());
                    
            File file = new File(filename);
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));

            if(object instanceof Owner){
                // Traverese the map of customers and ovewrite the file.
                HashMap<String, Owner> owners = storage.getOwners();
                for (Map.Entry owner : owners.entrySet())
                {
                    String row = "";
                    String customerID = (String) owner.getKey();
                    Owner own = storage.searchByOwner(customerID);

                    String name = own.getName();
                    String dob = own.getDOB();
                    String phone = own.getPhoneNumber();

                    row = customerID + "," + name + "," +
                            dob + "," + phone + "\n";

                    System.out.println("New row: " + row);

                    // Add the row to the file
                    bf.write(row);
                }
                bf.close();
            }
            
            if(object instanceof Animal){
                // Traverese the map of customers and ovewrite the file.
                HashMap<String, Animal> animals = storage.getPets();
                for (Map.Entry owner : animals.entrySet())
                {
                    String row = "";
                    String petID = (String) owner.getKey();
                    Animal pet = storage.searchByAnimal(petID);

                    String petName = pet.getName();
                    int age = pet.getAge();
                    String species = pet.getSpecies();
                    String breed = pet.getBreed();

                    row = petName + "," + age + "," +
                            species + "," + breed + (pet.getOwner().getID()) + "\n";

                    System.out.println("New row: " + row);

                    // Add the row to the file
                    bf.write(row);
                }
                bf.close();
            }
            
        }
        catch(IOException e)
        {
            //JOptionPane.showMessageDialog(this, "Error writing the file");
        }
        
    }
}
