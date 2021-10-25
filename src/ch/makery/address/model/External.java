package ch.makery.address.model;

/**
 * 
 * @author Ghost
 * It is an abstract class due to we are not going to instantite any attribute or method directly from it.
 */
public abstract class External{
	
	private String name;
	private String contact;
	private String email;
	private String phone;
	
	public External(String name, String contact, String email, String phone) {
		setName(name);
		setContact(contact);
		setEmail(email);
		setPhone(phone);			
	}
	
	
// Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setContact (String contact) {
		this.contact = contact;
	}
	
	
	public void setEmail (String email) {
		this.email = email;
	}
	
	
	public void setPhone (String phone) {
		this.phone = phone;
	}
	
	
//Getters
	
	public String getName() {
		return name;
	}
	
	
	public String getContact() {
		return contact;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	@Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	
	str.append(getName()+"\n");
	str.append(getContact()+"\n");
	str.append(getEmail()+"\n");
	str.append(getPhone()+"\n");
	
	return str.toString();
}
	
	
	
}