/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l2p;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author erso
 */
public class CamelWriter {

    private final File inFile;
 

    public CamelWriter(String fName) {
        inFile = new File(fName);
        System.out.println(inFile.getAbsolutePath());
    }

    public void readLines() {
        try (Scanner scanner = new Scanner(inFile)) {
             System.out.println(scanner.hasNextLine());
             while (scanner.hasNextLine()) {
                convert2camel(scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: File could not be found");
        }
    }

    private void convert2camel(String line) {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            words[i] = (i == 0 ? words[i].toLowerCase() : words[i].substring(0, 1).toUpperCase()) + (words[i].length() > 1 && i > 0 ? words[i].substring(1).toLowerCase() : "");
        }
        System.out.println(String.join("", words));
    }

    public static void main(String[] args) {
        new CamelWriter("src/assignmenthandler/assignments/sem2vop/l2p/DryLips.txt").readLines();
        System.out.println("\n\n|--------------------------------|\n\n");
        new CamelWriter("src/assignmenthandler/assignments/sem2vop/l2p/MaryAnn.txt").readLines();
        System.out.println("\n\n|--------------------------------|\n\n");
        new CamelWriter("src/assignmenthandler/assignments/sem2vop/l2p/OhLand.txt").readLines();
    }

}
