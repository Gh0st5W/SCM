package ch.makery.address.view;

//import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.stage.FileChooser;
//import ch.makery.address.MainApp;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Carlos Vioque
 */
public class RootLayoutController {

    // Reference to the main application
    //private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    /*
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }*/



    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("SCM - Supply Chain Managment");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Carlos Vioque");

    	alert.showAndWait();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }

}