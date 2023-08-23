package controle;

import java.util.List;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.ItensVenda;
import modelo.Venda;

/**
 * Classe de Controle da classe Venda. Possui os principais m�todos relacionados a essa classe e a ItensVenda, como por exemplo: listar os nomes, inserir, editar ou remover vendas e itens dessas vendas.
 * @author mixer
 * @version 1.0 (Out. 2021)
 */
public class ControleVenda extends ControleDados {
	
	private Venda[] vnd;
	private int qtdVendas;
	
	/**
	 * Construtor de ControleVenda:
	 * (1) O array de Vendas ser� as vendas atribu�dos � lista de Vendas.
	 * (2) A quantidade ser� setada pela quantidade de elementos no array de Vendas.
	 */
	public ControleVenda() {
		super();
		vnd = this.getLista();
		this.setQtd(super.getQtdeLista(vnd));
	}
	
	/**
	 * M�todo que retorna um array (lista) contendo as vendas cadastradas no software.
	 * @return Venda[]
	 */
	@Override
	public Venda[] getLista() {
		return super.getDados().getdVendas();
	}
	
	/**
	 * Cria um array com os nomes dos funcion�rios respons�veis pelas vendas, clientes que compraram e IDs das vendas. Ser� usado na camada view para listar as vendas cadastradas.
	 * @return Array de String com o seguinte formato:
	 * (1) Fulano - Funcion�rio            Ciclano - Cliente            - ID: X
	 */
	public String[] getNomeVendas() {
		String[] v = new String[qtdVendas];
		for(int i = 0; i < qtdVendas; i++) {
			v[i] = vnd[i].getF().getNome() + " - Funcion�rio           " + vnd[i].getC().getNome() + " - Cliente           - ID: " + vnd[i].getID();
		}
		
		return v;
	}
	
	/**
	 * Cria um array com os nomes dos itens de uma venda, mais especificamente o nome dos sapatos. Ser� usado na camada view para listar os itens cadastrados de uma venda.
	 * @param List<ItensVenda> sapatos 
	 * -> Uma lista com os itens cadastrados de uma venda.
	 * @return Array de String com o nome de cada sapato na lista de ItensVenda de uma Venda espec�fica.
	 */
	public String[] getNomeItens(List<ItensVenda> sapatos) {
		String[] s = new String[sapatos.size()];
		for(int i = 0; i < sapatos.size(); i++) {
			s[i] = sapatos.get(i).getS().getNomeSapato();
		}		
		return s;
	}
	
	public int getQtd() {
		return qtdVendas;
	}

	public void setQtd(int qtd) {
		this.qtdVendas = qtd;
	}
	
	public Cliente getCliente(int i) {
		return vnd[i].getC();
	}
	
	public Funcionario getFuncionario(int i) {
		return vnd[i].getF();
	}
	
	public char getMetPag(int i) {
		return vnd[i].getMetPag();
	}
	
	public List<ItensVenda> getItens(int i){
		return vnd[i].getSapatos();
	}
	
	public int getIDVenda(int i) {
		return vnd[i].getID();
	}

	/**
	 * M�todo que insere uma nova venda cadastrada. Com isso, o n�mero de vendas � acrescido em 1.
	 * @param dadosVenda -> Um array de String com os dados da nova Venda a ser inserida (os Itens da Venda s�o cadastrados posteriormente).
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a venda tenha sido inserida com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao inserir a venda, provavelmente funcion�rio ou cliente n�o encontrado ou m�todo de pagamento inv�lido.
	 */
	@Override
	public boolean inserir(String[] dadosVenda) {		
		if(editar(dadosVenda)) {
			setQtd(getQtd()+1);			
			return true;
		}
		return false;
	}

	/**
	 * M�todo que edita os dados de uma Venda. Se certifica que o Funcion�rio e o Cliente digitados existem no programa.
	 * @param dadosVenda -> Um array de String com os novos dados da Vemda a ser editada.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a venda tenha sido editada com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao inserir a venda, provavelmente funcion�rio ou cliente n�o encontrado ou m�todo de pagamento inv�lido.
	 */
	@Override
	public boolean editar(String[] dadosVenda) {
		Funcionario funcVenda = null;
		for(Funcionario func : getDados().getdFuncs()) {
			if(dadosVenda[2].equals(func.getNome())) {
				funcVenda = func;
				break;
			}
		}
		Cliente clienteVenda = null;
		for(Cliente cli : getDados().getdClientes()) {
			if(dadosVenda[3].equals(cli.getNome())) {
				clienteVenda = cli;
				break;
			}
		}
		
		if(Servicos.validaMetPag(dadosVenda[1].charAt(0))){
			Venda v = new Venda(dadosVenda[1].charAt(0), funcVenda, clienteVenda, Integer.valueOf(dadosVenda[4]));
			getDados().inserirEditaVenda(v, Integer.parseInt(dadosVenda[0]));
			return true;
		}
		
		return false;

	}

	/**
	 * M�todo que remove uma Venda. Com isso, o n�mero de vendas � reduzido em 1 e as posi��es das vendas ajustadas.
	 * @param i -> Posi��o da venda a ser removida.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a venda tenha sido removida com sucesso.
	 * (2) False/Falso: caso ocorra um erro ao remover a venda, provavelmente o usu�rio n�o tenha dado o refresh ap�s alguma altera��o na lista.
	 */
	@Override
	public boolean remover(int i) {
		if(i > getQtd()) {
			return false;
		}

		vnd = getDados().getdVendas();
		int vendaRemovida = vnd[i].getID();
		
		if(i == (getQtd() -1)) { //Se o funcion�rio a ser removido est� no final do array
			vnd[i] = null;
			setQtd(getQtd() -1);
			return true;
		} 
		
		int cont = 0;
		while(String.valueOf(vnd[cont].getID()).compareTo(String.valueOf(vendaRemovida)) != 0) {
			cont++;
		} 
		
		for (int j = cont; j < getQtd() - 1; j++) {
			vnd[j] = vnd[j+1];
		}
		vnd[getQtd()] = null;
		setQtd(getQtd() - 1);
		return true;
	}
	
	/**
	 * Adiciona um item � lista de Itens da Venda. Al�m de atualizar o estoque (diminuir a quantidade vendida).
	 * @param s -> Item a ser adicionado na venda.
	 * @param i -> Posi��o da venda em que o item vai ser adicionado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso a quantidade vendida seja menor que a quantidade em estoque e o item adicionado com sucesso.
	 * (2) False/Falso: caso a quantidade vendida seja maior que a quantidade em estoque. Logo, o item n�o ser� adicionado.
	 */
	public boolean addItem(ItensVenda s, int i) {
		if(s.getQntdVenda() > s.getS().getQntdEstoque()) {
			return false;
		}
		s.getS().setQntdEstoque(s.getS().getQntdEstoque() - s.getQntdVenda());
		vnd[i].getSapatos().add(s);
		return true;
	}
	
	/**
	 * Deleta um item da Venda. Al�m de atualizar o estoque (aumentar a quantidade do item exclu�do).
	 * @param s -> Item a ser exclu�do.
	 * @param i -> Posi��o da venda do item a ser exclu�do.
	 */
	public void deletarItem(ItensVenda s, int i) {
		s.getS().setQntdEstoque(s.getS().getQntdEstoque() + s.getQntdVenda());
		vnd[i].getSapatos().remove(s);
	}
}
