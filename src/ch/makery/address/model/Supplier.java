package ch.makery.address.model;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import db.JdbcHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Supplier extends External{
	
	private int idSupplier;
    private String supplierName;
    private int leadTime;
    private int familiyCode;
    private String componentName;
    private int family;
	
	
		
	public Supplier(int idSupplier, String supplierName, int leadTime, int familiyCode, String componentName, int family) {
		super(componentName, componentName, componentName, componentName);
		setIdSupplier(idSupplier);
		
	}
	
	
// Setters
	
	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}


	public int getLeadTime() {
		return leadTime;
	}


	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}


	public int getFamiliyCode() {
		return familiyCode;
	}


	public void setFamiliyCode(int familiyCode) {
		this.familiyCode = familiyCode;
	}


	public String getComponentName() {
		return componentName;
	}


	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}


	public int getFamily() {
		return family;
	}


	public void setFamily(int family) {
		this.family = family;
	}


	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	
	
// Getters	
	
	public int getIdSupplier() {
		return idSupplier;
	}



	public static void add(Supplier supplier) {
		// TODO Auto-generated method stub
		
	}
	
    
    
    /* ESTE METODO TENDRIA QUE ESTAR EN SU REPO */
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

	                System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
	            }
	        }catch(Exception ex){
	            JOptionPane.showMessageDialog(null,"Error al buscar libros: "+ex,
	                    "Error",JOptionPane.ERROR_MESSAGE);
	        }
	        

	        return supplier;
	    }
	    
  

	
}