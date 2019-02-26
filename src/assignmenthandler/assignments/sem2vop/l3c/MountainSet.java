/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l3c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Oliver
 */
public class MountainSet {

    private final Set<Mountain> set;

    public MountainSet() {
        set = new TreeSet<>();
    }

    public Set<Mountain> getSet() {
        return set;
    }
    
    public Set<Mountain> sortByRange(Comparator comp)
    {
        Set<Mountain> output = new TreeSet<>(comp);
        output.addAll(set);
        return output;
    }

}
