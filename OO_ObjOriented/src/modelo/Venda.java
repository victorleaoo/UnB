package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe modelo de Venda. Possui seus atributos, construtor e gets/sets.
 * Caso de Agrega��o
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */

public class Venda implements Model {

	/**
	 * Atributos de Venda.
	 */
	private char metPag; // 'C'/'c' para Cart�o - 'B'/'b' para Boleto - 'P'/'p' para Pix
	private Funcionario f;
	private Cliente c; 
	private List<ItensVenda> sapatos;
	private int id;
	
	/**
	 * Construtor de Venda.
	 * @param mP -> Char contendo met�do de pagamento da Venda:
	 * (1) 'C'/'c' para Cart�o
	 * (2) 'B'/'b' para Boleto
	 * (3) 'P'/'p' para Pix
	 * @param fun-> Funcionario contendo funcion�rio respons�vel pela Venda.
	 * @param cli-> Cliente contendo cliente que comprou a Venda.
	 * @param ID -> Int contendo ID da Venda.
	 */
	public Venda(char mP, Funcionario fun, Cliente cli, int ID) {
		metPag = mP;
		f = fun;
		c = cli;
		sapatos = new ArrayList<>();
		id = ID;
	}

	public char getMetPag() {
		return metPag;
	}
	public void setMetPag(char metPag) {
		this.metPag = metPag;
	}

	public Funcionario getF() {
		return f;
	}
	public void setF(Funcionario f) {
		this.f = f;
	}

	public Cliente getC() {
		return c;
	}
	public void setC(Cliente c) {
		this.c = c;
	}

	public List<ItensVenda> getSapatos() {
		return sapatos;
	}
	public void setSapatos(List<ItensVenda> sapatos) {
		this.sapatos = sapatos;
	}
	
	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}
	
	/**
	 * Adiciona um item � lista de Itens da Venda.
	 * @param s -> ItensVenda contendo o item a ser adicionado � lista de itens da Venda.
	 */
	public void addItem(ItensVenda s) {
		s.getS().setQntdEstoque(s.getS().getQntdEstoque() - s.getQntdVenda());
		sapatos.add(s);
	}
	
	/**
	 * Deleta um item da Venda.
	 * @param s -> ItensVenda contendo o item a ser deletado da Venda. 
	 */
	public void deletarItem(ItensVenda s) {
		sapatos.remove(s);
	}

	/**
	 * Fun��o para implementar a interface Model (n�o � realmente usada no programa).
	 * @return String
	 */
	@Override
	public String getModel() {
		return "ID";
	}
	
}
