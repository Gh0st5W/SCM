package ch.makery.address.view;

//import ch.makery.address.view.StockManagementController;		// Importo esta clase para el grafico de stock.

import javafx.scene.control.Button;	
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import ch.makery.address.MainApp;
import javafx.event.ActionEvent;	// Importamos para poder ejecutar eventos en un boton
import javafx.application.Platform;

import javafx.fxml.FXML;		// Importamos para poder usar los @FXML
import javafx.fxml.FXMLLoader;	// Importamos para cargar nuevos FXML mediante el click en un boton
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;	// Importamos para cargar nuevos FXML mediante el click en un boton
import javafx.stage.Stage;		// Importamos para cargar nuevos FXML mediante el click en un boton
import javafx.fxml.Initializable;	// Importamos para implementar el metodo initialitzable que inicializa el programa a nivel visual




public class MainWindowController implements Initializable{


    //private MainApp mainApp;				// Reference to the main application. Lo referenciamos para poder usar metodos implementados alli como las estadisticas logisticas.
    private Stage primaryStage;    
    

	@FXML
	private Button btProductionPlan;
	@FXML
	private Button btProcurementPlan;
	@FXML
	private Button btPurchasing;
	@FXML
	private Button btLogisticsPlan;
	@FXML
	private Button btSupplyManagementTools;
	@FXML
	private Button btStockManagment;
	@FXML
	private Button btSuppliers;
	@FXML
	private Button btClose;
	
	/****** ESTO ES PRUEBA PARA VER CONSIGO TRAERME GRAFICOS "RESUMEN" Y NO TENERLOS QUE IMPLEMENTAR DIRECTAMENTE AQUI *******/
	
    @FXML
    private BarChart<String, Double> barChart1;
    @FXML
    private BarChart<?, ?> barChart2;
    @FXML
    private BarChart<?, ?> barChart3;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis2;
    @FXML
    private NumberAxis yAxis2;
    @FXML
    private CategoryAxis xAxis3;
    @FXML
    private NumberAxis yAxis3;
    
	/***************************************************************/
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    /*
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	*/
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//stockChart();
		//stockChartCommercials();
		//stockChartManufactured();
	}

	
	/*
    public void stockChart() {
    	
    	XYChart.Series set1 = new XYChart.Series<>();
    	
    	set1.getData().add(new XYChart.Data("JAN", 706119));
    	set1.getData().add(new XYChart.Data("FEB", 696434));
    	set1.getData().add(new XYChart.Data("MAR", 730619));
    	set1.getData().add(new XYChart.Data("APR", 731891));  
    	set1.getData().add(new XYChart.Data("MAY", 717230));
    	set1.getData().add(new XYChart.Data("JUN", 690306));
    	set1.getData().add(new XYChart.Data("JUL", 684247));
    	set1.getData().add(new XYChart.Data("AUG", 653049));
    	set1.getData().add(new XYChart.Data("SEP", 0));
    	set1.getData().add(new XYChart.Data("OCT", 0));
    	set1.getData().add(new XYChart.Data("NOV", 0));
    	set1.getData().add(new XYChart.Data("DEC", 0));
  	

    	barChart1.getData().addAll(set1);
    	
    }
    
    
    public void stockChartCommercials() {
    	
    	XYChart.Series set1 = new XYChart.Series<>();
    	
    	set1.getData().add(new XYChart.Data("JAN", 145935));
    	set1.getData().add(new XYChart.Data("FEB", 102187));
    	set1.getData().add(new XYChart.Data("MAR", 101448));
    	set1.getData().add(new XYChart.Data("APR", 154477));  
    	set1.getData().add(new XYChart.Data("MAY", 169250));
    	set1.getData().add(new XYChart.Data("JUN", 171314));
    	set1.getData().add(new XYChart.Data("JUL", 219175));
    	set1.getData().add(new XYChart.Data("AUG", 220999));
    	set1.getData().add(new XYChart.Data("SEP", 0));
    	set1.getData().add(new XYChart.Data("OCT", 0));
    	set1.getData().add(new XYChart.Data("NOV", 0));
    	set1.getData().add(new XYChart.Data("DEC", 0));
  	

    	barChart2.getData().addAll(set1);
    	
    }
    
    
    public void stockChartManufactured() {
    	
    	XYChart.Series set3 = new XYChart.Series<>();
    	
    	set3.getData().add(new XYChart.Data("JAN", 400700));
    	set3.getData().add(new XYChart.Data("FEB", 700000));
    	set3.getData().add(new XYChart.Data("MAR", 500500));
    	set3.getData().add(new XYChart.Data("APR", 580500));  
    	set3.getData().add(new XYChart.Data("MAY", 710000));
    	set3.getData().add(new XYChart.Data("JUN", 610500));
    	set3.getData().add(new XYChart.Data("JUL", 810500));
    	set3.getData().add(new XYChart.Data("AUG", 710500));
    	set3.getData().add(new XYChart.Data("SEP", 0));
    	set3.getData().add(new XYChart.Data("OCT", 0));
    	set3.getData().add(new XYChart.Data("NOV", 0));
    	set3.getData().add(new XYChart.Data("DEC", 0));
  	

    	barChart3.getData().addAll(set3);
    	
    }
	*/
	
	@FXML
	public void productionMenu() throws IOException {
	
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Production.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Stock Statistics");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		

	}	
	
	
	@FXML
	public void procurementMenu() throws IOException {
	
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Procurement.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Stock Statistics");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		

	}	
	
	
	@FXML
	public void purchasingMenu() throws IOException {
	
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Purchasing.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Stock Statistics");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		

	}	
	
	
	
	@FXML
	public void logisticsMenu() throws IOException {
	
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Logistics.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Logistics");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		

	}		
			
	
	
	@FXML
	public void SupplyChainManagementToolsMenu() throws IOException {
	
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/SupplyChainManagementTools.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("SupplyChainManagementTools");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		

	}
	
	
     


	public void SuppliersMenu() throws IOException {
		
        // Load the fxml file and create a new stage for the popup.

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/Suppliers.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Suppliers");
        dialogStage.initModality(Modality.WINDOW_MODAL);        
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);    
        dialogStage.show();
		
	}	
				
	

	
	@FXML
	public void closeApp(ActionEvent event) {
		Platform.exit();			// Sale de la aplicacion
		System.exit(0);				// Evita que se quede corriendo en segundo plano
	}
	
	
}