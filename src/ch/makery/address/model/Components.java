package ch.makery.address.model;



/**
 * 
 * @author Ghost
 *
 */
public class Components /*extends Products*/ {
	
	private int idComponents;
	private String componentCode;
	private String componentName;
	private int stock;
	private int SecurityStock;
	private double Cost;
	
	/**
	 * Class Components Constructor
	 */
	public Components(int idComponents, String componentCode, String componentName, int stock, int SecurityStock, double Cost) {
		
		setIdComponents(idComponents);
		setComponentCode(componentCode);
		setComponentName(componentName);
		setStock(stock);
		setSecurityStock(SecurityStock);
		setCost(Cost);
		
	}

	

	
	
	public int getIdComponents() {
		return idComponents;
	}

	public void setIdComponents(int idCompponents) {
		this.idComponents = idCompponents;
	}

	public String getComponentCode() {
		return componentCode;
	}

	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getSecurityStock() {
		return SecurityStock;
	}


	public void setSecurityStock(int securityStock) {
		SecurityStock = securityStock;
	}


	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}


	/* Creado a la fuerza por un FIX, no se donde esta el add en el ejemplo */
	public static void add(Components components) {
		// TODO Auto-generated method stub
		
	}
	
	
	 
    	
}




