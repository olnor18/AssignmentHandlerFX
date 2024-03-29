/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l1c.shape_polymorphism;

/**
 *
 * @author Oliver
 */
public class Ellipse extends AbstractShape
{
    double r1;
    double r2;
    
    public Ellipse(double r1, double r2)
    {
        this.r1 = r1;
        this.r2 = r2;
    }
    
    @Override
    public double getArea()
    {
        return Math.PI*r1*r2;
    }

    @Override
    public double getCircumference()
    {
        return 2*Math.PI*Math.sqrt(0.5 *(r1+r2));
    }
    
}
