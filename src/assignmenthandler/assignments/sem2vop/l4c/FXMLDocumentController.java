/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l4c;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import assignmenthandler.assignments.sem2vop.l4c.opg2_numberplates.NumberPlates;
import assignmenthandler.assignments.sem2vop.l4c.opg3_playingcards.DeckOfCards;

/**
 *
 * @author Oliver
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label output;
    @FXML
    private TextField input;

    NumberPlates numberPlates;

    @FXML
    private TextArea cards;
    @FXML
    private RadioButton fifty;
    @FXML
    private RadioButton hundred;
    @FXML
    private RadioButton twoHundredAndFifty;

    ToggleGroup toggleGroup;
    DeckOfCards deck;

    @FXML
    private void checkNP()
    {
        output.setText(numberPlates.validate(input.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        numberPlates = new NumberPlates();
        deck = new DeckOfCards();
        cards.setText(deck.toString());
        toggleGroup = new ToggleGroup();
        fifty.setToggleGroup(toggleGroup);
        fifty.setUserData(50);
        hundred.setToggleGroup(toggleGroup);
        hundred.setUserData(100);
        twoHundredAndFifty.setToggleGroup(toggleGroup);
        twoHundredAndFifty.setUserData(250);
    }

    @FXML
    public void shuffle()
    {
        deck.shuffle((int)toggleGroup.getSelectedToggle().getUserData());
        cards.setText(deck.toString());
    }

}
