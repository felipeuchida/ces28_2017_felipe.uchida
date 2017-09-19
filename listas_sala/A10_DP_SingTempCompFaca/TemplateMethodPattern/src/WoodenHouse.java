public class WoodenHouse {
	public final void buildHouse(){
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}
	protected void buildFoundation() {
		System.out.println("Building foundation with cement,iron rods and sand");
	}
	protected void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
	protected void buildWalls() {
		System.out.println("Building Wooden Walls");
	}
	protected void buildWindows() {
		System.out.println("Building Glass Windows");
	}
}
