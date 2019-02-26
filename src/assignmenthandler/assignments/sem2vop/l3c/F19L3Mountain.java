/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l3c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Oliver
 */
public class F19L3Mountain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){

    // Til test af Mountain-klassen

        //Opg a Test af constructor og toString()
        // NB: \u00B0 er unicode for grade-tegnet
        Mountain m = new Mountain("Mont Ventoux", "1909", "1148", "44\u00B010'26\"", "05\u00B016'42\"", "Alps");
        System.out.println(m);

        // Opg b Test af compareTo()
        Mountain[] testArray = new Mountain[4];
        testArray[0] = new Mountain("Pic du Midi d'Ossau", "2886", "1092", "42\u00B048'22\"", "-00\u00B025'05\"", "Pyrenees");
        testArray[1] = new Mountain("Pic de Bure", "2709", "1268", "44\u00B037'38\"", "05\u00B056'07\"", "Alps");
        testArray[2] = new Mountain("Mont Chaberton", "3131", "1281", "44\u00B057'53\"", "06\u00B045'06\"", "Alps");
        testArray[3] = new Mountain("Pica d'Estats", "3143", "1281", "42\u00B042'43\"", "00\u00B057'23\"", "Pyrenees");

        System.out.println("Usorteret: ");
        System.out.println(Arrays.toString(testArray));

        System.out.println("Sorteret: ");
        Arrays.sort(testArray);
        System.out.println(Arrays.toString(testArray));
        
        
        MountainSet mountainSet = new MountainSet();
        File file = new File("src/assignmenthandler/assignments/sem2vop/l3c/FranskeBjerge.csv");
        
        try(Scanner scanner = new Scanner(file))
        {
            while(scanner.hasNextLine())
            {
                String mountain = scanner.nextLine();
                String[] mountainArguments = mountain.split(";");
                mountainSet.getSet().add(new Mountain(mountainArguments[0], mountainArguments[1], mountainArguments[2], mountainArguments[3], mountainArguments[4], mountainArguments[5]));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File now found");
        }
        System.out.println("CSV: ");
        System.out.println(mountainSet.getSet());
        
        System.out.println("CSV Sorted by Range: ");
        System.out.println(mountainSet.sortByRange(new MountainRangeComparator()));

    }
}

