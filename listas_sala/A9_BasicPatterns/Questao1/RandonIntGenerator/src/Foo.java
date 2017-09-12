public class Foo {
	private boolean withBar;

	public Foo(boolean withBar){
		this.withBar = withBar;
	}
	
	static public Foo CreateWithBar(){
		return new Foo(true);
	}
	
	static public Foo CreateWithOutBar(){
		return new Foo(false);
	}
}
