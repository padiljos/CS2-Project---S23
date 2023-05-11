/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package vet_clinic_gui;

import java.util.Scanner;

/**
 *
 * @author Vince Gnodle
 * Class creates transaction objects to charge a bill to owners, keep financial records,
 * and provide a year to date financial report.
 */
public class Transaction {
    
    /*All counts are static therefore they will maintain total counts for all
    transactions performed/created in conjunction with the specified clinic*/
    private static int totalSpent = 0;  //maintains a total count of money spent 
    private static int totalEarned = 0;  //Total money earned
    private static int officeExpenses = 0;  //Total spent on office supply items
    private static int medicationExpenses = 0;  //Total spent on medications
    private static int supplyExpenses = 0;  //Total spent on medical supply items
    private static int groomingExpenses = 0; //Total spent on grooming supply items
    

    /**
     * Transaction constructor
     */
    public Transaction() {
    }
    
    /**
     * Method allows an owner of an animal patient to see and pay their current bill
     * @param owner
     * @param billedAmt int, amount owner owes
     * @param paidAmount int, amount owner wishes to pay
     */
    public void billPaid(Owner owner, int billedAmt, int paidAmount){
        
        System.out.println(owner.getName() + "'s Total Bill is: $" + owner.getBill());
        System.out.println("Amount paid: $" + paidAmount);
        System.out.println("Amount still owed: $" + (billedAmt - paidAmount) + "\n");
        
        owner.bill -= paidAmount;  //paid amount subtracted from owners bill
        
        totalEarned += paidAmount;  //paid amount added to clinics totalEarned
        
        this.addPayments(owner, paidAmount);  //payment is added to owners payments list
    }
    
    /**
     * Method purchases more medications for the clinics inventory and increases
     * amount spent on medications and total amount spent.
     * @param inventory clinic inventory
     * @param quantity 
     */
    public void purchaseMeds(Inventory inventory, int quantity){
        
        totalSpent += 50*quantity;  //calculates amount spent and adds to total
        medicationExpenses += 50*quantity; //calculates amount spent and adds to medication expenses
        inventory.changeMedications(quantity);  //increases medication inventory by quantity desired
    }
    
    /**
     * Method purchases more office supplies for the clinics inventory and increases
     * amount spent on office supplies and total amount spent.
     * @param inventory 
     * @param quantity 
     */
    public void purchaseOffice(Inventory inventory, int quantity){
        
        //Calculates amount spent and adds it to totalSpent and officeExpenses
        totalSpent += 20*quantity;
        officeExpenses += 20*quantity;
        inventory.changeOfficeSupply(quantity);  //increases office supply count in clinics inventory
    }
    
    /**
     * Method purchases more medical supplies for the clinics inventory and increases
     * amount spent on medical supplies and total amount spent.
     * @param inventory 
     * @param quantity 
     */
    public void purchaseSupply(Inventory inventory, int quantity){
        
        totalSpent += 100*quantity;
        supplyExpenses += 100*quantity;
        inventory.changeMedicalSupply(quantity);
    }
    
    /**
     * Method purchases more grooming supplies for the clinics inventory and increases
     * amount spent on grooming supplies and total amount spent.
     * @param inventory 
     * @param quantity 
     */
    public void purchaseGroom(Inventory inventory, int quantity){
        
        totalSpent += 30*quantity;
        groomingExpenses += 30*quantity;
        inventory.changeGroomSupply(quantity);
    }
    
    /**
     * Method calculates profit made this year to date
     * @return the profit calculated
     */
    public int calcProfit(){
        return totalEarned - totalSpent;  //Calculates profit by subtracting total spent from total earned
    }
    
    /**
     * Method prints a report of all income and expenses this year to date
     * @return Financial report
     */
    public String getReport(){
        return("Financial Report\nYear to date profit: $" + this.calcProfit() + "\n\nYear to date income: $"
                + totalEarned + "\nYear to date expenses: $" + totalSpent 
                + "\n\nYear to date amount spent on Medications: $" + medicationExpenses
                + "\nYear to date amount spent on Office Supplies: $" + officeExpenses
                + "\nYear to date amount spent on Medical Supplies: $" + supplyExpenses
                + "\nYear to date amount spent on Grooming Supplies: $" + groomingExpenses + "\n");
    }
    
    /**
     * Method sets all expenses back to 0 when desired
     */
    public void resetExpenses(){
        
        totalSpent = 0;
        officeExpenses = 0;
        medicationExpenses = 0;
        supplyExpenses = 0;
        groomingExpenses = 0;
        
    }
    
    /**
     * Method sets income back to 0 when desired, usually on a yearly basis
     */
    public void resetIncome(){
        totalEarned = 0;
    }
    
    /**
     * Method adds the amount paid by an animals owner, to the owners payment history
     * @param owner
     * @param paidAMT int, amount paid by owner
     */
    public void addPayments(Owner owner, int paidAMT){
        owner.payments.add("Bill Paid in the amount of: $" + paidAMT);
    }
}
