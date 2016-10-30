package entities;

public class orderDetails {
	private int orderDetailId;
	private int orderId;
	private int productId;
	private int quantity;
	private double price;
	private double discount;
	private String noted;
	
	public orderDetails() {
		super();
	}
	public orderDetails(int orderDetailId, int orderId, int productId, int quantity, double price, double discount,
			String noted) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.noted = noted;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getNoted() {
		return noted;
	}
	public void setNoted(String noted) {
		this.noted = noted;
	}
	
}
