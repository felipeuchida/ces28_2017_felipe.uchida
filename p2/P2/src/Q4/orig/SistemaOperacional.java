package Q4.orig;

public class SistemaOperacional {
	private Impressora impressora;
	public SistemaOperacional(Impressora impressora){
		this.impressora = impressora;
	}
	
	public void getDriverImpressao(String conteudo) {
		//C�DIGO DO VERIFICA
		//Verifica tipo de impressora e depois imprime
		//A classe impressora � abstrata, o objeto Impressora � do tipo impressoraFilhaX
		//Onde X � o tipo de impressora
		impressora.Imprimir(conteudo);
	}
}
