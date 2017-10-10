package mercadoVirtual;

public class Mercado {
	private BancoDeDados banco = new BancoDeDados();;
	
	public int registrarComprador(String nome, int idCliente){
		// registrar comprador
		Cliente cliente = Cliente.create(nome, idCliente);
		Carrinho car = Carrinho.create();
		cliente.adicionarCarrinho(car);
		banco.registrarCliente(cliente);
		
		return idCliente;
	}
	
	public void registrarCompra(int idProduto, int idCliente){
		Cliente cliente = banco.selectCliente(idCliente);
		// realizar uma compra
		Produto produto = banco.selectProduto(idProduto);
		cliente.getCarrinho().adicionar(produto);
	}
	
	public void fecharCompra(int idCliente){
		Cliente cliente = banco.selectCliente(idCliente);
		// fechar compra
		double valor = cliente.getCarrinho().getTotal();
		banco.processarPagamento(cliente, valor);
	}
}
