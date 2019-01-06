package pizza_2;

class Menu{

    public static void main(String[] args){

	Pizza[] menu = new Pizza[8];
	menu[0] = new TomatoPizzaDecorator(new FlourPizza());
	menu[1] = new MozzarellaPizzaDecorator(menu[0]);
	menu[2] = new OlivePizzaDecorator(menu[0]);
	menu[3] = new OlivePizzaDecorator(menu[1]);
	menu[4] = new TomatoPizzaDecorator(new RyePizza());
	menu[5] = new MozzarellaPizzaDecorator(menu[4]);
	menu[6] = new OlivePizzaDecorator(menu[4]);
	menu[7] = new OlivePizzaDecorator(menu[5]);


	for(Pizza p: menu){
	    System.out.println("Pizza with " + p.getDescription() + ": " + p.getPrice() + " sek");
	}

    }
}