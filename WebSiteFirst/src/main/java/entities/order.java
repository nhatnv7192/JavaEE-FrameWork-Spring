package entities;


public class order {
	private int orderId;
	private String orderCode;
	private String orderDate;
	private double shippingCost;
	private String contactName;
	private String contactPhone;
	private String contactEmail;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String status;
	
	
	public order() {
		super();
	}
	public order(String orderCode, String orderDate, double shippingCost, String contactName, String contactPhone,String description,String contactEmail) {
		super();
		this.orderCode = orderCode;
		this.orderDate = orderDate;
		this.shippingCost = shippingCost;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.description = description;
	}
	public order(String orderCode, String orderDate, double shippingCost, String contactName, String contactPhone,
			String contactEmail,String description, String status) {
		super();
		this.orderCode = orderCode;
		this.orderDate = orderDate;
		this.shippingCost = shippingCost;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.description = description;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
