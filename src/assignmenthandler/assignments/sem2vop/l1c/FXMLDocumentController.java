/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l1c;

import assignmenthandler.assignments.sem2vop.l1c.ancient_encryption.CeasarCipher;
import assignmenthandler.assignments.sem2vop.l1c.ancient_encryption.CipherInterface;
import assignmenthandler.assignments.sem2vop.l1c.ancient_encryption.AtbashCipher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import assignmenthandler.assignments.sem2vop.l1c.shape_polymorphism.ShapeFacade;

/**
 *
 * @author Oliver
 */
public class FXMLDocumentController implements Initializable {
    
    CipherInterface cipher;
    ToggleGroup shapeGroup  = new ToggleGroup();
    
    
    //Ex One
    @FXML
    private TextField input;
    @FXML
    private RadioButton atbash;
    @FXML
    private RadioButton ceasar;
    @FXML
    private Spinner<Integer> rotation;
    @FXML
    private RadioButton encrypt;
    @FXML
    private RadioButton decrypt;
    @FXML
    private TextArea output;
    @FXML
    private Text console;
    
    @FXML
    private RadioButton ellipse;
    @FXML
    private RadioButton rectangle;
    @FXML
    private RadioButton circle;
    @FXML
    private RadioButton square;
    @FXML
    private TextField p1;
    @FXML
    private TextField p2;
    @FXML
    private TextArea output2;
    @FXML
    private Text console2;
    
    
    //Ex one
    @FXML
    private void exOneButtonAction(ActionEvent event) {
        console.setText("");
        if(encrypt.isSelected() && !decrypt.isSelected())
        {
            if (atbash.isSelected() && !ceasar.isSelected())
            {
                cipher = new AtbashCipher();
                output.setText(cipher.encrypt(input.getText()));
            }
            else if (ceasar.isSelected() && !atbash.isSelected())
            {
                cipher = new CeasarCipher(rotation.getValue());
                try {
                    output.setText(cipher.encrypt(input.getText()));
                }
                catch(IllegalArgumentException e)
                {
                    console.setText("ERROR: Invalid rotation");
                }
            }
            else
            {
                console.setText("ERROR: Select a cipher");
            }
            
        }
        else if(decrypt.isSelected() && !encrypt.isSelected())
        {
            if (atbash.isSelected() && !ceasar.isSelected())
            {
                cipher = new AtbashCipher();
                output.setText(cipher.decrypt(input.getText()));
            }
            else if (ceasar.isSelected() && !atbash.isSelected())
            {
                cipher = new CeasarCipher(rotation.getValue());
                try {
                    output.setText(cipher.decrypt(input.getText()));
                }
                catch(IllegalArgumentException e)
                {
                    console.setText("ERROR: Invalid rotation");
                }
            }
            else
            {
                console.setText("ERROR: Select exactly one cipher");
            }
            
        }
        else 
        {
            console.setText("ERROR: Select exactly one mode");
        }
    }
    
    @FXML
    private void exTwoButtonAction(ActionEvent event)
    {
        console2.setText("");
        ShapeFacade.SHAPES shape = (shapeGroup.getSelectedToggle() != null) ? (ShapeFacade.SHAPES)shapeGroup.getSelectedToggle().getUserData() : null;
        String returnString;
        if (p1.getText().contains(",") || p2.getText().contains(","))
            {
                returnString = "ERROR: Comma is not a valid decimalpoint. Use dot instead";
            }
        else if (shapeGroup.getSelectedToggle() == null)
        {
            returnString = "ERROR: Select a shape";
        }
        else if (shapeGroup.getSelectedToggle().equals(ellipse) || shapeGroup.getSelectedToggle().equals(rectangle))
        {
            if (!p1.getText().isEmpty() && !p2.getText().isEmpty())
            {
                try
                {
                    double[] p = {Double.parseDouble(p1.getText()), Double.parseDouble(p2.getText())};
                    returnString = ShapeFacade.getInstance().getShapeInfo(shape, p);
                } catch (NumberFormatException e)
                {
                    returnString = "ERROR: Invalid number";
                }
            }
            else
            {
                returnString = "ERROR: Parameter can't be null";
            }
        }
        else if (shapeGroup.getSelectedToggle().equals(circle) || shapeGroup.getSelectedToggle().equals(square))
        {
            if (!p1.getText().isEmpty()) 
            {
               double[] p = {Double.parseDouble(p1.getText())};
               returnString = ShapeFacade.getInstance().getShapeInfo(shape, p); 
            }
            else
            {
                returnString = "ERROR: Parameter can't be null";
            }
        }
        else
        {
            returnString = "ERROR: Generic error message";
        }
        
        
        if (returnString.startsWith("ERROR:"))
        {
            console2.setText(returnString);
        }
        else
        {
            output2.setText(returnString);
        }
    }
    
    @FXML
    private void radioButtonClick(ActionEvent event)
    {
        switch ((ShapeFacade.SHAPES)shapeGroup.getSelectedToggle().getUserData())
        {
            case ELLIPSE:
            case RECTANGLE:
                p2.setDisable(false);
                p2.setVisible(true);
                break;
            case CIRCLE:
            case SQUARE:
                p2.setDisable(true);
                p2.setVisible(false);
                break;    
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //rotation.getValueFactory().setValue(13);
        rotation.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, CipherInterface.ALPHABETH.length - 1,CipherInterface.ALPHABETH.length / 2));
        ToggleGroup cipherGroup = new ToggleGroup();
        atbash.setToggleGroup(cipherGroup);
        ceasar.setToggleGroup(cipherGroup);

        ToggleGroup modeGroup = new ToggleGroup();
        encrypt.setToggleGroup(modeGroup);
        decrypt.setToggleGroup(modeGroup);
        
        ellipse.setToggleGroup(shapeGroup);
        rectangle.setToggleGroup(shapeGroup);
        circle.setToggleGroup(shapeGroup);
        square.setToggleGroup(shapeGroup);
        
        ellipse.setUserData(ShapeFacade.SHAPES.ELLIPSE);
        rectangle.setUserData(ShapeFacade.SHAPES.RECTANGLE);
        circle.setUserData(ShapeFacade.SHAPES.CIRCLE);
        square.setUserData(ShapeFacade.SHAPES.SQUARE);
    }    
    
}
