/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l2p;

import java.util.Scanner;


/**
 *
 * @author erso
 */
public class CamelWriter {

    private String fName;
 

    public CamelWriter(String fName) {
       this.fName = fName;
    }

    public void readLines() {
        try (Scanner scanner = new Scanner(CamelWriter.class.getResourceAsStream(fName))) {
             while (scanner.hasNextLine()) {
                convert2camel(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        new CamelWriter("DryLips.txt").readLines();
        System.out.println("\n\n|--------------------------------|\n\n");
        new CamelWriter("MaryAnn.txt").readLines();
        System.out.println("\n\n|--------------------------------|\n\n");
        new CamelWriter("OhLand.txt").readLines();
    }

}
