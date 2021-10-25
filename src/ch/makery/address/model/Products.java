package ch.makery.address.model;

/**
 * Class Products. Defined as abstract class in order to extend classes Raw Materials, Components, Commercial Products.
 * @author Ghost
 *
 */
public abstract class Products {

		private int idProduct;
		private String productCode;
		private String productName;
		private String idFamily;
		private int stock;
		private int SecurityStock;
		private double Cost;
		
		/**
		 * 
		 * @param idProduct
		 * @param productCode
		 * @param productName
		 * @param idFamily
		 * @param stock
		 * @param SecurityStock
		 * @param Cost
		 */
		public Products(int idProduct, String productCode, String productName, String idFamily, int stock, int SecurityStock, double Cost){
			setIdProduct(idProduct);
			setProductCode(productCode);
			setProductName(productName);
			setIdFamily(idFamily);
			setStock(stock);
			setSecurityStock(SecurityStock);
			setCost(Cost);
		}
		
		
		
		/**
		 * 
		 * @return Product id
		 */
		public int getIdProduct() {
			return idProduct;
		}
		
		/**
		 * 
		 * @param idProduct
		 */
		public void setIdProduct(int idProduct) {
			this.idProduct = idProduct;
		}
		
		/**
		 * 
		 * @return Product Code
		 */
		public String getProductCode() {
			return productCode;
		}
		
		/**
		 * 
		 * @param productCode
		 */
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		
		/**
		 * 
		 * @return Product Name
		 */
		public String getProductName() {
			return productName;
		}
		
		/**
		 * 
		 * @param productName
		 */
		public void setProductName(String productName) {
			this.productName = productName;
		}
		
		/**
		 * 
		 * @return Family id
		 */
		public String getIdFamily() {
			return idFamily;
		}
		
		/**
		 * 
		 * @param idFamily
		 */
		public void setIdFamily(String idFamily) {
			this.idFamily = idFamily;
		}
		
		/**
		 * 
		 * @return Current Stock
		 */
		public int getStock() {
			return stock;
		}
		
		/**
		 * 
		 * @param stock
		 */
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		/**
		 * 
		 * @return Security Stock
		 */
		public int getSecurityStock() {
			return SecurityStock;
		}
		
		/**
		 * 
		 * @param securityStock
		 */
		public void setSecurityStock(int securityStock) {
			SecurityStock = securityStock;
		}
		
		/**
		 * 
		 * @return
		 */
		public double getCost() {
			return Cost;
		}
		
		/**
		 * 
		 * @param cost
		 */
		public void setCost(double cost) {
			Cost = cost;
		}
}
