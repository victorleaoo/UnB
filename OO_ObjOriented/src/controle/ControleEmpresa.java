package controle;

import modelo.Empresa;

/**
 * Classe de Controle da classe Empresa. Possui os principais m�todos relacionados a essa classe, como por exemplo: inserir, editar ou remover a empresa.
 * Lembrando que s� � poss�vel uma empresa estar cadastrada por vez no programa.
 * @author mixer
 * @version 1.0 (Out. 2021)
 */
public class ControleEmpresa extends ControleDados {

	private Empresa empresa;
	private int qtdEmpresa;
	
	/**
	 * Construtor de ControleEmpresa:
	 * (1) A empresa ser� aquela �nica cadastrada no programa.
	 * (2) A quantidade ser� 1 ou 0, dependendo se h� empresa cadastrada ou n�o.
	 */
	public ControleEmpresa() {
		super();
		empresa = this.getEmpresa();
		this.setQtd(empresa != null ?  1 : 0);
	}
	
	/**
	 * M�todo que retornaria um array (lista) contendo as empresas cadastradas no software, entretanto s� h� uma empresa cadastrada por vez.
	 * @return null -> No caso, s� h� uma empresa no programa.
	 */
	@Override
	public Empresa[] getLista()  {
		return null;
	}
	
	public Empresa getEmpresa() {
		return this.getDados().getdEmpresa();
	}
	
	public String getNomeEmpresa() {
		return empresa.getNomeEmpresa();
	}
	
	public int getQtd() {
		return qtdEmpresa;
	}
	
	public void setQtd(int qtd) {
		this.qtdEmpresa = qtd;
	}

	public String getCNPJ() {
		return empresa.getCNPJ();
	}
	
	public String getAnoFund() {
		String AnoFund = String.valueOf(empresa.getAnoFund());
		return AnoFund;
	}

	public String getTelEmpresa() {
		return empresa.getTelEmpresa();
	}

	public String getEndEmpresa() {
		return empresa.getEndEmpresa();
	}
	
	/**
	 * M�todo que cadastra/insere a Empresa.
	 * @param dados ->  Um array de String com os dados da nova Empresa a ser inserida.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a empresa tenha sido inserida com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao inserir a empresa, provavelmente ano de funda��o inv�lido.
	 */
	@Override
	public boolean inserir(String[] dados) {
		return editar(dados);
	}
	
	/**
	 * M�todo que edita os dados de uma Empresa.
	 * @param dadosEmpresa -> Um array de String com os novos dados da Empresa a ser editada.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a empresa tenha sido editada com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao editar a empresa, provavelmente ano de funda��o inv�lido.
	 */
	@Override
	public boolean editar(String[] dadosEmpresa) {
		if(Servicos.validaAnoFund(Integer.valueOf(dadosEmpresa[3]))) {
			Empresa e = new Empresa(dadosEmpresa[1], dadosEmpresa[2], Integer.valueOf(dadosEmpresa[3]), dadosEmpresa[4], dadosEmpresa[5]);
			getDados().inserirEditaEmpresa(e);
			return true;
		}
		return false;
	}

	/**
	 * M�todo que remove a Empresa.
	 * @param i -> "Posi��o" da empresa a ser removida. O par�metro n�o � usado para empresa.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a empresa tenha sido removida com sucesso (n�o h� motivo de erro, uma vez que s� h� uma empresa cadastrada).
	 */
	@Override
	public boolean remover(int i) {
		getDados().inserirEditaEmpresa(null);
		return true;
	}
}
