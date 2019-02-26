/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem1oop.l8;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Oliver
 */
public class Modul008 
{
        public static void main(String[] args)
        {
        boolean active = true;
    
        //The array which is used for listing the assignments by the 'help' command
        String assigments[] =
        {
            "9.3", "9.8",
        };
        

        //This is a variable which enables for rounding a number to two decimals - it's used like this 'f.format(5.21521124)'
        DecimalFormat f = new DecimalFormat("##.00");

        //Allows for selected multiple assignments without re-running the program
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
            switch (programName.toUpperCase()) //'.toUpperCase()' allow for avoiding casesensitivity
            {
                case "9.3":
                    for (long i = 10000L; i <= 100000000000L; i *= 10L)
                    {
                        Date d = new Date(i);
                        System.out.println("The date after " + i + " seconds is "+ d.toString());
                    }    
                    break;
                    
                case "9.8":
                    Fan fan1 = new Fan(true, 3, 10, "yellow");
                    Fan fan2 = new Fan(true, 2, 5, "blue");
                    
                    System.out.println(fan1.toString());
                    System.out.println(fan2.toString());
                    
                    Date d = new Date(1000000000000L);
                    System.out.println(fan1.toString(d));
                    
                    break;
                   
                //A command for listing all assignments in the module
                case "HELP":
                    for (int i = 0; i < assigments.length; i++)
                    {
                        System.out.println(assigments[i]);
                    }
                    break;
                
                //Stops the while-loop and returning to the assignment-picker
                case "STOP":
                case "exit":
                    active = false;
                    break;
                
                //If the input is not recognized the following is System.out.printlned   
                default:
                    System.out.println("Invalid program. Type 'help' to see availible programs.");
                    break;
            }
        }    
    }
}
