package ch.makery.address.view;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.makery.address.model.Commercials;
import db.ConexionMySql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RawMaterialsController implements Initializable{

	
	@FXML
	private Button btClose;
	
	@FXML
	private Button btFind;
	
	//Text fields
	@FXML 
	private TextField txtCode;
	@FXML 
	private TextField txtDescription;

	
	
	
	
	
	//Columns
	@FXML 
	private TableColumn<Commercials, String> clmnCommercialCode;
	@FXML 
	private TableColumn<Commercials, String> clmnCommercialDescription;
	@FXML 
	private TableColumn<Commercials, String> clmnFamily;
	@FXML 
	private TableColumn<Commercials, String> clmnStock;
	@FXML 
	private TableColumn<Commercials, String> clmnSecurityStock;
	@FXML 
	private TableColumn<Commercials, String> clmnCost;
	
	
	
	
	
	//Tables
	@FXML 
	private TableView<Commercials> tblViewCommercials;
	
	//Collections
	private ObservableList<Commercials> listRawMaterials;	
	private ConexionMySql conn;
	
	
	
    /**
     * Initializes the controller class. This method initializes all methods which requires to do it without specific action.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	conn=new ConexionMySql();
    }    
    		
	
	/**
	 * This methods shows all Commercials data
	 * @param event
	 */
	public void btFind_Click(ActionEvent event) {


		
        try{

        	
        	java.sql.Connection connection = conn.conectar();
        	listRawMaterials = FXCollections.observableArrayList();
        	ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM stock WHERE sfamilia = '300  MATERAL COMERCIAL'");
        	
            while(rs.next()){
                
            	listRawMaterials.add(new Commercials(
            			rs.getInt("idcomponents"),
            			rs.getString("descrip_articulo"), 
            			rs.getString("sfamilia"),
            			rs.getInt("xstock"), 
            			rs.getInt("minimo"), 
            			rs.getDouble("xprec_med")));
            	
            	//listCommercials.add(new Commercials(rs.getInt(2), rs.getString(3),rs.getString(4), rs.getInt(7), rs.getInt(8), rs.getDouble(9)));
            	

                tblViewCommercials.setItems(null);
                tblViewCommercials.setItems(listRawMaterials);

	        }
	    }catch(Exception ex){
	        JOptionPane.showMessageDialog(null,"Error searching commercial products: "+ex,
	                "Error",JOptionPane.ERROR_MESSAGE);
	    }
        // Configure Table (Enlazamos columnas con atributos)
        clmnCommercialCode.setCellValueFactory(new PropertyValueFactory<>("idCommercials"));
        clmnCommercialDescription.setCellValueFactory(new PropertyValueFactory<>("commercialName"));
        clmnFamily.setCellValueFactory(new PropertyValueFactory<>("commercialCode"));
        clmnStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        clmnSecurityStock.setCellValueFactory(new PropertyValueFactory<>("SecurityStock"));
        clmnCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));

	}
	
	public void btClose() {
		
        // get a handle to the stage
        Stage stage = (Stage) btClose.getScene().getWindow();
        // do what you have to do
        stage.close();
	}
	
}
