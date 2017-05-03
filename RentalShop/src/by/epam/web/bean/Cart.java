package by.epam.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Cart implements Serializable{
private ArrayList<Item> list;

public Cart() {
	this.list = new ArrayList<Item>();
}

public ArrayList<Item> getList() {
	return list;
}

public void setList(ArrayList<Item> list) {
	this.list = list;
}

public void addItem(Item item){
	Item itemT = null;
	for (int i = 0; i<list.size(); i++){
		if (list.get(i).getEquipment().getId()==item.getEquipment().getId()){
			itemT = list.get(i);
			itemT.setQuantity(item.getQuantity()+itemT.getQuantity());
			return;
		}
	}	
	list.add(item);
}

public Item getItem(int id){
	return list.get(id);
}

public void removeItem(Item item){
	list.remove(item);
}

public void setItemQuantity(int id, int quantity){
	for (int i = 0; i<list.size(); i++){
		if (list.get(i).getEquipment().getId()==id){
			list.get(i).setQuantity(quantity);
			return;
		}
	}	
}

public void removeItemById(int id){
	Iterator<Item> iter = list.iterator();
	while (iter.hasNext()){
		if (iter.next().getEquipment().getId()==id){
			iter.remove();
		}
	}
}

public double getTotal(){
	double sum=0.0;
	double eqPrice=0.0;
	int quantity = 0;
	for (int i=0; i<list.size(); i++){
		eqPrice = list.get(i).getEquipment().getPrice();
		quantity = list.get(i).getQuantity();
		sum += eqPrice*quantity;
	}
	return sum;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((list == null) ? 0 : list.hashCode());
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
	Cart other = (Cart) obj;
	if (list == null) {
		if (other.list != null)
			return false;
	} else if (!list.equals(other.list))
		return false;
	return true;
}

@Override
public String toString() {
	return "Cart [list=" + list + "]";
}


}
