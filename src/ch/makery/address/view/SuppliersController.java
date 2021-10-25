package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SuppliersController {

	@FXML
	private Button btClose;
	
	
	
	public void btClose() {
		
        // get a handle to the stage
        Stage stage = (Stage) btClose.getScene().getWindow();
        // do what you have to do
        stage.close();
	}
	
	
}
