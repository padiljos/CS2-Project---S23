/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */




import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Main program for the "Noodles" Veterinary clinic
 */
public class Vet_Clinic {

    public static void main(String[] args) {
        Clinic noodles_clinic = new Clinic(); //Clinic is created
        
        /*Everything from this point, up to the main menu call, is the creation
         of dummy info and transactions to test the system*/
        
        //creates dummy animals
        Animal bruce = new Animal("Bruce", 11, "Cat", "Maine Coone");
        Animal luna = new Animal("Luna", 3, "Cat", "Tortoise Shell");
        Animal lucian = new Animal("Lucian", 3, "Cat", "Russian Blue");
        Animal chuck = new Animal("Chuck", 7, "Dog", "Boxer");
        Animal humphrey = new Animal("Humphrey", 4, "Dog", "Boston Terrier");
        Animal max = new Animal("Max", 1, "Fish", "Goldfish");
        
        //creates dummy owners
        Owner vince = new Owner("Vince Gnodle", "01/01/1990", "505-123-4567");
        Owner sandy = new Owner("Sandy Gnodle", "01/01/1989", "505-123-4568");
        Owner mina = new Owner("Mina Gnodle", "01/01/2011", "505-123-4569");
        Owner ellie = new Owner("Eleanor Gnodle", "01/01/2017", "505-123-4570");
        Owner lawrence = new Owner("Lawrence Gutierrez", "01/01/1982", "505-123-4571");
        Owner meesh = new Owner("Michelle Gutierrez", "01/01/1982", "505-123-4572");
        
        //assigns dummy owners to dummy animals
        bruce.addOwner(vince);
        luna.addOwner(mina);
        lucian.addOwner(sandy);
        chuck.addOwner(lawrence);
        humphrey.addOwner(meesh);
        max.addOwner(ellie);
        
        //adds dummy animals to the clinics registry
        noodles_clinic.registry.addPT(bruce);
        noodles_clinic.registry.addPT(luna);
        noodles_clinic.registry.addPT(lucian);
        noodles_clinic.registry.addPT(chuck);
        noodles_clinic.registry.addPT(humphrey);
        noodles_clinic.registry.addPT(max);
        
        //adds additional info to one of the dummy animals
        bruce.medications.add("Saline");
        bruce.allergies.add("Kiwi");
        bruce.drNotes.add("Give IV fluid 2x/day");
        
        //purchase initial supply needed to operate the clinic
        noodles_clinic.transactions.purchaseMeds(noodles_clinic.inventory); //Enter in 25 when prompted
        noodles_clinic.transactions.purchaseOffice(noodles_clinic.inventory); //Enter in 60
        noodles_clinic.transactions.purchaseSupply(noodles_clinic.inventory); //Enter in 30
        noodles_clinic.transactions.purchaseGroom(noodles_clinic.inventory);//Enter in 40
        
        //appointments added to various calendars
        noodles_clinic.checkupCalendar.schedule.add("01/01/2023_09:00");
        bruce.appointments.add("01/01/2023_09:00");
        
        noodles_clinic.checkupCalendar.schedule.add("01/01/2023_10:00");
        luna.appointments.add("01/01/2023_10:00");
        
        noodles_clinic.groomingCalendar.schedule.add("01/01/2023_09:00");
        max.appointments.add("01/01/2023_09:00");
        
        noodles_clinic.surgeryCalendar.schedule.add("01/01/2023_09:00");
        humphrey.appointments.add("01/01/2023_09:00");
        
        noodles_clinic.surgeryCalendar.schedule.add("01/02/2023_09:00");
        bruce.appointments.add("01/02/2023_09:00");
        
        noodles_clinic.groomingCalendar.schedule.add("01/03/2023_09:00");
        bruce.appointments.add("01/01/2023_09:00");
        
        noodles_clinic.checkupCalendar.schedule.add("01/01/2023_11:00");
        lucian.appointments.add("01/01/2023_09:00");
        
        noodles_clinic.surgeryCalendar.schedule.add("06/01/2023_09:00");
        chuck.appointments.add("06/01/2023_09:00");
        
        //all previously scheduled appointments are carried out at the clinic
        noodles_clinic.sendDrOffice(bruce);
        noodles_clinic.sendDrOffice(luna);
        noodles_clinic.sendGrooming(max);
        noodles_clinic.sendSurgery(humphrey);
        noodles_clinic.sendSurgery(bruce);
        noodles_clinic.sendGrooming(bruce);
        noodles_clinic.sendDrOffice(lucian);
        noodles_clinic.sendSurgery(chuck);
        
        noodles_clinic.inventory.checkInventory(); //checks inventory after appointments
        
        //Purchasing supply after use. Enter in amounts from the report when prompted
        noodles_clinic.transactions.purchaseMeds(noodles_clinic.inventory);
        noodles_clinic.transactions.purchaseOffice(noodles_clinic.inventory); 
        noodles_clinic.transactions.purchaseSupply(noodles_clinic.inventory);
        noodles_clinic.transactions.purchaseGroom(noodles_clinic.inventory);
        
        noodles_clinic.inventory.checkInventory(); //rechecks inventory after purchases
        
        noodles_clinic.transactions.getReport(); //gets current financial reports
        
        //various owners pay part of their bill
        noodles_clinic.transactions.billPaid(bruce.getOwner(),bruce.getOwner().getBill(), 50);
        
        noodles_clinic.transactions.billPaid(luna.getOwner(),luna.getOwner().getBill(), 20);
        
        noodles_clinic.transactions.billPaid(chuck.getOwner(),chuck.getOwner().getBill(), 100);
        
        noodles_clinic.transactions.getReport(); //report after bills paid
        
        
        //calls the main menu to start interface with the system
        main_menu(noodles_clinic);
    }
    
