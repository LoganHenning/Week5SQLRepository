package entity;

public class Chess {

	
	private int id;
	private String name;
	private String quantity;
	private Double price;
	
	public Chess(int id, String name, String quantity, Double price) {
		this.setId(id);
		this.setName(name);
		this.setQuantity(quantity);
		this.setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
