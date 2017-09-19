public class HousingClient {
	public static void main(String[] args) {
		WoodenHouse woodenhouse = new WoodenHouse();
		woodenhouse.buildHouse();
		System.out.println("************");
		
		GlassHouse glassHouse = new GlassHouse();
		glassHouse.buildHouse();
		System.out.println("************");
	}
}
