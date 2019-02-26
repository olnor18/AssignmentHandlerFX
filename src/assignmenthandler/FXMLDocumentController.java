/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler;

import assignmenthandler.assignments.abstracts.Assignment;
import assignmenthandler.console.CLIApplication;
import com.sun.javafx.scene.control.skin.LabeledText;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Oliver
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private ListView<Assignment> list;
    @FXML
    private TextArea description;
    
    
    @FXML
    private MenuItem oopSem1;
    @FXML
    private MenuItem vopSem2;
    

    private static TextArea cOutput;
    CLIApplication console;

    private Assignment[] oopSem1Assignments =
    {
        new Assignment("Lesson 2", "Preparation", "TBW", "assignmenthandler.assignments.sem1oop.l2", false),
        new Assignment("Lesson 3", "Preparation", "TBW", "assignmenthandler.assignments.sem1oop.l3", false),
        new Assignment("Lesson 4", "Preparation", "TBW", "assignmenthandler.assignments.sem1oop.l4", false),
        new Assignment("Lesson 5", "Preparation", "TBW", "assignmenthandler.assignments.sem1oop.l5", false),
        new Assignment("Lesson 6", "Preparation", "TBW", "assignmenthandler.assignments.sem1oop.l6.Module006", false),
        new Assignment("Lesson 8", "Preparation", "TBW", "assignmenthandler.assignments.sem1oop.l8.Modul008", false),
    };
    
    private Assignment[] vopSem2Assignments =
    {
        //new Assignment("Test", "CLI", "TBW 3", "assignmenthandler.assignments.test.test", false),
        new Assignment("Lesson 1", "Class", "TBW", "sem2vop/l1c", true),
        new Assignment("Lesson 2", "Preparation", "TBW", "assignmenthandler.assignments.sem2vop.l2p.CamelWriter", false),
        new Assignment("Lesson 2", "Class", "TBW", "sem2vop/l2c", true),
        new Assignment("Lesson 3", "Class", "TBW", "assignmenthandler.assignments.sem2vop.l3c.F19L3Mountain", false),

    };

    @FXML
    private void launch(ActionEvent event) throws Exception
    {
        if (list.getSelectionModel().getSelectedItem().isfx)
        {
            Parent root = new FXMLLoader(new File(list.getSelectionModel().getSelectedItem().path).toURL()).load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(list.getSelectionModel().getSelectedItem().toString());
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setScene(scene);
            //stage.setHeight(stage.getMaxHeight());
            //stage.setWidth(stage.getMaxWidth());
            stage.show();
        } else
        {

            if (console == null)
            {
                /*
                //Launch Console
                FXMLLoader loader = new FXMLLoader(new File("src/assignmenthandler/console.fxml").toURL());
                Parent root = (Parent) loader.load();
                Scene scene = new Scene(root);
                stageConsole = new Stage();
                stageConsole.setTitle("Console");
                stageConsole.setResizable(false);
                stageConsole.setScene(scene);
                stageConsole.setOnHiding(we -> stageConsole = null);
                stageConsole.show();
                 */
                console = new CLIApplication(list.getSelectionModel().getSelectedItem().path);
            } else if (console.stage != null && console.stage.isShowing())
            {
                console.stage.toFront();
            } else
            {
                console = new CLIApplication(list.getSelectionModel().getSelectedItem().path);
            }

            /*
            Class<?> c = Class.forName(list.getSelectionModel().getSelectedItem().path);
            Method method = c.getDeclaredMethod("main", String[].class);
            Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    Platform.runLater(() ->
                    {
                        try
                        {
                            //Reflection

                            String[] params = null;
                            method.invoke(null, (Object) params);

                        } catch (Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    });
                }
            });
            t.start();*/
        }

    }

    @FXML
    private void onMouseClicked(MouseEvent event) throws Exception
    {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2)
        {
            launch(new ActionEvent());
        }
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1)
        {
            description.setText(list.getSelectionModel().getSelectedItem().description);
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

        for (Assignment a : vopSem2Assignments)
        {
            list.getItems().add(a);
        }
        /*
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Assignment>()
        {
            @Override
            public void changed(ObservableValue<? extends Assignment> observable, Assignment oldValue, Assignment newValue)
            {
                description.setText(newValue.description);
            }
        });
        */
        oopSem1.setOnAction(e -> changeClass(oopSem1Assignments));
        vopSem2.setOnAction(e -> changeClass(vopSem2Assignments));
        
    }
    
    @FXML
    public void changeClass( Assignment[] assignments)
    {
        list.getItems().clear();
        for (Assignment a : assignments)
        {
            list.getItems().add(a);
        }
        
    }

}
