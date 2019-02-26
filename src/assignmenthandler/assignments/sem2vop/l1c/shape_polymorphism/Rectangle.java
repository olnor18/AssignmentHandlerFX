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
public class Rectangle extends AbstractShape
{

    double l1;
    double l2;
    
    public Rectangle(double l1, double l2)
    {
        this.l1 = l1;
        this.l2 = l2;
    }
    
    @Override
    public double getArea()
    {
        return l1*l2;
    }

    @Override
    public double getCircumference()
    {
        return 2*(l1+l2);
    }
    
}
