package notaFiscal;

public class ImpostoFoo extends Imposto {
	public ImpostoFoo(Double aliquota_default) {
		_aliquota_default = aliquota_default;
		_nome = "Foo";
	}
	
	@Override												// requisito 9
	public double gerarImposto(ItemVenda IV) {
		if(IV.getPSName() == "Lollipop") {			// imposto para pirulito é 10% maior que para outros produtos
			return _aliquota_default + 0.1;
		}
		return _aliquota_default;
//		return 0.0;
	}
}
