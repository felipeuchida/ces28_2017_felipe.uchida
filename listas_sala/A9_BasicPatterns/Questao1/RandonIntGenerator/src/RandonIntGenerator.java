public class RandonIntGenerator {
	private final int min;
	private final int max;

	private RandonIntGenerator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	static public RandonIntGenerator ConstrutorMin(int min){
		return new RandonIntGenerator(min, Integer.MAX_VALUE);
	}
	
	static public RandonIntGenerator ConstrutorMax(int max){
		return new RandonIntGenerator(Integer.MIN_VALUE, max);
	}
	
	static public RandonIntGenerator ConstrutorEntre(int min, int max){
		return new RandonIntGenerator(min, max);
	}
}
