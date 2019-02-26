/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem1oop.l6;

import java.util.Scanner;

/**
 *
 * @author Oliver
 */
public class Module006
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        boolean active = true;
        while (active)
        {

            //Introduction to program
            System.out.println("---------------");
            System.out.println("Please write the name of a program:");
            System.out.println("---------------");

            //Listen for program names
            Scanner userInput = new Scanner(System.in);
            String programName = userInput.nextLine();

            //Initialise program
            switch (programName.toUpperCase())
            {
                case "1":
                    System.out.println("1");
                    System.out.println("---------------");
                    
                    //Declaring variable
                    Customer aCustomer = new Customer("Kakarotto Son Gokū", 42, 9000.1);
                    
                    //Depositing $10
                    aCustomer.deposit(10);
                    
                    //Withdrawing $5
                    aCustomer.withdraw(5);
                    
                    System.out.println("The balance of "+aCustomer.name+" is "+aCustomer.getBalance());
                    break;
                    
                case "2":
                    System.out.println("2");
                    System.out.println("---------------");
                    
                    //Declaring variables
                    CustomerDatabase aCustomerDatabase = new CustomerDatabase();
                    Customer aNewCustomer = new Customer("Kakarotto Son Gokū", 42, 9000.1);
                    Customer anotherNewCustomer = new Customer("Pusjme Tooda Edj", 1, 50);
                    Customer onemoreNewCustomer = new Customer("Almar Frenz Aded", 2, -100);
                    
                    //Adding a few customers
                    aCustomerDatabase.createCustomer(aNewCustomer);
                    aCustomerDatabase.createCustomer(anotherNewCustomer);
                    aCustomerDatabase.createCustomer(onemoreNewCustomer);
                    
                    //Removing a customer
                    aCustomerDatabase.removeCustomer(42);
                    
                    //Getting info about a customer
                    Customer copiedCustomer = aCustomerDatabase.getCustomer(2);
                    
                    //Printing customers
                    aCustomerDatabase.printCustomers();
                    break;    

                case "STOP":
                case "EXIT":
                    active = false;
                    break;
            }        
        }    
    }
    
}
