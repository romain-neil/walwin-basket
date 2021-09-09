package fr.romain_neil.valwin.core.tools;

import fr.romain_neil.valwin.core.Brand;

/**
 * Represent an abstract tool, used to declare tools
 * @since 1.0.0
 */
public abstract class AbstractTool {

	protected Brand brand;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	protected double price;

	public Brand getBrand() {
		return brand;
	}

	protected String name;

	public String getName() {
		return name;
	}

	public AbstractTool(Brand brand, String name, double price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
	}

}
