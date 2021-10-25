package ch.makery.address.model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import db.JdbcHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import db.JdbcHelper;
//import java.sql.ResultSet;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javax.swing.JOptionPane;

public class SupplierRepo {

	
	  public static ObservableList<Supplier> buscarTodosSuppliers(){
	        String query = "SELECT * FROM Suppliers";
	        JdbcHelper jdbc = new JdbcHelper();
	        ResultSet rs = jdbc.realizarConsulta(query);
	        
	        ObservableList<Supplier> supplier = FXCollections.observableArrayList();
	        
	        try{
	            while(rs.next()){
	                int idSupplier = rs.getInt("idSupplier");
	                String supplierName = rs.getString("supplierName");
	                int leadTime = rs.getInt("leadTime");
	                int familiyCode = rs.getInt("familiyCode");
	                String family = rs.getString("family");
	                int repositionTime = rs.getInt("repositionTime");
	                Supplier.add(new Supplier(idSupplier, supplierName, leadTime, familiyCode, family, repositionTime));
	                /* Print por consola de las columnas deseadas */
	                System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
	            }
	        }catch(Exception ex){
	            JOptionPane.showMessageDialog(null,"Error al buscar libros: "+ex,
	                    "Error",JOptionPane.ERROR_MESSAGE);
	        }
	        
	        /*
	        while (rs.next()) {
	            for (int columnIndex = 1; columnIndex <= 3; columnIndex ++){
	                System.out.println(columnIndex + "<====>" + rs.getString(columnIndex));
	            }
	            
	            
	        }*/
	        return supplier;
	    }
	    
	
}
