package edu.softech.shoesShop.model;

import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesType;

public class CartItem {
	private final Shoes shoes;
	private int quantity;
	private ShoesType shoesType;
	private double subTotal;
	
	public CartItem(Shoes shoes)
	{
		this.shoes = shoes;
		this.quantity = 1;
		this.shoesType = shoes.getShoesType();
		this.subTotal = shoesType.getUnitPrice();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShoesType getShoesType() {
		return shoesType;
	}

	public void setShoesType(ShoesType shoesType) {
		this.shoesType = shoesType;
	}

	public double getSubTotal() {
		subTotal =  shoesType.getUnitPrice() * quantity;
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Shoes getShoes() {
		return shoes;
	}
	
	
}
