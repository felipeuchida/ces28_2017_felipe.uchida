package Exercicio1;
public class ApplicationTest {
	public static void main(String[] args) throws InterruptedException {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		if (t1.getApp() == t2.getApp())
			System.out.println ("Same instance");
		else
			System.out.println ("Different instances");
	}
}
