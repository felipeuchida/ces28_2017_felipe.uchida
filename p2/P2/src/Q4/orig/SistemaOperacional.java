package Q4.orig;

public class SistemaOperacional {
	private Impressora impressora;
	public SistemaOperacional(Impressora impressora){
		this.impressora = impressora;
	}
	
	public void getDriverImpressao(String conteudo) {
		//CÓDIGO DO VERIFICA
		//Verifica tipo de impressora e depois imprime
		//A classe impressora é abstrata, o objeto Impressora é do tipo impressoraFilhaX
		//Onde X é o tipo de impressora
		impressora.Imprimir(conteudo);
	}
}
