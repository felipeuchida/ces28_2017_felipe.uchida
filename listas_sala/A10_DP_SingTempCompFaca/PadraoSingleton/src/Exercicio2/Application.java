package Exercicio2;
public class Application {

	// ---------- Constructor --------------------
	private     Application() {
		//  Construct object 
		// …
	}    // constructor: Application

	// ---------- Operations --------------------
	// For lazy initialization
	public static synchronized Application getApplication() throws Exception {
		if (instanceFlag<n) {
			return create();
		} else {
			throw new Exception("Limite atingido!");
		}
	}    // method: getApplication

	private static Application create() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_theApplication = new Application();
		instanceFlag++;
		return _theApplication;
	}    // method: create

	public static void defineN(int x) {
		n= x;
	}  
	
	public void remove() {
		_theApplication = null;
		instanceFlag--;   
	}
	
	protected void finalize() throws Throwable {
		try {
			instanceFlag--;        // free new singleton instance!
		} finally {
			super.finalize();
		}
	}    // method: finalize

	// Others methods protected by singleton-ness would be here
	// …

	// ---------- Attributes --------------------  
	//private static final Application _theApplication = null;
	private static Application _theApplication = null;
	private static int instanceFlag = 0;
	private static int n = 0;

}    // class: Application
