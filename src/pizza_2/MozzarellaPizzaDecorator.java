package pizza_2;

public class MozzarellaPizzaDecorator extends PizzaDecorator{

	Pizza pizza;
	
	MozzarellaPizzaDecorator(Pizza pizza){
		this.pizza = pizza;
	}
	
	@Override
	public int getPrice() {
		return 13 + pizza.getPrice();
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", mozzarella";
	}
	

}
