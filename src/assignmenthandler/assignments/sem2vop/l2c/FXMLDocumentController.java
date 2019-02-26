/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l2c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.IndexRange;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Oliver
 */
public class FXMLDocumentController implements Initializable {
    
    private FileChooser fileChooser;
    private File currentFile;
    
    @FXML
    private TextField search;
    @FXML
    private TextField replace;
    @FXML
    private TextArea input;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("."));
    }
    
    @FXML
    public void replaceNext()
    {
        if (input.getSelectedText().isEmpty())
        {
            input.setText(input.getText().replaceFirst(search.getText(), replace.getText()));
        }
        else
        {
            String subString = input.getSelectedText().replaceFirst(search.getText(), replace.getText());
            IndexRange ir = input.getSelection();
            input.setText(input.getText(0, input.getSelection().getStart()) + subString + input.getText(input.getSelection().getEnd(), input.getLength()));
            input.selectRange(ir.getStart(), (ir.getEnd() + (replace.getText().length() - search.getText().length())));
        }
    }
    
    @FXML
    public void replaceAll()
    {
        if (input.getSelectedText().isEmpty())
        {
            input.setText(input.getText().replaceAll(search.getText(), replace.getText()));
        }
        else
        {
            String subString = input.getSelectedText().replaceAll(search.getText(), replace.getText());
            input.setText(input.getText(0, input.getSelection().getStart()) + subString + input.getText(input.getSelection().getEnd(), input.getLength()));
        }
    }
    
    @FXML
    public void swap()
    {
        String search = this.search.getText();
        String replace = this.replace.getText();
        
        this.replace.setText(search);
        this.search.setText(replace);
    }
    
    @FXML
    public void open()
    {
        fileChooser.setInitialDirectory(new File("."));
        File selectedFile = fileChooser.showOpenDialog(search.getScene().getWindow());
        currentFile = selectedFile;
        if (selectedFile != null) {
            input.setText("");
            try (Scanner scanner = new Scanner(selectedFile)) {
                while (scanner.hasNextLine()) {
                    input.appendText(scanner.nextLine() + (scanner.hasNextLine() ? "\n" : ""));
                }
            } catch (FileNotFoundException ex) {
                input.setText("Can't open file!");
            }
        }
    }
    
    @FXML
    public void save()
    {
        if (currentFile == null)
        {
            saveAs();
        }
        else
        {
            try (PrintWriter printWriter = new PrintWriter(currentFile)) {
                //Stream.of(input.getText().split("\n")).forEach(line -> printWriter.println(line));
                /*for (String line : input.getText().split("\n"))
                {
                    printWriter.println(line);
                }*/
                printWriter.print(input.getText());
            } catch (FileNotFoundException ex) {
                input.setText("File not found!");
            }
        }
    }
    
    @FXML
    public void saveAs()
    {
        if (currentFile != null)
        {
            fileChooser.setInitialDirectory(currentFile.getParentFile());
        }
        File selectedFile = fileChooser.showSaveDialog(search.getScene().getWindow());
        
        if (selectedFile != null) {
            try {
                if (!selectedFile.exists()) {
                    selectedFile.createNewFile();
                }
            } catch (IOException ex) {
                System.out.println("Couldn't create file!");
                return;
            }
            try (PrintWriter printWriter = new PrintWriter(selectedFile)) {
                //Stream.of(input.getText().split("\n")).forEach(line -> printWriter.println(line));
                /*for (String line : input.getText().split("\n"))
                {
                    printWriter.println(line);
                }*/
                printWriter.print(input.getText());
            } catch (FileNotFoundException ex) {
                input.setText("File not found!");
            }
        }
    }
    
    @FXML
    public void quit()
    {
        Stage stage = (Stage) search.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void about()
    {
        
    }
}