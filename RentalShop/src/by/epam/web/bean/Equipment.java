package by.epam.web.bean;

import java.io.Serializable;

public class Equipment implements Serializable{
	private int id;
	private String name;
	private double cost;
	private double price;
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
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipment other = (Equipment) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	public Equipment(int id, String name, double cost, double price) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", cost=" + cost + ", price=" + price + "]";
	}
	public Equipment() {
	}
	public Equipment(String name, double cost, double price) {
		this.name = name;
		this.cost = cost;
		this.price = price;
	}
	public Equipment(int id, String name){
		this.id = id;
		this.name = name;
	}
	public Equipment(String name){
		this.name = name;
	}
	
	
	
}
