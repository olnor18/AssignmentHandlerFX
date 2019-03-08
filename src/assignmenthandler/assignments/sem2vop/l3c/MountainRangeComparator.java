/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l3c;

import java.util.Comparator;

/**
 *
 * @author Oliver
 */
public class MountainRangeComparator implements Comparator<Mountain>{

    @Override
    public int compare(Mountain t, Mountain t1) {
        return t.getRange().equals(t1.getRange()) ? t.compareTo(t1) : t.getRange().compareTo(t1.getRange());
    }
    
}
