package ch.makery.address.model;

public class Customer extends External{
	
	private int idCustomer;
	
	public Customer(String name, String contact, String email, String phone, int idCustomer) {
		super(name, contact, email, phone);
		
	}
	
	// Setters
	
		public void setIdCustomer(int idCustomer) {
			this.idCustomer = idCustomer;
		}
		
		
	// Getters	
		
		public int getIdCustomer() {
			return idCustomer;
		}
		
	}
	
	
	
	
	

