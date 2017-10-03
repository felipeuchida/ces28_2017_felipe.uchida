package Exercicio1;
import java.lang.Thread;

public class MyThread  extends Thread {
	private Application app1;
	public void run() {
		app1 = Application.getApplication();
	}
	public Application getApp() {
		return app1;
	} 
}
