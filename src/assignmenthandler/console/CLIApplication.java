/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.console;

import assignmenthandler.assignments.test.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Oliver
 */
public class CLIApplication extends ConsoleApplication
{
    
    public Stage stage = new Stage();
    final ConsoleView console = new ConsoleView();;
    
    public CLIApplication(String path)
    {
        try
        {
            final Scene scene = new Scene(console);
            final URL styleSheetUrl = getStyleSheetUrl();
            if (styleSheetUrl != null)
            {
                scene.getStylesheets().add(styleSheetUrl.toString());
            }
            stage.setTitle("Console");
            stage.setScene(scene);
            stage.setOnCloseRequest(e -> stage.close());
            stage.show();
            
            System.setOut(console.getOut());
            System.setIn(console.getIn());
            System.setErr(console.getOut());
            final Thread thread = new Thread(() ->
            {
                Throwable throwable = null;
                try
                {
                    invokeMain(null, path);
                } catch (Throwable e)
                {
                    throwable = e;
                }
                final int result = throwable == null ? 0 : 1;
                if (this.pauseBeforeExit)
                {
                    System.out.print("Press enter key to exit.");
                    try
                    {
                        new BufferedReader(new InputStreamReader(System.in)).readLine();
                    } catch (IOException e)
                    {
                        // ignore
                    }
                }
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        stage.close();
                    }
                });
                
            });
            thread.setName("Console Application Main Thread");
            thread.start();
            
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    
    protected void invokeMain(final String[] args, String path)
    {
        try
        {
            Class<?> c = Class.forName(path);
            Method method = c.getDeclaredMethod("main", String[].class);
            String[] params = null;
            method.invoke(null, (Object) params);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException, InterruptedException
    {
        launch(args);
    }
    
    @Override
    protected void invokeMain(String[] args)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
