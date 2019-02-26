/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.abstracts;

/**
 *
 * @author Oliver
 */
public class Assignment
{
    public final String lesson;
    public final String typeOfExcersise;
    public final String description;
    public final String path;
    public final boolean isfx;

    public Assignment(String lesson, String typeOfExcersise, String description, String path, boolean isfx)
    {
        this.lesson = lesson;
        this.typeOfExcersise = typeOfExcersise;
        this.description = description;
        this.path = isfx ? "src/assignmenthandler/assignments/"+path+"/FXMLDocument.fxml" : path;
        this.isfx = isfx;
    }
    
    @Override
    public String toString()
    {
        return lesson + " | " + typeOfExcersise;
    }
}
