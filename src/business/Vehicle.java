package business;

public class Vehicle {

	private String name;
	private String brand;

	public Vehicle() {
	}

	public Vehicle(String name, String brand) {
		super();
		this.name = name;
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
