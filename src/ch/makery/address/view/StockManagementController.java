package ch.makery.address.view;
import ch.makery.address.model.Stock;
import db.ConexionMySql;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
// import ch.makery.address.model.Person;

/**
 * The controller for the birthday statistics view.
 * 
 * @author Carlos Vioque
 */

public class StockManagementController implements Initializable {

	
	@FXML
	private Button btClose;
	@FXML
	private Button btGraficodeprueba;
	
	/*
    @FXML
    private BarChart<String, Integer> barChart;
	*/
	
	//Columns
	@FXML 
	private TableColumn<Stock, String> clmnItem;
	@FXML 
	private TableColumn<Stock, Double> clmnJan;
	@FXML 
	private TableColumn<Stock, Double> clmnFeb;
	@FXML 
	private TableColumn<Stock, Double> clmnMar;
	@FXML 
	private TableColumn<Stock, Double> clmnApr;	
	@FXML 
	private TableColumn<Stock, Double> clmnMay;
	@FXML 
	private TableColumn<Stock, Double> clmnJun;
	@FXML 
	private TableColumn<Stock, Double> clmnJul;
	@FXML	
	private TableColumn<Stock, Double> clmnAug;
	@FXML 
	private TableColumn<Stock, Double> clmnSep;
	@FXML 
	private TableColumn<Stock, Double> clmnOct;
	@FXML 
	private TableColumn<Stock, Double> clmnNov;
	@FXML 
	private TableColumn<Stock, Double> clmnDec;
	@FXML 
	private TableColumn<Stock, Double> clmnItem2;
		
	
	//Chart
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    
	//Tables
	@FXML 
	private TableView<Stock> tblViewStocksCost;
	@FXML 
	private TableView<Stock> tblViewStocksUnits;
	
	//Collections
	private ObservableList<Stock> listStocksCost;
	//Collections
	private ObservableList<Stock> listStocksUnits;

	private ConexionMySql conn;
	
    // private ObservableList<String> monthNames = FXCollections.observableArrayList();

    
    
    
        
    
    /**
     * 
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	conn=new ConexionMySql();			// Esto es indispensable sino no me ejecuta ninguna query en tableview y me salta un catch.
    	stockChart();						// Load stock cost graph
    	stockChartDataBaseCost();			// Load stock cost grid
    	stockChartDataBaseUnits();			// Load stock unit grid
    }

    
    
    
    public void stockChart() {
    	
    	XYChart.Series set1 = new XYChart.Series<>();
    	
    	set1.getData().add(new XYChart.Data("January", 600000));
    	set1.getData().add(new XYChart.Data("February", 700000));
    	set1.getData().add(new XYChart.Data("March", 600500));
    	set1.getData().add(new XYChart.Data("April", 680500));  
    	set1.getData().add(new XYChart.Data("May", 710000));
    	set1.getData().add(new XYChart.Data("June", 610500));
    	set1.getData().add(new XYChart.Data("July", 410500));
    	set1.getData().add(new XYChart.Data("August", 510500));
    	set1.getData().add(new XYChart.Data("September", 0));
    	set1.getData().add(new XYChart.Data("October", 0));
    	set1.getData().add(new XYChart.Data("November", 0));
    	set1.getData().add(new XYChart.Data("December", 0));
  	

    	barChart.getData().addAll(set1);
    	
    }
    
   

    
    /**
     * Load stock grid showing total cost 
     * 
     */
    public void stockChartDataBaseCost() {
    	

    	try {
    		
        	java.sql.Connection connection = conn.conectar();
        	listStocksCost = FXCollections.observableArrayList();
        	ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM stockVal_2019_TSA");
    		
        	
        	while(rs.next()) {
        		
        		listStocksCost.add(new Stock(
        				rs.getString("itemName"),
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
            			rs.getDouble("december")
        				));
        	}

    	}
    	catch(Exception ex){
	        JOptionPane.showMessageDialog(null,"Error loading stock: "+ex,
	                "Error",JOptionPane.ERROR_MESSAGE);
	    }
    		
        // Configure Table (Enlazamos columnas con atributos)
    	clmnItem.setCellValueFactory(new PropertyValueFactory<>("itemName"));
    	clmnJan.setCellValueFactory(new PropertyValueFactory<>("jan"));
    	clmnFeb.setCellValueFactory(new PropertyValueFactory<>("feb"));
    	clmnMar.setCellValueFactory(new PropertyValueFactory<>("mar"));
    	clmnApr.setCellValueFactory(new PropertyValueFactory<>("apr"));
    	clmnMay.setCellValueFactory(new PropertyValueFactory<>("may"));
    	clmnJun.setCellValueFactory(new PropertyValueFactory<>("jun"));
    	clmnJul.setCellValueFactory(new PropertyValueFactory<>("jul"));
    	clmnAug.setCellValueFactory(new PropertyValueFactory<>("aug"));
    	clmnSep.setCellValueFactory(new PropertyValueFactory<>("sep"));
    	clmnOct.setCellValueFactory(new PropertyValueFactory<>("oct"));
    	clmnNov.setCellValueFactory(new PropertyValueFactory<>("nov"));
    	clmnDec.setCellValueFactory(new PropertyValueFactory<>("dec"));
    	// Shows results
    	tblViewStocksCost.setItems(null);
    	tblViewStocksCost.setItems(listStocksCost);	
    
    }


    
    /**
     * Load stock grid showing total units
     * 
     */
    public void stockChartDataBaseUnits() {
    	

    	try {
    		
        	java.sql.Connection connection = conn.conectar();
        	listStocksUnits = FXCollections.observableArrayList();
        	ResultSet rs = connection.createStatement().executeQuery("SELECT itemName FROM stockVal_2019_TSA");
    		
        	
        	while(rs.next()) {
        		
        		listStocksUnits.add(new Stock(
        				rs.getString("itemName")
        				));
        	
            	tblViewStocksUnits.setItems(null);
            	tblViewStocksUnits.setItems(listStocksUnits);	
        	}
    	}catch(Exception ex){
	        JOptionPane.showMessageDialog(null,"Error loading stock: "+ex,
	                "Error",JOptionPane.ERROR_MESSAGE);
	    }
    		
        // Configure Table (Enlazamos columnas con atributos)
    	clmnItem2.setCellValueFactory(new PropertyValueFactory<>("itemName"));

    	// Shows results


    
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
