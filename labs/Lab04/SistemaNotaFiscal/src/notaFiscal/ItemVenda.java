package notaFiscal;

import BD.BD_PS;

public class ItemVenda {
	private boolean _vendido;
	private ProdutoServico _PS;
	private int _quantidade;
	
	public ItemVenda(String nome, int quantidade, BD_PS bdps) throws Exception {
		_PS = bdps.getPS(nome);
		_vendido = false;
		_quantidade = quantidade;
	}
	
	public void comprar() throws Exception{
		if(_vendido) {
			throw new Exception("IV já foi vendido!");
		}
		this._vendido = true;
	}
	
	public String getPSName() {
		return _PS.getName();
	}
	
	public ProdutoServico getPS() {
		return _PS;
	}
	
	public int getQtd() {
		return _quantidade;
	}
}
