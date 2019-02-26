/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.test;


import assignmenthandler.ConsoleController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;



/**
 *
 * @author Oliver
 */
public class test
{

    public static void main(String[] args)
    {

            /*boolean active = true;
            
            //Declaring and assigning variables
            String assigments[]
            = {
            "2.1", "2.2", "2.6", "2.7", "2.23", "A.1", "A.2", "A.3"
            };
            
            //Declaring DecimalFormat for rounding of correctly
            DecimalFormat f = new DecimalFormat("##.00");
            
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
            case "2.1":
            System.out.println("2.1");
            System.out.println("---------------");
            
            //Ask user for input
            System.out.println("Convert miles to kilometers. Type input:");
            
            //Declare and assign variables
            double miles = userInput.nextDouble();
            double kilometers = miles * 1.6;
            
            //Print results
            System.out.println(miles + " miles is " + f.format(kilometers) + " kilometers.");
            break;
            
            case "2.2":
            System.out.println("2.2");
            System.out.println("---------------");
            
            //Ask user for input
            System.out.println("Find area and volume of a Equilateral triangle. Enter length of the sides and height of the Equilateral triangle:");
            
            //Declare and assign variables
            double length = userInput.nextDouble();
            double areaT = (Math.sqrt(3) / 4) * Math.pow(length, 2);
            double volume = areaT * length;
            
            //Print results
            System.out.println("The area is " + f.format(areaT));
            System.out.println("The volume of the Triangular prism is " + f.format(volume));
            
            break;
            
            case "2.6":
            System.out.println("2.6");
            System.out.println("---------------");
            
            //Ask user for input
            System.out.println("Find the multiplication of all digits in a number between 0 and 1000. Enter a number between 0 and 1000:");
            
            //Declare and assaign variables
            int number = userInput.nextInt();
            int tempNumber = number;
            int total = 1;
            
            if (number < 0 || number > 1000)
            {
            System.out.println("Your number is not between 0 and 1000.");
            break;
            }
            
            //Find sum of all digits
            while (tempNumber > 0)
            {
            total *= tempNumber % 10;
            tempNumber /= 10;
            }
            
            //Print results
            System.out.println("The multiplication of all digits in " + number + " is " + total);
            break;
            
            case "2.7":
            System.out.println("2.7");
            System.out.println("---------------");
            
            //Ask user for input
            System.out.println("Find the amount of years and days a amount of minutes make up. Enter a number above 0:");
            
            //Declare and assaign variables
            int minutes = userInput.nextInt();
            int year = minutes / 525600;
            int day = (minutes % 525600) / 1440;
            
            if (minutes < 0)
            {
            System.out.println("Your number is not above 0.");
            break;
            }
            
            //Print results
            System.out.println(minutes + " minutes is approximately " + year + " years and " + day + " days.");
            break;
            
            case "2.23":
            System.out.println("2.23");
            System.out.println("---------------");
            
            //Declare variables
            double distance;
            double milesPerGallon;
            double pricePerGallon;
            double price;
            
            //Ask user for input
            System.out.println("Calculate the cost of driving. First enter the driving distance:");
            distance = userInput.nextDouble();
            System.out.println("Then enter the miles per gallon of the car:");
            milesPerGallon = userInput.nextDouble();
            System.out.println("Lastly enter the fuel's cost per gallon:");
            pricePerGallon = userInput.nextDouble();
            
            //Check if any value is less than one
            if (distance < 0 || milesPerGallon <= 0 || pricePerGallon < 0)
            {
            System.out.println("Invalid values.");
            break;
            } else
            {
            price = distance / milesPerGallon * pricePerGallon;
            System.out.println("The price of driving is DKK " + f.format(price));
            }
            
            break;
            
            case "A.1":
            System.out.println("A.1");
            System.out.println("---------------");
            //Declaring and assigning variables
            double radius = 1.0;
            double area;
            
            //Computing areal for different radius
            for (int i = 0; i < 5; i++)
            {
            //Computing area
            area = Math.pow(radius, 2.0) * Math.PI;
            
            //Displaying area
            System.out.println("The areal of a circle with a radius of " + radius + " is " + f.format(area));
            
            //Enlarge radius by one;
            radius++;
            }
            break;
            
            case "A.2":
            System.out.println("A.2");
            System.out.println("---------------");
            
            //Declaring variables
            double radius1;
            double radius2;
            double circumference1;
            double circumference2;
            double sum;
            
            //Calculating circumference for a radius 3
            radius1 = 3;
            circumference1 = 2 * Math.PI * radius1;
            
            //Calculating circumference for a radius 7
            radius2 = 7;
            circumference2 = 2 * Math.PI * radius2;
            
            //Calculating sum
            sum = circumference1 + circumference2;
            
            //Display sum
            System.out.println("The sum of the two circumferences of the circles with radius " + radius1 + " and " + radius2 + " is " + f.format(sum));
            break;
            
            case "A.3":
            System.out.println("A.3");
            System.out.println("---------------");
            
            //Announce assignment
            System.out.println("Find the temperature differences between two days!");
            //Declaring and assigning variables
            double temperatures[]
            =
            {
            21.5, 23.7, 19.6, 22.5, 25.3, 21.7, 18.9
            };
            String days[]
            =
            {
            "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"
            };
            double temp1 = 0;
            double temp2 = 0;
            boolean invalid = false;
            double difference;
            String day1 = "";
            String day2 = "";
            
            //Announce input
            System.out.println("Type in the first day:");
            
            
            day1 = userInput.nextLine();
            
            //Find temperature for day
            if (Arrays.asList(days).indexOf(day1.toLowerCase()) != -1)
            {
            temp1 = temperatures[Arrays.asList(days).indexOf(day1.toLowerCase())];
            } else
            {
            //Errormessage
            System.out.println("Invalid day");
            invalid = true;
            }
            if (invalid == false)
            {
            
            //Announce input
            System.out.println("Type in the second day:");
            
            //Input
            day2 = userInput.nextLine();
            
            //Find temperature for day
            if (Arrays.asList(days).indexOf(day2.toLowerCase()) != -1)
            {
            temp2 = temperatures[Arrays.asList(days).indexOf(day2.toLowerCase())];
            } else
            {
            //Errormessage
            System.out.println("Invalid day");
            invalid = true;
            }
            }
            
            if (invalid == false)
            {
            //Calculate difference
            difference = Math.abs(Math.abs(temp1) - Math.abs(temp2));
            System.out.println("The difference in temperature between " + day1 + " and " + day2 + " is " + f.format(difference) + " degrees celcius");
            } else
            {
            //Errormessage
            System.out.println("Something went wrong");
            }
            
            break;
            
            case "HELP":
            for (int i = 0; i < assigments.length; i++)
            {
            System.out.println(assigments[i]);
            }
            break;
            
            case "STOP":
            case "EXIT":
            active = false;
            break;
            
            default:
            System.out.println("Invalid program. Type 'help' to see availible programs.");
            break;
            }
            }*/
            
                System.out.println("Testln:");
                System.out.printf("%d. %s \t\t $%.2f\n", 1, "BOOK", 2.5f);
                System.out.print("Test: \n");
                Scanner s = new Scanner(System.in);
                System.out.println(s.next());
               

            
            
            
    }
}
