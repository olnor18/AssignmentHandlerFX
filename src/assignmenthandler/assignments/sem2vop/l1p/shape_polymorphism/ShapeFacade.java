/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l1p.shape_polymorphism;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stuff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        AbstractShape shapeInstance;
        
        switch(shape)
        {
            case CIRCLE:
                shapeInstance = parametre.length == 1 ? new Circle(parametre[0]) : null;
                break;
                
            case ELLIPSE:
                shapeInstance = parametre.length == 2 ? new Ellipse(parametre[0], parametre[1]) : null;
                break;
                
            case RECTANGLE:
                shapeInstance = parametre.length == 2 ? new Rectangle(parametre[0], parametre[1]) : null;
                break;
            
            case SQUARE:
                shapeInstance = parametre.length == 1 ? new Square(parametre[0]) : null;
                break;    
            
            default:
                return "ERROR: Invalid shape";
        }
        
        if (shapeInstance == null)
        {
            return "ERROR: Invalid parameter length";
        }
        
        return shapeInstance.toString();
    }

}
