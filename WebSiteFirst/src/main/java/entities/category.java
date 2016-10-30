package entities;

public class category {
	private int categoryId;
	private String name;
	private String status;
	
	public category() {
		super();
	}
	public category(String name, String status) {
		super();
		this.name = name;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
