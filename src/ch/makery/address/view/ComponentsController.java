package ch.makery.address.view;		

import db.ConexionMySql;

import ch.makery.address.model.Components;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;				// Importamos para poder usar observable list
import javafx.collections.ObservableList;				// Importamos para poder usar observable list
import javafx.event.ActionEvent;
import javafx.fxml.FXML;								// Importamos para poder usar FXML
import javafx.fxml.Initializable;
import javafx.scene.control.Button;						// Importamos para poder usar botones
import javafx.scene.control.TableColumn;				// Importamos para poder usar
import javafx.scene.control.TableView;					// Importamos para poder usar
import javafx.scene.control.TextField;					// Importamos para poder usar
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Label;



/**
 * Controller class for components window
 * @author Ghost
 *
 */
public class ComponentsController implements Initializable {


	//Buttons
	@FXML
	private Button btClose;
	@FXML
	private Button btFind;
	
	//Columns
	@FXML 
	private TableColumn<Components, String> clmnComponentCode;
	@FXML 
	private TableColumn<Components, String> clmnComponentDescription;
	@FXML 
	private TableColumn<Components, String> clmnFamily;
	@FXML 
	private TableColumn<Components, String> clmnStock;
	@FXML 
	private TableColumn<Components, String> clmnSecurityStock;
	@FXML 
	private TableColumn<Components, String> clmnCost;

	//Text fields
	@FXML 
	private TextField txtCode;
	@FXML 
	private TextField txtDescription;
	@FXML
	private Label labResults;

	//Tables
	@FXML 
	private TableView<Components> tblViewComponents;
	
	//Collections
	private ObservableList<Components> listComponents;	
	
	private ConexionMySql conn;
	
	
	
    /**
     * Initializes the controller class. This method initializes all methods which requires to do it without specific action.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	conn=new ConexionMySql();
    }    
    	
	
    	
	
	/**
	 * This methods shows all components data
	 * @param event
	 */
	public void btFind_Click(ActionEvent event) {


		
        try{

        	
        	java.sql.Connection connection = conn.conectar();
        	listComponents = FXCollections.observableArrayList();
        	ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM stock WHERE sfamilia IN ('310  MATERIAS PRIMAS', '312  MATERIAS PRIMAS TB')");
        	
            while(rs.next()){
                
            	listComponents.add(new Components(
            			rs.getInt("idcomponents"),
            			rs.getString("descrip_articulo"), 
            			rs.getString("sfamilia"),
            			rs.getInt("xstock"), 
            			rs.getInt("minimo"), 
            			rs.getDouble("xprec_med")));
            	

                tblViewComponents.setItems(null);
                tblViewComponents.setItems(listComponents);
                
                // Shows total results in a label
                int results = listComponents.size();
                labResults.setText("TOTAL RESULTS: "+results);

	        }
	    }catch(Exception ex){
	        JOptionPane.showMessageDialog(null,"Error searching components: "+ex,
	                "Error",JOptionPane.ERROR_MESSAGE);
	    }
        // Configure Table (Enlazamos columnas con atributos)
        clmnComponentCode.setCellValueFactory(new PropertyValueFactory<>("idComponents"));
        clmnComponentDescription.setCellValueFactory(new PropertyValueFactory<>("ComponentCode"));
        clmnFamily.setCellValueFactory(new PropertyValueFactory<>("componentName"));
        clmnStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        clmnSecurityStock.setCellValueFactory(new PropertyValueFactory<>("SecurityStock"));
        clmnCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
        


	}
		

		    
	
	/**
	 * Close window
	 */
	public void btClose() {
		
        // get a handle to the stage
        Stage stage = (Stage) btClose.getScene().getWindow();
        // do what you have to do
        stage.close();
	}




	
	
	
	
	
}
