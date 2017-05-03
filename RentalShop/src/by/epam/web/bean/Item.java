package by.epam.web.bean;

import java.io.Serializable;
import java.sql.Date;

public class Item implements Serializable{
	private int id;
	private Equipment equipment;
	private User user;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + id;
		result = prime * result + quantity;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Item other = (Item) obj;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (id != other.id)
			return false;
		if (quantity != other.quantity)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", equipment=" + equipment + ", user=" + user + ", quantity=" + quantity + "]";
	}
	
	public Item(int quantity, Equipment equipment, User user)  {
		this.equipment = equipment;
		this.user = user;
		this.quantity = quantity;
	}
	
	public Item(int id, int quantity, Equipment equipment, User user)  {
		this.id = id;
		this.equipment = equipment;
		this.user = user;
		this.quantity = quantity;
	}
	
	public Item() {
	}
	
	
}
