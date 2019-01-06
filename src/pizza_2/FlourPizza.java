package pizza_2;

public class FlourPizza implements Pizza{

	@Override
	public int getPrice() {
		return 30;
	}

	@Override
	public String getDescription() {
		return "flour";
	}
	
	

}
