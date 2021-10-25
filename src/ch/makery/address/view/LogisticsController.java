package ch.makery.address.view;


import java.io.IOException;

import javafx.scene.control.Button;		//Muy importante importar este, el fix te hace un #import java.awt.Button, que genera errores;
import ch.makery.address.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LogisticsController {

	
	private Stage primaryStage; 	// Al crear un stage debo declarar esta variable local
	
	@FXML
	private Button btTransport;
	@FXML
	private Button btWarehouse;
	@FXML
	private Button btStockManagement;
	@FXML
	private Button btBack;
	
	
	
	
	
    /**
     * Opens the stock statistics.
     * @throws IOException 
     */
	@FXML
    private void StockStatistics() throws IOException {
 	
    	
	        // Load the fxml file and create a new stage for the popup.

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/StockManagement.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Stock Management");
	        dialogStage.initModality(Modality.WINDOW_MODAL);        
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);    
	        dialogStage.show();
       
    }
	
	
    /**
     * Go back to previous Window
     */
    public void backWindow() {
        // get a handle to the stage
        Stage stage = (Stage) btBack.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
	
}
