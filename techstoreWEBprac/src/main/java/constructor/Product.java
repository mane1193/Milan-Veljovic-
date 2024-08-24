package constructor;

public class Product {

String name;
String description;
Double price;


public Product(String name, String description, Double price) {
	super();
	this.name = name;
	this.description = description;
	this.price = price;
}




public String getName() {
	return name;
}




public Double getPrice() {
	return price;
}




@Override
public String toString() {
	return name + ", Description= " + description + ", Price= " + price + " RSD";
}	


	
}
