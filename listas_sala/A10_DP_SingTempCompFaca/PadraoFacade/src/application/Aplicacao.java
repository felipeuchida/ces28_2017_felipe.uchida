package application;

import mercadoVirtual.Facade;
public class Aplicacao {
	public static void main(String[] args) {
		/*BancoDeDados banco = new BancoDeDados();
		// registrar comprador
		Cliente cliente = Cliente.create("ZÈ", 123);
		Carrinho car = Carrinho.create();
		cliente.adicionarCarrinho(car);
		banco.registrarCliente(cliente);
		// realizar uma compra
		Produto produto = banco.selectProduto(223);
		cliente.getCarrinho().adicionar(produto);
		// realizar outra compra
		Produto produto2 = banco.selectProduto(342);
		cliente.getCarrinho().adicionar(produto2);
		// fechar compra
		double valor = cliente.getCarrinho().getTotal();
		banco.processarPagamento(cliente, valor);*/
		
		Facade facade = new Facade();
		int idCliente = facade.registrarComprador("ZÈ", 123);
		facade.registrarCompra(223, idCliente);
		facade.registrarCompra(342, idCliente);
		facade.fecharCompra(idCliente);
	}
}
