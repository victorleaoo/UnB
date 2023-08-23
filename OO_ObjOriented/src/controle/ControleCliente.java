package controle;

import modelo.Cliente;

/**
 * Classe de Controle da classe Cliente. Possui os principais m�todos relacionados a essa classe, como por exemplo: listar os nomes, inserir, editar ou remover clientes.
 * @author mixer
 * @version 1.0 (Out. 2021)
 */

public class ControleCliente extends ControleDados {

	private Cliente[] cli;
	private int qtdClientes;
	
	/**
	 * Construtor de ControleCliente:
	 * (1) O array de Clientes ser� os clientes atribu�dos � lista de Clientes.
	 * (2) A quantidade ser� setada pela quantidade de elementos no array de Clientes.
	 */
	public ControleCliente() {
		super();
		cli = this.getLista();
		this.setQtd(super.getQtdeLista(cli));		
	}

	/**
	 * M�todo que retorna um array (lista) contendo os clientes cadastrados no software.
	 * @return Cliente[]
	 */
	@Override
	public Cliente[] getLista() {	
		return super.getDados().getdClientes();
	}
	
	/**
	 * Cria um array com os nomes dos clientes. Ser� usado na camada view para listar os clientes cadastrados.
	 * @return Array de String com o nome de cada cliente.
	 */
	public String[] getNomeClientes() {
		String[] s = new String[getQtd()];
		for(int i = 0; i < getQtd(); i++) {
			s[i] = cli[i].getNome();
		}		
		return s;
	}
	
	public int getQtd() {
		return qtdClientes;
	}

	public void setQtd(int qtd) {
		this.qtdClientes = qtd;
	}
	
	public String getNome(int i) {		
		return cli[i].getNome();
	}
	
	public String getTelefone(int i) {
		return cli[i].getTelefone();
	}
	
	public String getEmail(int i) {
		return cli[i].getEmail();
	}
	
	public String getEndereco(int i) {
		return cli[i].getEndCliente();
	}
	
	/**
	 * M�todo que insere um novo cliente cadastrado. Com isso, o n�mero de clientes � acrescido em 1.
	 * @param dadosCliente -> Um array de String com os dados do novo Cliente a ser inserido.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o cliente tenha sido inserido com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao inserir o cliente, provavelmente e-mail com formato incorreto.
	 */
	@Override
	public boolean inserir(String[] dadosCliente) {
		if(editar(dadosCliente)) {
			setQtd(getQtd()+1);
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que edita os dados de um Cliente.
	 * @param dadosCliente -> Um array de String com os novos dados do Cliente a ser editado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o cliente tenha sido editado com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao editar o cliente, provavelmente e-mail com formato incorreto.
	 */
    @Override
    public boolean editar(String[] dadosCliente) {
    	if(Servicos.validaEmail(dadosCliente[3])) {
    		Cliente c = new Cliente(dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
    		getDados().inserirEditaCliente(c, Integer.parseInt(dadosCliente[0]));
    		return true;
    	}
    	return false;
	}

	/**
	 * M�todo que remove um Cliente. Com isso, o n�mero de clientes � reduzido em 1 e as posi��es dos clientes ajustadas.
	 * @param i -> Posi��o do cliente a ser removido.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o cliente tenha sido removido com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao remover o cliente, provavelmente o usu�rio n�o tenha dado o refresh ap�s alguma altera��o na lista.
	 */
	@Override
	public boolean remover(int i) {
		if(i > getQtd()) {
			return false;
		}
		
		cli = this.getLista();
		String clienteRemovido = cli[i].getNome();
				
		if(i == (getQtd() -1)) { //Se o cliente a ser removido est� no final do array
			cli[i] = null;
			setQtd(getQtd() -1);
			return true;
		}
		
		int cont = 0;
		while(cli[cont].getNome().compareTo(clienteRemovido) != 0) {
			cont++;
		} 
		
		for (int j = cont; j < getQtd() - 1; j++) {
			cli[j] = cli[j+1];
		}
		cli[getQtd()-1] = null;
		setQtd(getQtd() - 1);
		
		return true;
	}
}
