package ch.makery.address.view;


import db.ConexionMySql;
import ch.makery.address.model.Commercials;		// Provisional hasta que enlace con Product directamente ya que debe mostrase todo aqui

import ch.makery.address.MainApp;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;

import java.util.ResourceBundle;


import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProcurementController implements Initializable {

	@FXML
	private Button btComponents;
	@FXML
	private Button btCommercial;
	@FXML
	private Button btRawMaterials;
	@FXML
	private Button btStockManagement;
	@FXML
	private Button btForecastDemand;
	@FXML
	private Button btClose;


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
	@FXML 
	private TableColumn<Commercials, String> clmnTotalCost;
	
	
	//Labels
	@FXML
	private Label lblTotalResults;
	@FXML
	private Label lblTotalStock;
	
	//Tables
	@FXML 
	private TableView<Commercials> tblViewCommercials;
	
	//Collections
	private ObservableList<Commercials> listCommercials;
	
	/**********************************/
	
	
	
	private Stage primaryStage;			// Variable necesaria cada vez que abrimos nueva ventana desde la actual
	
	private ConexionMySql conn;
	
	
	
    /**
     * Initializes the controller class. This method initializes all methods which requires to do it without specific action.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	conn=new ConexionMySql();
    	showAllProducts();					// Esto deberia mostrarlo todo automaticamente
    }    
    		
	
	/**
	 * Acces to Components Menu
	 * @throws IOException
	 */
	public void ComponentMenu() throws IOException {
		
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Components.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Components");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		
	}

	
	/**
	 * Acces to Commercial Products Menu
	 * @throws IOException
	 */	
	public void CommercialsMenu() throws IOException {
		
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Commercials.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Commercials");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		
	}	
	
	
	
	
	/**
	 * Acces to Raw Materials Menu
	 * @throws IOException
	 */		
	public void RawMaterialsMenu() throws IOException {
		
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/RawMaterials.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Raw Materials");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		
	}	
	
	
	
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
     * Opens the stock statistics.
     * @throws IOException 
     */
	@FXML
    private void ForecastDemandMenu() throws IOException {
 	
    	
	        // Load the fxml file and create a new stage for the popup.

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/Forecast.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Forecast and Demand");
	        dialogStage.initModality(Modality.WINDOW_MODAL);        
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);    
	        dialogStage.show();
       
    }	
	
	
	
	
	
	
	/**
	 * Shows all products and results
	 * @throws IOException
	 */	
	public void showAllProducts() {


        try{

        	
        	java.sql.Connection connection = conn.conectar();
        	listCommercials = FXCollections.observableArrayList();
        	ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM stock");
        	
        	
            while(rs.next()){
                
            	listCommercials.add(new Commercials(
            			rs.getInt("idcomponents"),
            			rs.getString("descrip_articulo"), 
            			rs.getString("sfamilia"),
            			rs.getInt("xstock"), 
            			rs.getInt("minimo"), 
            			rs.getDouble("xprec_med")));
            	
            	//listCommercials.add(new Commercials(rs.getInt(2), rs.getString(3),rs.getString(4), rs.getInt(7), rs.getInt(8), rs.getDouble(9)));
            	

                tblViewCommercials.setItems(null);
                tblViewCommercials.setItems(listCommercials);
                
                // Shows total results
                int totalResults = listCommercials.size();
                lblTotalResults.setText("TOTAL CODES ON STOCK:                       "+totalResults);
                
                
                // Shows SUM total cost (Column Cost)
                double totalAmount = 0d;
                
                for(int i = 0; i<tblViewCommercials.getItems().size();i++) {
                
                	totalAmount = totalAmount + tblViewCommercials.getItems().get(i).getCost();
                	lblTotalStock.setText("TOTAL AMOUNT ON STOCK:         "+totalAmount+ "€");                            
                }
                

	        }
	    }catch(Exception ex){
	        JOptionPane.showMessageDialog(null,"Error searching commercial products: "+ex,
	                "Error",JOptionPane.ERROR_MESSAGE);
	    }
        // Configure Table (Enlazamos columnas con atributos)
        clmnCommercialCode.setCellValueFactory(new PropertyValueFactory<>("idCommercials"));
        clmnCommercialDescription.setCellValueFactory(new PropertyValueFactory<>("commercialCode"));
        clmnFamily.setCellValueFactory(new PropertyValueFactory<>("commercialName"));
        clmnStock.setCellValueFactory(new PropertyValueFactory<>("Stock"));
        clmnSecurityStock.setCellValueFactory(new PropertyValueFactory<>("SecurityStock"));
        clmnCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));

	}
	

	
	
	
	
    /**
     * Close Stock Management Window
     */
    public void closeWindow() {
        // get a handle to the stage
        Stage stage = (Stage) btClose.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    	   
	
	
	
}
