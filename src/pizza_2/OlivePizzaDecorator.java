package pizza_2;

public class OlivePizzaDecorator extends PizzaDecorator{

	Pizza pizza;
	
	OlivePizzaDecorator(Pizza pizza){
		this.pizza = pizza;
	}
	
	@Override
	public int getPrice() {
		return 7 + pizza.getPrice();
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", olive";
	}
	

}