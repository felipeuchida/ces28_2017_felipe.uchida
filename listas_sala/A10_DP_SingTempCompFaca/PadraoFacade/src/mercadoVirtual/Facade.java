package mercadoVirtual;

public class Facade {
	Mercado mercado;
	public Facade(){
		mercado = new Mercado();
	}
	
	public int registrarComprador(String nome, int idCliente){
		return mercado.registrarComprador(nome, idCliente);
	}
	
	public void registrarCompra(int idProduto, int idCliente){
		mercado.registrarCompra(idProduto, idCliente);
	}
	
	public void fecharCompra(int idCliente){
		mercado.fecharCompra(idCliente);
	}
}
