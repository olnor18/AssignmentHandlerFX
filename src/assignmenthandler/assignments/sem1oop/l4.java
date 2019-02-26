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
public class l4
{
    public static void main(String[] args)
    {
        boolean active = true;
        //The array which is used for listing the assignments by the 'help' command
        String assigments[] =
        {
            "X.X", "Y.Y",
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
                case "7.3":
                    System.out.println("7.3");
                    System.out.println("---------------");

                    //The predetermined input
                    int input[] =
                    {
                        2, 5, 6, 5, 4, 3, 23, 43, 2, 0
                    };

                    /*
                    *Input if one would like the user to type in an array.
                     */
                    System.out.println("Please type in a list of numbers between 1 and 50. Seperate each number by a space. End by a '0'");

                    int inputAdvanced[] = new int[50]; //Array of 50 numbers
                    int tempInput;

                    while (true)
                    {
                        if (userInput.hasNextInt())
                        {
                            tempInput = userInput.nextInt();
                            if (tempInput > 50 || tempInput < 0)
                            {
                                System.out.println("Numbers over 50 and under 0 aren't allowed");
                            } else if (tempInput > 0)
                            {
                                inputAdvanced[tempInput - 1] += 1; //Ads one to the counter for each number in inputAdvanced[]
                            } else
                            {
                                break;
                            }

                        }
                    }

                    for (int i = 0; i < inputAdvanced.length; i++)
                    {
                        if (inputAdvanced[i] > 0)
                        {
                            if (inputAdvanced[i] > 1)
                            {
                                System.out.printf("%d occurs %d times%n", (i + 1), inputAdvanced[i]);
                            } else
                            {
                                System.out.printf("%d occurs %d time%n", (i + 1), inputAdvanced[i]);
                            }
                        }
                    }

                    break;

                case "8.2":
                    System.out.println("8.2");
                    System.out.println("---------------");

                    System.out.println("Find the average of the major diagonal in a matrix with n*n dimentions");
                    int x;
                    int y;
                    double average = 0;
                    int divisor = 0;
                    System.out.println("Enter the x-length of the matrix");
                    x = userInput.nextInt();
                    System.out.println("Enter the y-length of the matrix");
                    y = userInput.nextInt();
                    double[][] matrix = new double[y][x];

                    for (int i = 0; i < y; i++)
                    {
                        System.out.println("Enter line " + i + ":");
                        for (int j = 0; j < x; j++)
                        {
                            matrix[i][j] = userInput.nextDouble();
                        }
                    }

                    for (int i = 0; i < x; i++)
                    {
                        if (i < y)
                        {
                            average += matrix[i][i];
                            divisor++;

                        }
                    }

                    average /= divisor;
                    System.out.println("Average of the elements in the major diagonal is " + average);
                    break;

                case "C.1":
                    System.out.println("C.1");
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

                case "C.3":
                    System.out.println("C.3");
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

                    /*Day One*/
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
                        /*Day Two*/
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

                case "C.4":
                    System.out.println("C.4");
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

                case "C.5":
                    System.out.println("C.5");
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

                case "C.6":
                    System.out.println("C.6");
                    System.out.println("---------------");

                    //Announce assignment
                    System.out.println("Find the largest number in an array");

                    //Declaring and assigning variables
                    int array[] =
                    {
                        1, 2, 5, 24, 10, 20, 8, 2, 0, 25, 4
                    };
                    int highestIntPlacement = 0;

                    //Calculating highest int
                    for (int i = 0; i < array.length; i++)
                    {
                        if (array[i] > array[highestIntPlacement])
                        {
                            highestIntPlacement = 1;
                        }
                    }

                    System.out.println("The highest int in the array is " + array[highestIntPlacement]);
                    break;

                case "C.7":
                    System.out.println("C.7");
                    System.out.println("---------------");

                    //Announce assignment
                    System.out.println("Game of life");
                    int[][] seed =
                    {
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0
                        },
                        {
                            0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0
                        },
                        {
                            0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0
                        },
                        {
                            0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0
                        },
                        {
                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                        },
                    };

                    int[][] buffer = new int[seed.length][seed[0].length];

                    //GameLoop
                    boolean running = true;
                    int itterations = 0;
                    while (running)
                    {

                        for (int i = 0; i < seed.length; i++)
                        {
                            System.arraycopy(seed[i], 0, buffer[i], 0, seed[i].length);
                        }

                        for (int i = 0; i < seed.length; i++)
                        {
                            for (int j = 0; j < seed[i].length; j++)
                            {
                                int population = 0;

                                for (int k = -1 + i; k <= i + 1; k++)
                                {
                                    for (int l = -1 + j; l <= j + 1; l++)
                                    {
                                        if (k >= 0 && l >= 0 && k < seed.length && l < seed[i].length && seed[k][l] == 1)
                                        {
                                            population++;
                                        }
                                    }
                                }

                                if (buffer[i][j] == 1)
                                {

                                    if (population < 2)
                                    {
                                        buffer[i][j] = 0;

                                    } else if (population > 3)
                                    {
                                        buffer[i][j] = 0;

                                    }

                                } else if (buffer[i][j] == 0 && population == 3)
                                {
                                    buffer[i][j] = 1;

                                } else
                                {

                                }

                            }
                        }

                        for (int i = 0; i < buffer.length; i++)
                        {
                            for (int j = 0; j < buffer[i].length; j++)
                            {
                                System.out.printf(buffer[i][j] + " ");
                            }

                            System.out.printf("%n");
                        }

                        System.out.printf("%n");

                        if (itterations == 10)
                        {
                            running = false;
                        } else
                        {
                            itterations++;
                        }

                        for (int i = 0; i < buffer.length; i++)
                        {
                            System.arraycopy(buffer[i], 0, seed[i], 0, buffer[i].length);
                        }

                        try
                        {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex)
                        {
                            ex.printStackTrace();
                        }

                    }
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
                case "EXIT":
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
