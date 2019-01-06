package pizza_2;

public class RyePizza implements Pizza {

	@Override
	public int getPrice() {
		return 35;
	}

	@Override
	public String getDescription() {
		return "rye flour";
	}

}
