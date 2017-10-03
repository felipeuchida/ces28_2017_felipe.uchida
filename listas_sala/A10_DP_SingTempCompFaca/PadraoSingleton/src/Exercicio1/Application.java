package Exercicio1;
public class Application {

	// ---------- Constructor --------------------
	private     Application() {
		//  Construct object 
		// …
	}    // constructor: Application

	// ---------- Operations --------------------
	// For lazy initialization
	public static synchronized Application getApplication() {
		if (! instanceFlag) {
			return create();
		} else {
			return _theApplication;
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
		instanceFlag = true;
		return _theApplication;
	}    // method: create

	protected void finalize() throws Throwable {
		try {
			instanceFlag = false;        // free new singleton instance!
		} finally {
			super.finalize();
		}
	}    // method: finalize

	// Others methods protected by singleton-ness would be here
	// …

	// ---------- Attributes --------------------  
	//private static final Application _theApplication = null;
	private static Application _theApplication = null;
	private static Boolean instanceFlag = false;

}    // class: Application
