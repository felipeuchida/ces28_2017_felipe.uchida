package Exercicio2;
public class ApplicationTest {
	public static void main(String[] args) throws Exception {
		Application.defineN(3);
		Application app1 = Application.getApplication();
		Application app2 = Application.getApplication();
		System.out.println ("Começa");
		Application app3 = Application.getApplication();
		System.out.println ("Verifica 3");
		
		//Passo 4
		/*Application app4 = Application.getApplication();
		System.out.println ("Verifica 4");*/
		
		app3.remove();
		Application app5 = Application.getApplication();
		System.out.println ("Verifica 5");
		
	}
}
