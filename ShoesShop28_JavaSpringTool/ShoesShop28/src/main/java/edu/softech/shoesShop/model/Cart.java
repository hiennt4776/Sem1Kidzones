package edu.softech.shoesShop.model;

import java.util.ArrayList;
import java.util.List;

import edu.softech.shoesShop.domain.Shoes;

public class Cart {
	private final List<CartItem> items;
	public double total;
	// test quanttiti
	public int totalQuantity;


	public Cart() {
		items = new ArrayList<CartItem>();
		total = 0;
	}
	public CartItem getItem(Shoes shoes)
	{
		for(CartItem item: items) {
			if(item.getShoes().getShoesId() == shoes.getShoesId()) {
				return item;
			}
		}
		return null;
	}
	
	public List<CartItem> getItems(){
		return items;
	}
	
	public double getTotal() {
		total = 0;
		for(CartItem item:items) {
			total += item.getSubTotal();
		}
		
		return total;
				
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getItemCount() {
		return items.size();
	}
	
	public void addItem(CartItem item) {
		addItem(item.getShoes(), item.getQuantity());
	}
	public void addItem(Shoes shoes, int quantity) {
		CartItem item = getItem(shoes);
		if(item != null) {
			item.setQuantity(item.getQuantity() + quantity);
		}
		else {
			item = new CartItem(shoes);
			item.setQuantity(quantity);
			items.add(item);
		}
	}
	
	public void updateItem(Shoes shoes, int quantity) {
		CartItem item = getItem(shoes);
		if(item != null) {
			item.setQuantity(quantity);
		}
	}
	
	public void removeItem(Shoes shoes) {
		CartItem item = getItem(shoes);
		if(item != null) {
			items.remove(item);
		}
	}
	
	public void clear() {
		items.clear();
		total = 0;
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	public int getTotalQuantity() {
		totalQuantity = 0;
		for(CartItem item:items) {
			totalQuantity += item.getQuantity();
		}
		
		
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
}
