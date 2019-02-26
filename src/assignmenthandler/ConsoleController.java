/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler;

import java.io.PrintStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.LinkedBlockingQueue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class ConsoleController implements Initializable
{
    
    @FXML
    private TextArea output;
    @FXML
    private TextField input;
    
    public String inputString = "";
    
    public static ConsoleController controller;
    
    public ConsoleController()
    {
        controller = this;
    }
    
    @FXML
    public void inputEnter()
    {
        //StringBufferInputStream s = new StringBufferInputStream(input.getText());
        //StringBufferInputStream s = new StringBufferInputStream("testWords");
        //System.setIn(s);
        inputString = input.getText();
        input.clear();
        
    }
    
    public static ConsoleController getController()
    {
        return controller;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //Bind out to console
        PrintStream myStream = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                output.setText(output.getText()+x+"\n"); // ConsoleController.output.getText() + "\n"+ 
                //super.println("Test: "+x);
                //consoleController.getOutput().setText(x);
            }
            
            @Override
            public void print(String x) {
                output.setText(output.getText()+x); // ConsoleController.output.getText() + "\n"+ 
                //super.println("Test: "+x);
                //consoleController.getOutput().setText(x);
            }
            
            @Override
            public PrintStream printf(String x, Object ... args) {
                //output.setText(output.getText()+x); // ConsoleController.output.getText() + "\n"+ 
                //super.println("Test: "+x);
                //consoleController.getOutput().setText(x);
                return format(x, args);
            }
        };
        System.setOut(myStream);
       
    }

    


    
    
}
