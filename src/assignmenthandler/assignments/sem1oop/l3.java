/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem1oop;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Oliver
 */
public class l3
{

    public static void main(String[] args)
    {
        boolean active = true;

        //Declaring and assigning variables
        String assigments[] =
        {
            "2.7", "3.1", "5.3", "5.5", "5.7", "B.1", "B.4", "B.5"
        };

        //Declaring DecimalFormat for rounding of correctly
        DecimalFormat f = new DecimalFormat("##.00");

        //Looping program
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

                case "3.1":
                    System.out.println("3.1");
                    System.out.println("---------------");

                    //Declare variables
                    double a,
                     b,
                     c,
                     d,
                     r1,
                     r2;

                    //Ask user for input
                    System.out.println("Find the roots of a quadratic equation. First enter 'a':");
                    a = userInput.nextDouble();
                    System.out.println("Then enter 'b':");
                    b = userInput.nextDouble();
                    System.out.println("Finally, enter 'c':");
                    c = userInput.nextDouble();
                    d = Math.pow(b, 2) - 4 * a * c;

                    if (d == 0)
                    {
                        r1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
                        System.out.println("The root of the equation is " + f.format(r1));
                    } else if (d < 0)
                    {
                        System.out.println("The roots for this equation does not lie within the real of natural numbers");
                    } else if (d > 0)
                    {
                        r1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
                        r2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
                        System.out.println("The roots of the equation is " + f.format(r1) + " and " + f.format(r2));
                    } else
                    {
                        System.out.println("Invalid input");
                    }
                    break;

                case "5.3":
                    System.out.println("5.3");
                    System.out.println("---------------");

                    //Explanation of program
                    System.out.println("A conversiontable form Celcius to Fahrenheit");
                    System.out.printf("%-10s%10s%n", "Celcius", "Fehrenheit");

                    for (int t = 0; t <= 100; t += 2)
                    {
                        final int FEHRENHEIT_CONVERSION_CONSTANT = t * 9 / 5 + 32;
                        /*
                        //Because i like pretty
                        String space = "                ";
                        if (t == 100)
                        {
                            space = "              ";
                        } else if (t >= 10)
                        {
                            space = "               ";
                        }
                        System.out.println(t + space + FEHRENHEIT_CONVERSION_CONSTANT);
                         */
                        System.out.printf("%-10d%10d%n", t, FEHRENHEIT_CONVERSION_CONSTANT);
                    }

                    break;

                case "5.5":
                    System.out.println("5.5");
                    System.out.println("---------------");

                    //Explanation of program
                    System.out.println("A conversiontable form Celcius to Fahrenheit and Fahrenheit to Celcius");
                    System.out.printf("%-10s%10s | %-10s%10s%n", "Celcius", "Fehrenheit", "Fehrenheit", "Celcius");

                    //Declaring and assigning variables
                    int fe = 20;

                    for (int ce = 0; ce <= 100; ce += 2)
                    {
                        final int FEHRENHEIT_CONVERSION_CONSTANT = ce * 9 / 5 + 32;
                        final int CELCIUS_CONVERSION_CONSTANT = fe / 9 * 5 - 32;
                        /*
                        //Because i like pretty
                        String space = "                ";
                        String space2 = "           ";
                        String space3 = "                  ";
                        if (ce == 100)
                        {
                            space = "              ";
                        } else if (ce >= 10)
                        {
                            space = "               ";
                        }
                        if (FEHRENHEIT_CONVERSION_CONSTANT >= 100)
                        {
                            space2 = "          ";
                        }
                        if (fe >= 100)
                        {
                            space3 = "                 ";
                        }
                        System.out.println(ce + space + FEHRENHEIT_CONVERSION_CONSTANT + space2 + "|   " + fe + space3 + CELCIUS_CONVERSION_CONSTANT);
                         */
                        System.out.printf("%-10d%10d | %-10d%10d%n", ce, FEHRENHEIT_CONVERSION_CONSTANT, fe, CELCIUS_CONVERSION_CONSTANT);
                        fe += 5;

                    }
                    break;

                case "5.7":
                    System.out.println("5.7");
                    System.out.println("---------------");

                    //Explanation of program
                    System.out.println("Tuition-calculator");

                    //Declaring and assigning variables
                    final double PERCENT = 0.06;
                    final int TUITION_AT_START = 10000;
                    final double TUITION_IN_TEN_YEARS = TUITION_AT_START * Math.pow(1 + PERCENT, 10);
                    double costsForFourYearsAfterTenYears = 0;

                    for (int i = 0; i <= 4; i++)
                    {
                        costsForFourYearsAfterTenYears += TUITION_IN_TEN_YEARS * Math.pow(1 + PERCENT, i);
                    }

                    System.out.println("The tuition in 10 years will be: $" + f.format(TUITION_IN_TEN_YEARS));
                    System.out.println("The cost for 4 years of tuition after ten years will be: $" + f.format(costsForFourYearsAfterTenYears));

                    break;

                case "B.1":
                    System.out.println("B.1");
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

                case "B.4":
                    System.out.println("B.4");
                    System.out.println("---------------");

                    //Announce assignment
                    System.out.println("Find the amount of days in a given month!");
                    //Declaring and assigning variables
                    int daysInMonths[] =
                    {
                        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
                    };
                    String months[] =
                    {
                        "january", "febuary", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"
                    };
                    String month;
                    int daysInMonth = 0;

                    //Announce input
                    System.out.println("Type in the month:");
                    month = userInput.nextLine();

                    if (Arrays.asList(months).indexOf(month.toLowerCase()) != -1)
                    {
                        daysInMonth = daysInMonths[Arrays.asList(months).indexOf(month.toLowerCase())];
                        System.out.println("In " + month + " there is " + daysInMonth + " days.");
                    } else
                    {
                        //Errormessage
                        System.out.println("Invalid month");
                        break;
                    }

                    break;

                case "B.5":
                    System.out.println("B.5");
                    System.out.println("---------------");

                    //Announce assignment
                    System.out.println("Find the largest primenumber under 1,000,000");

                    //Declaring and assigning variables
                    int largestPrime = 0;
                    long time = System.nanoTime();

                    //Counting down from 1000000
                    for (int i = 3; i <= 1000000; i += 2)
                    {
                        boolean notPrime = false;
                        for (int in = 2; in < Math.sqrt(i); in++)
                        {
                            if (i % in == 0)
                            {
                                notPrime = true;
                                break;
                            }
                        }
                        if (!notPrime)
                        {
                            largestPrime = i;
                        }
                    }

                    System.out.println("The largest prime under 1,000,000 is: " + largestPrime);
                    System.out.println("This took " + f.format((double) (System.nanoTime() - time) / 1000000000) + " seconds");

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
        }
    }
}

