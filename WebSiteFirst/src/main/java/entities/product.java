package entities;

public class product {
	private int productId;
	private int categoryId;
	private String name;
	private float price;
	private int discount;
	private String status;
	private String imageUrl;
	private String description;
	
	public product() {
		super();
	}

	public product(int categoryId, String name, float price, int discount, String status, String imageUrl,
			String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.status = status;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
