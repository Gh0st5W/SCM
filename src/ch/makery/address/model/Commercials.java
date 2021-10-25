package ch.makery.address.model;

public class Commercials /*extends Products*/ {
	private int idCommercials;
	private String commercialCode;
	private String commercialName;
	//private String idFamily;
	private int stock;
	private int SecurityStock;
	private double Cost;
	
	/**
	 * Class Commercials Constructor
	 */
	public Commercials(int idCommercials, String commercialCode, String commercialName, int stock, int SecurityStock, double Cost) {
		
		setIdCommercials(idCommercials);
		setCommercialCode(commercialCode);
		setCommercialName(commercialName);
		setStock(stock);
		setSecurityStock(SecurityStock);
		setCost(Cost);
		
	}

	

	
	
	public String getCommercialCode() {
		return commercialCode;
	}





	public void setCommercialCode(String commercialCode) {
		this.commercialCode = commercialCode;
	}





	public String getCommercialName() {
		return commercialName;
	}





	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}




	public int getIdCommercials() {
		return idCommercials;
	}

	public void setIdCommercials(int idCommercials) {
		this.idCommercials = idCommercials;
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
	public static void add(Commercials Commercials) {
		// TODO Auto-generated method stub
		
	}
}
