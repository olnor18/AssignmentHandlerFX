/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem1oop.l8;

import java.util.Date;

/**
 *
 * @author Oliver
 */
public class Fan
{
     private final int SLOW = 1;
     private final int MEDIUM = 2;
     private final int FAST = 3;
     
     private int speed = SLOW;
     private boolean on = false;
     private double radius = 5.0;
     private String color = "Blue";
     
     public Fan()
     {
         
     }
     
     public Fan(boolean on, int speed, double radius, String color)
     {
         this.on = on;
         if (speed == SLOW || speed == MEDIUM || speed == FAST)
         {
            this.speed = speed;
         }
         this.radius = radius;
         this.color = color;
         
     }
     
     public int getSpeed()
     {
         return this.speed;
     }
     
     public boolean getPower()
     {
         return this.on;
     }
     
     public double getRadius()
     {
         return this.radius;
     }
     
     public String getColor()
     {
         return this.color;
     }
     
     public void setSpeed(int speed)
     {
         if (speed == SLOW || speed == MEDIUM || speed == FAST)
         {
            this.speed = speed;
         }
     }
     
     public void setPower(boolean on)
     {
         this.on = on;
     }
     
     public void setRadius(double radius)
     {
         this.radius = radius;
     }
     
     public void setColor(String color)
     {
         this.color = color;
     }
     
     public String toString()
     {
        if (this.on)
        {
            return "The fan is on with a speed set to " + speed + ". It has a radius of " + radius + " and is " + color;
        }
        else
        {
            return "The fan is off. It has a radius of " + radius + " and is " + color;
        }
     }
     
     public String toString(Date d)
     {
        if (this.on)
        {
            return d.toString() + " The fan is on with a speed set to " + speed + ". It has a radius of " + radius + " and is " + color;
        }
        else
        {
            return d.toString() + " The fan is off. It has a radius of " + radius + " and is " + color;
        }
     }
}
