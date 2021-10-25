package ch.makery.address.view;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import ch.makery.address.model.Forecast;
import ch.makery.address.model.Stock;
import db.ConexionMySql;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ForecastController implements Initializable{

	// Buttons
	@FXML
	private Button btClose;
	
	//Labels
	@FXML
	private Label lblTotalResults;
	
	//Columns
	@FXML 
	private TableColumn<Forecast, String> clmnCodeF;
	@FXML 
	private TableColumn<Forecast, String> clmnDescriptionF;
	@FXML 
	private TableColumn<Forecast, Double> clmnJanF;
	@FXML 
	private TableColumn<Forecast, Double> clmnFebF;
	@FXML 
	private TableColumn<Forecast, Double> clmnMarF;
	@FXML 
	private TableColumn<Forecast, Double> clmnAprF;	
	@FXML 
	private TableColumn<Forecast, Double> clmnMayF;
	@FXML 
	private TableColumn<Forecast, Double> clmnJunF;
	@FXML 
	private TableColumn<Forecast, Double> clmnJulF;
	@FXML	
	private TableColumn<Forecast, Double> clmnAugF;
	@FXML 
	private TableColumn<Forecast, Double> clmnSepF;
	@FXML 
	private TableColumn<Forecast, Double> clmnOctF;
	@FXML 
	private TableColumn<Forecast, Double> clmnNovF;
	@FXML 
	private TableColumn<Forecast, Double> clmnDecF;
	@FXML 
	private TableColumn<Forecast, Double> clmnTotalF;
	@FXML 
	private TableColumn<Forecast, Double> clmnDesvStandardF;
	
	//Tables
	@FXML 
	private TableView<Forecast> tblViewForecast;

	//Collections
	private ObservableList<Forecast> listForecast;
	
	//Other
	private ConexionMySql conn;
	
	
    /**
     * Initializes the controller class. This method initializes all methods which requires to do it without specific action.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	conn=new ConexionMySql();
    	showAllForecastData();
    	//showAllDemandData();
    }    
    		
    
    
    
    
    
    
    public void showAllForecastData() {
    	
    	try {
    		
        	java.sql.Connection connection = conn.conectar();
        	listForecast = FXCollections.observableArrayList();
        	ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM forecast_2019");
    		
        	
        	while(rs.next()) {
        		
        		listForecast.add(new Forecast(
        				rs.getString("itemCode"),
        				rs.getString("description"),
            			rs.getDouble("january"),
            			rs.getDouble("february"),
            			rs.getDouble("march"),
            			rs.getDouble("april"),
            			rs.getDouble("may"),
            			rs.getDouble("juny"),
            			rs.getDouble("july"),
            			rs.getDouble("august"),
            			rs.getDouble("september"),
            			rs.getDouble("october"),
            			rs.getDouble("november"),
            			rs.getDouble("december"),
            			rs.getDouble("total"),
            			rs.getDouble("desvStandard")
        				));
        	}

    	}
    	catch(Exception ex){
	        JOptionPane.showMessageDialog(null,"Error loading stock: "+ex,
	                "Error",JOptionPane.ERROR_MESSAGE);
	    }
    		
        // Configure Table (Enlazamos columnas con atributos)
    	clmnCodeF.setCellValueFactory(new PropertyValueFactory<>("code"));
    	clmnDescriptionF.setCellValueFactory(new PropertyValueFactory<>("description"));
    	clmnJanF.setCellValueFactory(new PropertyValueFactory<>("jan"));
    	clmnFebF.setCellValueFactory(new PropertyValueFactory<>("feb"));
    	clmnMarF.setCellValueFactory(new PropertyValueFactory<>("mar"));
    	clmnAprF.setCellValueFactory(new PropertyValueFactory<>("apr"));
    	clmnMayF.setCellValueFactory(new PropertyValueFactory<>("may"));
    	clmnJunF.setCellValueFactory(new PropertyValueFactory<>("jun"));
    	clmnJulF.setCellValueFactory(new PropertyValueFactory<>("jul"));
    	clmnAugF.setCellValueFactory(new PropertyValueFactory<>("aug"));
    	clmnSepF.setCellValueFactory(new PropertyValueFactory<>("sep"));
    	clmnOctF.setCellValueFactory(new PropertyValueFactory<>("oct"));
    	clmnNovF.setCellValueFactory(new PropertyValueFactory<>("nov"));
    	clmnDecF.setCellValueFactory(new PropertyValueFactory<>("dec"));
    	clmnTotalF.setCellValueFactory(new PropertyValueFactory<>("total"));
    	clmnDesvStandardF.setCellValueFactory(new PropertyValueFactory<>("desvStand"));
    	// Shows results
    	tblViewForecast.setItems(null);
    	tblViewForecast.setItems(listForecast);
        // Shows total results
        int totalResults = listForecast.size();
        lblTotalResults.setText(""+totalResults);
    	
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
