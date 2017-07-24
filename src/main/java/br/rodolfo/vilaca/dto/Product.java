package br.rodolfo.vilaca.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
public class Product {
	private int id;
	private String name;
	private Double price;
	private String description;
	private int quantity;
	
	public Product(){}
	
	public Product(int id, String name, Double price, String description, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
