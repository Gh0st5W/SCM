package ch.makery.address;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
   
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SUPPLY CHAIN MANAGMENT");
        //this.primaryStage.setFullScreen(true);
        primaryStage.setMaximized(true);

        initRootLayout();
        
        showMainWindow();	
    }

    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        
   	
    	try {
           
        	// Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    
    
    
    /**
     * Shows the main Window over the root layout.
     */
    public void showMainWindow() {
        try {
            // Load main window.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MainWindow.fxml"));
            AnchorPane mainWindow = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainWindow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    

    
    
    
    
/*********** MAIN ************/    
    
/**
 * LAUNCH SCM APPLICATION    
 * @param args
 */
    
    public static void main(String[] args) {
    		
    	launch(args);
        
    }
}