    /** 
     * This method builds the menu, gets the user selection, and uses a switch 
     * statement to  call  the  respective  options.
     * @param clinic
     */ 
    public static void main_menu(Clinic clinic){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        //do while loop to keep prompting user for choice until they select quit
        do{
            System.out.print("Select an option:\n1. Customer Menu\n2. "
                    + "Employee Menu\n3. Quit\n");
            
            choice = in.nextInt();

            //switch statements to perform actions according to users entered choice
            switch(choice){
                case 1: System.out.print("You chose 1, Customer Menu\n");  
                customer_menu(clinic);break;  //proceeds to customer menu
                
                case 2: System.out.print("You chose 2, Employee Menu\n");
                employee_menu(clinic);break;  //proceeds to employees menu
                
                case 3: System.out.print("You chose to quit, goodbye!\n");break;
                
                default: System.out.printf("You selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 3); //while the user doesnt choose to quit
    }
    
    /** 
     * This method builds the customer menu, gets the user selection, and uses a switch 
     * statement to  call  the  respective  options.
     * @param clinic
     */ 
    public static void customer_menu(Clinic clinic){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        do{  //do this until user selects to go back to main menu
            
            System.out.print("Select an option:\n1. New Customer\n2. "
                    + "Existing Customer\n3. Go Back\n");
            
            choice = in.nextInt();

            switch(choice){
                case 1: System.out.print("You selected New Customer\n");
                new_customer(clinic);break; //call new_customer(), then uses added Pt as a parameter in customer 2 menu to schedule, bill, etc.
                
                case 2: System.out.print("You selected Existing Customer\n");
                existing_customer(clinic);break; //calls existing_customer which gives menu to search via owner name/dob or animal name. Once search performed, returned animal object used same as for new pts
                
                case 3: System.out.print("Going back...\n");main_menu(clinic);break;
                
                default: System.out.printf("You selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 3);  //while user doesnt choose to go back
    }
    
    /**
     * Creates and returns a new Animal patient
     * @return animal
     */
    public static Animal createAnimal(){
        
        Scanner in = new Scanner (System.in);
        
        /*Prompts user to enter info for the animal to be added.*/
        System.out.println("Enter in animals name: ");
        String animal_name = in.nextLine();
        
        System.out.println("Enter in animals age: ");
        int animal_age = in.nextInt();
        in.nextLine();
        
        System.out.println("Enter in animals species: ");
        String animal_species = in.nextLine();
        
        System.out.println("Enter in animals breed(if unknown enter in 'unknown'): ");
        String animal_breed = in.nextLine();
        
        //creates and returns animal object using entered user info
        return new Animal(animal_name, animal_age, animal_species, animal_breed);
    }
    
    /**
     * Method creates a new Owner object to assign to an animal patient
     * @return owner
     */
    public static Owner createOwner(){
        
        Scanner in = new Scanner (System.in);
        
        //prompts user to enter in their info to create their profile
        System.out.println("Enter in owner's first and last name: ");
        String owner_name = in.nextLine();
        
        System.out.println("Enter in owner's date of birth in mm/dd/yyyy format: ");
        String owner_dob = in.next();
        in.nextLine();
        
        System.out.println("Enter in owner's phone number including area code in form xxx-xxx-xxxx: ");
        String owner_phone = in.nextLine();
        System.out.println("\n");
        
        //creates and returns owner object with entered user parameters
        return new Owner(owner_name, owner_dob, owner_phone);
        
    }
    
    /**
     * Method is a new customer menu that has the user create their/their animals
     * profile by creating new Animal and Owner objects first. Method then takes 
     * user to customer menu 2.
     * @param clinic 
     */
    public static void new_customer(Clinic clinic){
        
        //creates new animal and owner
        Animal new_animal = createAnimal();
        Owner new_owner = createOwner();
       
        //assigns new animal and owner to eachother
        new_owner.addAnimal(new_animal); 
        new_animal.addOwner(new_owner);
        
        clinic.registry.addPT(new_animal); //adds animal to clinics registry
        
        customer_menu2(clinic, new_animal);  //takes user to customer menu 2
        
    }
    
    /**
     * Method allows existing customers to search for their animal via either
     * their own info or the animals info. Method then takes user to customer menu 2.
     * @param clinic 
     */
    public static void existing_customer(Clinic clinic){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        Animal animal = null;
        
        do{
            System.out.print("Select an option:\n1. Search by Animal\n2. "
                    + "Search by Owner\n3. Go Back\n");
            
            choice = in.nextInt();

            switch(choice){
                case 1: System.out.print("\nSearching by Animal...\n");
                animal = clinic.registry.searchByAnimal();break; //will search registry using animals info
                
                case 2: System.out.print("\nSearching by Owner\n");
                animal = clinic.registry.searchByOwner();break; //will search registry using owners info
                
                case 3: System.out.print("\nGoing back...\n");
                main_menu(clinic);break;  //takes user back to main menu
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
            
            customer_menu2(clinic, animal);
        }
        
        while(choice != 3);  //while user does not choose to go back
    }
    
    /**
     * Method presents the 2nd customer menu. This allows them to view/pay their 
     * bill, schedule a treatment for their animal, or add info their animals profile.
     * @param clinic current clinic 
     * @param animal animal whose profile is being accessed
     */
    public static void customer_menu2(Clinic clinic, Animal animal){
                
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        do{
            System.out.print("\nSelect an option:\n1. Billing Menu\n2. Treatment Menu."
                    + "\n3. Add info to patient profile\n4. Go Back\n");
            
            choice = in.nextInt();

            switch(choice){
                case 1: System.out.print("\nYou chose 1, Billing\n");
                billing(clinic, animal);break;  //shows user their bill and allows them to pay it
                
                case 2: System.out.print("\nYou chose 2, Treatments\n");
                treatment_menu(clinic, animal);break;  //takes user to treatment menu
                
                case 3: System.out.print("\nYou chose 3, Add info\n");
                addInfo(clinic, animal);break;  //takes user to add info menu
                
                case 4: System.out.print("\nGoing back...\n");
                customer_menu(clinic);break; //goes back to 1st customer menu
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 4);
    }
    
    /** 
     * This method builds the employee menu, gets the user selection, and uses a switch 
     * statement to  call  the  respective  options.
     * @param clinic
     */ 
    public static void employee_menu(Clinic clinic){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        Animal animal = null;
        
        String search;
         
        do{
            
            System.out.print("Select an option:\n1. Billing Menu\n2. "
                    + "Treatment Menu\n3. Cancel Appointment\n4. Place animal menu\n5. "
                    + "Generate Report\n6. Inventory\n7. Add Patient Information\n8. "
                    + "Go Back\n");
            
            choice = in.nextInt();
            in.nextLine();
            
            /*unless the user chooses to generate a report, access inventory, or 
            go back, the user will be prompted to search for an animal whose profile
            they wish to access*/
            if(choice != 5 && choice != 6 && choice != 8){
                
                do{
                    System.out.println("Search by Animal or Owner?");

                    search = in.next();
                    in.nextLine();

                    System.out.print("\n");

                    //if user chooses animal, search by animal method is called
                    if(search.equalsIgnoreCase("Animal")){

                        animal = clinic.registry.searchByAnimal();

                    }
                    else if(search.equalsIgnoreCase("Owner")){  //will search by owner if desired by user

                        animal = clinic.registry.searchByOwner();

                    }
                }
                /*do while loop will continue to execute as long as the entered
                choice is not either 'animal' or 'owner*/
                while(search.equalsIgnoreCase("Animal") == false && search.equalsIgnoreCase("Owner") == false);
                
            }

            switch(choice){ 
                case 1: System.out.print("\nYou chose 1, Billing\n");
                billing(clinic, animal);break;  //same billing menu us customers
                
                case 2: System.out.print("\nYou chose 2, Treatments\n");
                treatment_menu(clinic, animal);break;
                
                //accesses and deletes a desired appointment from the desired schedule
                case 3: System.out.print("\nYou chose 3, Cancel appointment\n");
                cancel_appointment(clinic, animal);break;  
                
                case 4: System.out.print("\nYou chose 4, Place animal\n");
                place_animal(clinic, animal);break;  //places animal somewhere in the clinic
                
                case 5: System.out.print("\nYou chose 5, Generate Report\n"); 
                clinic.transactions.getReport();break; //gets a year to date financial report
                
                //checks the clinics inventory and allows employee to order more supplies
                case 6: System.out.print("\nYou chose 6, Inventory\n");
                check_inventory(clinic);break;  
                
                case 7: System.out.print("\nYou chose 7, Add Pt. info\n");
                addInfo(clinic, animal);break;  //allows employee to add info to animals profile
                
                case 8: System.out.print("\nGoing back...\n");main_menu(clinic);break;
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 8);
    }
    
    /**
     * Method shows the bill for a given Animals owner and allows them to pay 
     * any amount if they desire
     * @param clinic
     * @param animal 
     */
    public static void billing(Clinic clinic, Animal animal){
        
        Scanner in = new Scanner (System.in);
        
        System.out.println("The current bill is : $" + animal.getOwner().getBill());
        
        System.out.println("Would you like to pay the bill?");
        
        if(in.next().equalsIgnoreCase("Yes")){
            System.out.println("Please enter in amount that is to be paid: ");
            
            //prompts user to enter in amount they wish to desire
            int paidAMT = in.nextInt();
            in.nextLine();
            
            //creates new transaction to use for customers to pay their bill
            Transaction billPay = new Transaction();
           
            //calls billPaid method to allow owner to pay their bill
            billPay.billPaid(animal.getOwner(), animal.getOwner().getBill(), paidAMT);
            
        }
        else{
            System.out.println("Thank you! Goodbye");
            
            //returns to customer menu 2 if the customer does not wish to pay bill
            customer_menu2(clinic, animal);  
        }
    }
    
    /**
     * Method allows user to choose from different treatments to schedule
     * @param clinic
     * @param animal 
     */
    public static void treatment_menu(Clinic clinic, Animal animal){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        do{
           
            System.out.print("\nPlease select a treatment to schedule:\n" 
                    + clinic.printTreatList() + "\n4. Go Back\n");
            
            choice = in.nextInt();
            in.nextLine();

            /*depending on user choice, switch statement will access desired
            calendar and allow user to schedule appointment*/
            switch(choice){
                case 1: System.out.print("\nYou chose 1, Grooming\n");
                clinic.groomingCalendar.schedule(animal);break;
                
                case 2: System.out.print("\nYou chose 2, Surgery\n");
                clinic.surgeryCalendar.schedule(animal);break;
                
                case 3: System.out.print("\nYou chose 3, Checkup\n");
                clinic.checkupCalendar.schedule(animal);break;
                
                case 4: System.out.print("\nGoing Back...\n");main_menu(clinic);break;
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 4);
    }
    
    
    /**
     * Method adds info to Animal patient's profile. Can add allergies, medicine
 and Dr.s notes.
     * @param clinic
     * @param animal Animal whose info will be updated
     */
    public static void addInfo(Clinic clinic, Animal animal){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        do{
           
            System.out.print("\nPlease select which info you would like to add to:"
                    + "\n1. Allergies\n2. Medications\n3. Dr. Notes\n4. Go Back\n");
            
            choice = in.nextInt();
            in.nextLine();
            
            /*if user chooses anything besides to go back, user is prompted to 
            enter in the info they wish to add*/
            if(choice != 4){
                System.out.print("\nEnter in info you wish to add: ");
            }
                       
            String info = in.nextLine();
            
            /*Switch statement allows user to choose which part of the animals
            profile they wish to update*/
            switch(choice){
                case 1: System.out.print("\nYou chose 1, Allergies\n");
                animal.allergies.add(info);break;
                
                case 2: System.out.print("\nYou chose 2, Medications\n");
                animal.medications.add(info);break;
                
                case 3: System.out.print("\nYou chose 3, Dr. Notes\n");
                animal.drNotes.add(info);break;
                
                case 4: System.out.print("\nYou chose 4, Go Back\n");
                main_menu(clinic);break;
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 4);
        
    }
    
    /**
     * Method allows an employee user to cancel an existing appointment.
     * Method asks the employee which calendar to access, this will take them
     * to the appropraite calendar for deletion.
     * @param clinic
     * @param animal 
     */
    public static void cancel_appointment(Clinic clinic, Animal animal){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        do{
           
            System.out.print("\nWhat type of appointment do you wish to cancel?\n1. "
                    + "Surgery\n2. Grooming\n3. Checkup\n4. Go Back\n");
            
            choice = in.nextInt();
            in.nextLine();
            
            /*switch statement will access a specific calendar based on employee 
            choice.*/
            switch(choice){
                case 1: System.out.print("\nAccessing Surgery Calendar...\n");
                clinic.surgeryCalendar.deleteApt(animal);break;
                
                case 2: System.out.print("\nAccessing Grooming Calendar...\n");
                clinic.groomingCalendar.deleteApt(animal);break;
                
                case 3: System.out.print("\nAccessing Checkup Calendar...\n");
                clinic.checkupCalendar.deleteApt(animal);break;
                
                case 4: System.out.print("\nGoing back to employee menu...\n");
                employee_menu(clinic);break;
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 4);
    }
    
    /**
     * Method allows the employee to place an animal somewhere in the clinic
     * depending on which treatment they are there for.
     * @param clinic
     * @param animal 
     */
    public static void place_animal(Clinic clinic, Animal animal){
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        do{
           
            System.out.print("\nWhere are you sending the Patient?\n1. Surgery\n2. "
                    + "Grooming\n3. Dr.s Office\n4. Waiting room\n5. Go Back\n");
            
            choice = in.nextInt();
            in.nextLine();
            
            switch(choice){
                case 1: System.out.print("\nSending the patient to Surgery...\n");
                clinic.sendSurgery(animal);break;
                
                case 2: System.out.print("\nSending the animal to get Groomed...\n");
                clinic.sendGrooming(animal);break;
                
                case 3: System.out.print("\nSending the patient to the Dr.s Office...\n");
                clinic.sendDrOffice(animal);break;
                
                case 4: System.out.print("\nSending animal to the waiting room...\n");
                clinic.sendWaiting(animal);break;
                
                case 5: System.out.print("\nGoing back to the employee menu...\n");
                employee_menu(clinic);break;
                
                default: System.out.printf("You selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 5);
    }
    
    /**
     * Method allows employee user to check the inventory count and order more supplies 
     * if necessary. 
     * @param clinic 
     */
    public static void check_inventory(Clinic clinic){
        
        //An inventory report is first printed
        System.out.println("Checking Inventory...");
        
        clinic.inventory.checkInventory();
        
        Scanner in = new Scanner (System.in);
        
        int choice;
        
        /*based on inventory report, the employee can order different amounts of 
        different supply types.*/
        do{
           
            System.out.print("\nSelect inventory you wish to order: \n1. "
                    + "Medications\n2. Office Supplies\n3. Medical Supplies\n4. "
                    + "Grooming Supplies\n5. Go Back to Employee Menu\n");
            
            choice = in.nextInt();
            in.nextLine();
            
            /*switch statement will create a new transaction object and use it
            to order more of the desired supply items*/
            switch(choice){
                case 1: System.out.print("\nAccessing Medication Inventory...\n");
                Transaction orderMeds = new Transaction();orderMeds.purchaseMeds(clinic.inventory);break;
                
                case 2: System.out.print("\nAccessing Office Supply Inventory...\n");
                Transaction orderOffice = new Transaction();orderOffice.purchaseOffice(clinic.inventory);break;
                
                case 3: System.out.print("\nAccessing Medical Supply Inventory...\n");
                Transaction orderMedSupply = new Transaction();orderMedSupply.purchaseSupply(clinic.inventory);break;
                
                case 4: System.out.print("\nAccessing Grooming Supply Inventory...\n");
                Transaction orderGroom = new Transaction();orderGroom.purchaseGroom(clinic.inventory);break;
                
                case 5: System.out.print("\nGoing back to the employee menu...");
                employee_menu(clinic);break;
                
                default: System.out.printf("\nYou selected %d\nInvalid option\n~~~~~~~~~~~~~~\n", choice);break;
            }
        }
        while(choice != 5);
    }
}
