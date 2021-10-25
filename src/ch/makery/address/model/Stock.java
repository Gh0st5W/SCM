package ch.makery.address.model;



/**
 *
 * @author Ghost
 */
public class Stock {

	private String itemName;
	private Double jan;
	private Double feb;
	private Double mar;
	private Double apr;
	private Double may;
	private Double jun;
	private Double jul;
	private Double aug;
	private Double sep;
	private Double oct;
	private Double nov;
	private Double dec;
	
	public Stock(String itemName) {}
	public Stock(String itemName, double jan, double feb, double mar, double apr, double may, double jun, double jul, double aug, double sep, double oct, double nov, double dec) {	
		setItem(itemName);
		setJan(jan);
		setFeb(feb);
		setMar(mar);
		setApr(apr);
		setMay(may);
		setJun(jun);
		setJul(jul);
		setAug(aug);
		setSep(sep);
		setOct(oct);
		setNov(nov);
		setDec(dec);
	
	
	
	
	}
	
	
	public String getItem() {
		return itemName;
	}
	public void setItem(String itemName) {
		this.itemName = itemName;
	}
	public Double getJan() {
		return jan;
	}
	public void setJan(Double jan) {
		this.jan = jan;
	}
	public Double getFeb() {
		return feb;
	}
	public void setFeb(Double feb) {
		this.feb = feb;
	}
	public Double getMar() {
		return mar;
	}
	public void setMar(Double mar) {
		this.mar = mar;
	}
	public Double getApr() {
		return apr;
	}
	public void setApr(Double apr) {
		this.apr = apr;
	}
	public Double getMay() {
		return may;
	}
	public void setMay(Double may) {
		this.may = may;
	}
	public Double getJun() {
		return jun;
	}
	public void setJun(Double jun) {
		this.jun = jun;
	}
	public Double getJul() {
		return jul;
	}
	public void setJul(Double jul) {
		this.jul = jul;
	}
	public Double getAug() {
		return aug;
	}
	public void setAug(Double aug) {
		this.aug = aug;
	}
	public Double getSep() {
		return sep;
	}
	public void setSep(Double sep) {
		this.sep = sep;
	}
	public Double getOct() {
		return oct;
	}
	public void setOct(Double oct) {
		this.oct = oct;
	}
	public Double getNov() {
		return nov;
	}
	public void setNov(Double nov) {
		this.nov = nov;
	}
	public Double getDec() {
		return dec;
	}
	public void setDec(Double dec) {
		this.dec = dec;
	}
	
	
	

}