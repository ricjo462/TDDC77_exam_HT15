package pizza_2;

public class TomatoPizzaDecorator extends PizzaDecorator {
	
	Pizza pizza;
	
	TomatoPizzaDecorator(Pizza pizza){
		this.pizza = pizza;
	}

	@Override
	public int getPrice() {
		return 12 + pizza.getPrice();
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", tomato";
	}
	

}
