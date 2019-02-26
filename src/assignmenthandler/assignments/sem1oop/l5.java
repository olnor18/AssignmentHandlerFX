/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem1oop;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Oliver
 */
public class l5
{

    public static void main(String[] args)
    {
        boolean active = true;
        //The array which is used for listing the assignments by the 'help' command
        String assigments[] =
        {
            "6.2", "6.3", "6.8", "6.22", "6.25", "6.28", "D.2", "D.5", "D.7", "D.8"
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
                //<editor-fold defaultstate="collapsed" desc="6.2">
                case "6.2":
                    System.out.println("6.2");
                    System.out.println("---------------");

                    //Ask user for input
                    System.out.println("Find the sum of all digits in a number. Enter a number:");

                    //Declare and assaign variables
                    int number = userInput.nextInt();
                    int total = sumDigits(number);

                    //Print results
                    System.out.println("The multiplication of all digits in " + number + " is " + total);

                    break;
                //</editor-fold>    
                //<editor-fold defaultstate="collapsed" desc="6.3">
                case "6.3":
                    System.out.println("6.3");
                    System.out.println("---------------");

                    //Ask user for input
                    System.out.println("Check if a number is a palindrome. Enter a number:");

                    //Declare and assaign variables
                    int n = userInput.nextInt();

                    if (isPalindrome(n) == true)
                    {
                        System.out.println("The number " + n + " is a palindrome: " + reverse(n));
                    } else
                    {
                        System.out.println("The number " + n + " is not a palindrome: " + reverse(n));
                    }
                    break;
                //</editor-fold>  
                //<editor-fold defaultstate="collapsed" desc="6.8">    
                case "6.8":
                    System.out.println("6.8");
                    System.out.println("---------------");
                    System.out.println("A conversiontable form Miles to Kilometers and Kilometers to Miles");
                    System.out.printf("%-10s%10s | %-10s%10s%n", "Miles", "Kilometers", "Kilometers", "Miles");

                    double km = 20;

                    for (double mi = 1; mi <= 10; mi += 1)
                    {
                        System.out.printf("%-10s%10s | %-10s%10s%n", f.format(mi), f.format(mileToKilometer(mi)), f.format(km), f.format(kilometerToMile(km)));
                        km += 5;
                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="6.22">    
                case "6.22":
                    System.out.println("6.22");
                    System.out.println("---------------");
                    double t = 0.0001;

                    //Ask user for input
                    System.out.println("Find a numbers square root with the tolerence " + t + ". Enter a number:");

                    //Declare and assaign variables
                    long n622 = userInput.nextLong();

                    System.out.println("The square root of " + n622 + " is " + f.format(sqrt(n622, t)));
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="6.25">    
                case "6.25":
                    System.out.println("6.25");
                    System.out.println("---------------");

                    //Ask user for input
                    System.out.println("Convert milliseconds to hours, minuttes and seconds. Enter a number:");

                    //Declare and assaign variables
                    long millis = userInput.nextLong();

                    System.out.println(convertMillis(millis));
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="6.28">    
                case "6.28":
                    System.out.println("6.28");
                    System.out.println("---------------");

                    System.out.println("Finding all mersenne primes with p <= 31");

                    System.out.println("p         2^p - 1");
                    System.out.println("-----------------------");
                    for (int i = 2; i <= 31; i++)
                    {
                        if (isPrime(i) && isPrime(getMersennePrime(i)))
                        {
                            System.out.printf("%-9d %-5d %n", i, getMersennePrime(i));
                        }
                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="D.2">    
                case "D.2":
                    System.out.println("D.2");
                    System.out.println("---------------");
                    System.out.println("The sum of the circumference of two circles with radius 3 and 7 is " + f.format(circleCircumference(3) + circleCircumference(7)));
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="D.5">    
                case "D.5":
                    System.out.println("D.5");
                    System.out.println("---------------");
                    init();
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="D.7">    
                case "D.7":
                    System.out.println("D.7");
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

                        arrayCopy(seed, buffer);

                        for (int x = 0; x < seed.length; x++)
                        {
                            for (int y = 0; y < seed[x].length; y++)
                            {
                                int population = population(x, y, seed);
                                updateGame(x, y, population, buffer);
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

                        arrayCopy(buffer, seed);

                        try
                        {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex)
                        {
                            ex.printStackTrace();
                        }

                    }
                    break;
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="D.8">    
                case "D.8":
                    System.out.println("D.8");
                    System.out.println("---------------");
                    int[][] sudoku =
                    {
                        {
                            1, 2, 3, 1, 2, 3, 1, 2, 3
                        },
                        {
                            4, 5, 6, 4, 5, 6, 4, 5, 6
                        },
                        {
                            7, 8, 9, 7, 8, 9, 7, 8, 9
                        },
                        {
                            1, 2, 3, 1, 2, 3, 1, 2, 3
                        },
                        {
                            4, 5, 6, 4, 5, 6, 4, 5, 6
                        },
                        {
                            7, 8, 9, 7, 8, 9, 7, 8, 9
                        },
                        {
                            1, 2, 3, 1, 2, 3, 1, 2, 3
                        },
                        {
                            4, 5, 6, 4, 5, 6, 4, 5, 6
                        },
                        {
                            7, 8, 9, 7, 8, 9, 7, 8, 9
                        },
                    };
                    System.out.println("The suduki is " + (sudokuIsCorrect(sudoku) ? "" : "not ") + "correct");
                    break;
                //</editor-fold>
                //A command for listing all assignments in the module
                case "HELP":
                    for (String assigment : assigments)
                    {
                        System.out.println(assigment);
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

    /**
     * Methods for the different assignments goes under here
     */
    //6.2
    /**
     * Calculates the sum of all the digits in a number
     *
     * @param n The long which digits will be summed
     * @return The sum of the digits in the given Long in the type of int
     */
    public static int sumDigits(long n)
    {
        int output = 0;
        //Find sum of all digits
        while (n > 0)
        {
            output += n % 10;
            n /= 10;
        }

        return output;
    }

    //6.3
    /**
     * Reverses a given number
     *
     * @param number The int which digits will be reversed
     * @return The the reversed int
     */
    public static int reverse(int number)
    {
        int output = 0;
        int length = (int) (Math.log10(number) + 1);
        int tempStorage[] = new int[length];
        //Reverse all digits
        int i = 0;
        while (number > 0)
        {
            tempStorage[i++] = number % 10;
            number /= 10;
        }

        //Combine array to int
        for (int j = 0; j <= length - 1; j++)
        {
            output += tempStorage[j] * Math.pow(10, length - 1 - j);
        }
        return output;
    }

    /**
     * Checks if a number is a palindrome
     *
     * @param number The number which will be checked if it is a palindrome
     * @return A boolean depending on whether if it is a palindrome
     */
    public static boolean isPalindrome(int number)
    {
        boolean output = false;
        if (number == reverse(number))
        {
            output = true;
        }
        return output;
    }

    //6.8
    /**
     * Converts miles to kilometers
     *
     * @param mile A double representing the amount of miles to be converted
     * @return A double with the miles converted to kilometers
     */
    public static double mileToKilometer(double mile)
    {
        double output = mile * 1.6;
        return output;
    }

    /**
     * Converts kilometers to miles
     *
     * @param kilometer A double representing the amount of kilometers to be
     * converted
     * @return A double with the kilometers converted to miles
     */
    public static double kilometerToMile(double kilometer)
    {
        double output = kilometer / 1.6;
        return output;
    }

    //6.22
    /**
     * Calculates a square root of a number with a given tolerance
     *
     * @param n The number which square root is to be found
     * @param t The tolerance of how close to the actual square root the result
     * has to be
     * @return The square root of the given number
     */
    public static double sqrt(long n, double t)
    {
        double output = 0;
        double nextGuess = n;
        double lastGuess = n;

        boolean notSqrt = true;

        while (notSqrt)
        {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + (n / lastGuess)) / 2;
            if ((Math.abs(nextGuess - lastGuess) < t))
            {
                output = nextGuess;
                notSqrt = false;
            }
        }

        return output;
    }

    //6.25
    /**
     * milliseconds converted into the format 'hours:minutes:seconds'
     *
     * @param millis An amount of milliseconds
     * @return The amount of milliseconds converted into the format
     * 'hours:minutes:seconds'
     */
    public static String convertMillis(long millis)
    {
        long hours = millis / 3600000;
        long minutes = (millis % 3600000) / 60000;
        long seconds = ((millis % 3600000) % 60000) / 1000;

        String output = String.format("%d:%d:%d", hours, minutes, seconds);
        return output;
    }

    //6.28
    /**
     * Returns Mersenne prime of the format 2^p-1
     *
     * @param prime A prime, p
     * @return A possible Mersenne prime of the format 2^p-1
     */
    public static int getMersennePrime(int prime)
    {
        return (int) Math.pow(2, prime) - 1;
    }

    //D.2
    /**
     * Calculates the circumference of the circle with the given radius
     *
     * @param radius The radius of a circle
     * @return The circumference of the circle with the given radius
     */
    public static double circleCircumference(double radius)
    {
        double circumference = Math.PI * 2 * radius;
        return circumference;
    }

    //D.5
    /**
     * A method that runs the task
     */
    public static void init()
    {
        for (int i = 100; i <= 200; i++)
        {
            System.out.println(i + " is " + (!isPrime(i) ? "not " : "") + "a prime number.");
        }
    }

    //D.7
    /**
     * This gets the amount of neighbours that are alive
     *
     * @param x The x-coordinate of the cell which neighbours is checked
     * @param y The y-coordinate of the cell which neighbours is checked
     * @param array The array of the cells
     * @return The amount of neighbours that are alive
     */
    public static int population(int x, int y, int[][] array)
    {
        int population = 0;
        for (int i = -1 + x; i <= x + 1; i++)
        {
            for (int j = -1 + y; j <= y + 1; j++)
            {
                if (i >= 0 && j >= 0 && i < array.length && j < array[x].length && array[i][j] == 1)
                {
                    if (i != x || j != y)
                    {
                        population++;
                    }
                }
            }
        }
        return population;
    }

    /**
     * This is updates the cell-array by the rules of the game
     *
     * @param x The x-coordinate of the cell which neighbours is checked
     * @param y The y-coordinate of the cell which neighbours is checked
     * @param population The amount of neighbours that are alive
     * @param array The array of the cells
     */
    public static void updateGame(int x, int y, int population, int[][] array)
    {
        if (array[x][y] == 1)
        {
            if (population < 2 || population > 3)
            {
                array[x][y] = 0;
            }
        } else if (array[x][y] == 0 && population == 3)
        {
            array[x][y] = 1;
        }
    }

    //D.8
    /**
     * Check if a sudoku is correctly filled-out
     *
     * @param sudoku A sudoku in the form of a two-dimension int array
     * @return A boolean depending on whether it is a correctly filled-out
     * sudoku
     */
    public static boolean sudokuIsCorrect(int[][] sudoku)
    {
        boolean output = true;
        for (int x = 0; x < 6; x += 3)
        {
            for (int y = 0; y < 6; y += 3)
            {
                boolean[] sudokuSubgrid = new boolean[9];
                for (int i = x; i < x + 3; i++)
                {
                    for (int j = y; j < y + 3; j++)
                    {
                        sudokuSubgrid[sudoku[i][j] - 1] = true;
                    }
                }

                for (int i = 0; i < sudokuSubgrid.length; i++)
                {
                    if (sudokuSubgrid[i] == false)
                    {
                        output = false;
                    }
                }

            }
        }
        return output;
    }

    //ETC
    /**
     * Check if a positive integer is a prime
     *
     * @param p A positive integer
     * @return A boolean depending on whether it is a prime
     */
    public static boolean isPrime(int p)
    {
        boolean output = false;

        //Check if prime
        boolean notPrime = false;
        for (int in = 2; in < Math.sqrt(p); in++)
        {
            if (p % in == 0)
            {
                notPrime = true;
                break;
            }
        }
        if (!notPrime)
        {
            output = true;
        }

        return output;
    }

    /**
     * Copy an array into another
     *
     * @param sourceArray The source array, from which the data gets copied
     * @param targetArray The target array, to which the data gets copied
     */
    public static void arrayCopy(int[][] sourceArray, int[][] targetArray)
    {
        for (int i = 0; i < sourceArray.length; i++)
        {
            System.arraycopy(sourceArray[i], 0, targetArray[i], 0, sourceArray[i].length);
        }
    }

}
