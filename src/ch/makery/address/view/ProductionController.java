package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProductionController {

	@FXML
	private Button btClose;
	
	

    /**
     * Go back to previous Window
     */
    public void backWindow() {
        // get a handle to the stage
        Stage stage = (Stage) btClose.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
	

}
