import java.util.LinkedList;
import java.util.List;

public class Drawing implements Shape{
	private List<Shape> _shapes = new LinkedList<Shape>( );
	
	@Override
	public void draw(String fillColor) {
		int n = _shapes.size();
		for (int i=0; i < n; i++) {
			_shapes.get(i).draw(fillColor);
		}
	}

	public void add(Shape shape) {
		_shapes.add(shape); 
	}
	
	public void remove(int i) {
		_shapes.remove(i); 
	}
	
	public int size() { 
		return _shapes.size(); 
	}
	
	public Shape get(int i) { 
		return _shapes.get(i); 
	}
	
	public void clear() {
		System.out.println("Clearing all the shapes from drawing");
		int n = _shapes.size();
		for (int i=n-1; i >= 0; i--) {
			_shapes.remove(i);
		}
	}
}
