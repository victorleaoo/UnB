package controle;

import modelo.Funcionario;

/**
 * Classe de Controle da classe Funcion�rio. Possui os principais m�todos relacionados a essa classe, como por exemplo: listar os nomes, inserir, editar ou remover funcion�rios.
 * @author mixer
 * @version 1.0 (Out. 2021)
 */
public class ControleFunc extends ControleDados {
	
	private Funcionario[] funcs;
	private int qtdFuncionarios;
	
	/**
	 * Construtor de ControleFunc:
	 * (1) O array de Funcion�rios ser� os funcion�rios atribu�dos � lista de Funcion�rios.
	 * (2) A quantidade ser� setada pela quantidade de elementos no array de Funcion�rios.
	 */
	public ControleFunc() {
		super();
		funcs = this.getLista();
		this.setQtd(super.getQtdeLista(funcs));
	}
	
	/**
	 * M�todo que retorna um array (lista) contendo os funcion�rios cadastrados no software.
	 * @return Funcionario[]
	 */
	@Override
	public Funcionario[] getLista() {
		return super.getDados().getdFuncs();
	}
	
	/**
	 * Cria um array com os nomes dos funcion�rios. Ser� usado na camada view para listar os funcion�rios cadastrados.
	 * @return Array de String com o nome de cada funcion�rio.
	 */
	public String[] getNomeFuncs() {
		String[] s = new String[qtdFuncionarios];
		for(int i = 0; i < qtdFuncionarios; i++) {
			s[i] = funcs[i].getNome();
		}
		
		return s;
	}
	
	public int getQtd() {
		return qtdFuncionarios;
	}

	public void setQtd(int qtd) {
		this.qtdFuncionarios = qtd;
	}
	
	public String getNome(int i) {		
		return funcs[i].getNome();
	}
	
	public String getTelefone(int i) {		
		return funcs[i].getTelefone();
	}
	
	public String getID(int i) {
		String IdFunc = String.valueOf(funcs[i].getIdFunc());
		return IdFunc;
	}
	
	public String getSalario(int i) {
		return String.valueOf(funcs[i].getSalario());
	}
	
	public String getAnoIng(int i) {
		String AnoIng = String.valueOf(funcs[i].getAnoIngresso());
		return AnoIng;
	}
	
	/**
	 * M�todo que insere um novo funcion�rio cadastrado. Com isso, o n�mero de funcion�rios � acrescido em 1.
	 * @param dadosFunc -> Um array de String com os dados do novo Funcion�rio a ser inserido.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o funcion�rio tenha sido inserido com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao inserir o funcion�rio, provavelmente algum dado com tipo ou valor inv�lido.
	 */
	@Override
	public boolean inserir(String[] dadosFunc) {
		if(editar(dadosFunc)) {
			setQtd(getQtd()+1);	
			return true;
		} 
		return false;
	}
	
	/**
	 * M�todo que edita os dados de um Funcion�rio.
	 * @param dadosFunc -> Um array de String com os novos dados do Funcion�rio a ser editado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o funcion�rio tenha sido editado com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao editar o funcion�rio, provavelmente algum dado com tipo ou valor inv�lido.
	 */
	@Override
	public boolean editar(String[] dadosFunc) {	
		if(Servicos.validaIDFunc(Integer.valueOf(dadosFunc[3])) && Servicos.validaDouble(Double.valueOf(dadosFunc[4])) && Servicos.validaAnoIng(Integer.valueOf(dadosFunc[5]))) {
			Funcionario f = new Funcionario(dadosFunc[1], dadosFunc[2], Integer.valueOf(dadosFunc[3]), Double.valueOf(dadosFunc[4]), Integer.valueOf(dadosFunc[5]));
			getDados().inserirEditaFunc(f, Integer.parseInt(dadosFunc[0]));
			return true;
		}
		return false;
	}

	/**
	 * M�todo que remove um Funcion�rio. Com isso, o n�mero de funcion�rios � reduzido em 1 e as posi��es dos funcion�rios ajustadas.
	 * @param i -> Posi��o do funcion�rio a ser removido.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o funcion�rio tenha sido removido com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao remover o funcion�rio, provavelmente o usu�rio n�o tenha dado o refresh ap�s alguma altera��o na lista.
	 */
	@Override
	public boolean remover(int i) {
		if(i > getQtd()) {
			return false;
		}

		funcs = getDados().getdFuncs();
		String funcRemovido = funcs[i].getNome();
		
		if(i == (getQtd() -1)) { //Se o funcion�rio a ser removido est� no final do array
			funcs[i] = null;
			setQtd(getQtd() -1);
			return true;
		} 
		
		int cont = 0;
		while(funcs[cont].getNome().compareTo(funcRemovido) != 0) {
			cont++;
		} 
		
		for (int j = cont; j < getQtd() - 1; j++) {
			funcs[j] = funcs[j+1];
		}
		funcs[getQtd()] = null;
		setQtd(getQtd() - 1);
		return true;
	}
	
}
