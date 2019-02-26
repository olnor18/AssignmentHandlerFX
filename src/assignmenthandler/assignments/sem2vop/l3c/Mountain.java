package assignmenthandler.assignments.sem2vop.l3c;

import java.util.Arrays;

/**
 *
 * @author erso Udleveret kode skelet med main()-metode til opgave 4, VOP
 * eksamen 10 juni 2016
 */
public class Mountain implements Comparable<Mountain> {

    private final String name;
    private final int height;
    private final int prominance;
    private final String latityde;
    private final String longitude;
    private final String range;

    public Mountain(String name, String height, String prominance, String latityde, String longitude, String range) {
        this.name = name;
        this.height = new Integer(height);
        this.prominance = new Integer(prominance);
        this.latityde = latityde;
        this.longitude = longitude;
        this.range = range;
    }

    @Override
    public String toString() {
        return this.name + " h=" + this.height + ", pro=" + this.prominance + ", lat=" + this.latityde + ", lon=" + this.longitude + ", ran=" + this.range + "\n";
    }

    @Override
    public int compareTo(Mountain o) {
        return this.prominance != o.prominance ? this.prominance - o.prominance : this.height - o.height;
    }

    public String getRange() {
        return range;
    }
}
