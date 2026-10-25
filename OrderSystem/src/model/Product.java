package model;

public class Product extends Orderable{
	private int unitPrice;
	private int quantity;

	public Product(String name, int unitPrice, int quantity) {
        super(name);
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	//increasing the quantity of an existing product
    public void increaseQuantity(int addQuantity) {
        this.quantity += addQuantity;
    }
    public int getUnitPrice(){
        return unitPrice;
    }

	public int getPrice() {
		return unitPrice * quantity;
	}

	@Override
	public void print() {
	}

	@Override
	public String toString() {
		return quantity + " * " + getName();
	}
}
