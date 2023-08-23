package modelo;

/**
 * Classe modelo de Funcion�rio e filha de PessoaFisica. Possui seus atributos, construtor e gets/sets. 
 * Sobrecarga de M�todo + Caso de Heran�a 
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */

public class Funcionario extends PessoaFisica implements Model {

	/**
	 * Atributos de Funcion�rio.
	 */
	private int idFunc;
	private double salario;
	private int anoIngresso;
	
	/**
	 * Construtor de Funcion�rio com os atributos de PessoaFisica.
	 * @param nP -> String contendo nome do Funcion�rio.
	 * @param t  -> String contendo telefone do Funcion�rio.
	 */
	public Funcionario(String nP, String t) {
		nome = nP;
		telefone = t;
	}
	
	/**
	 * Construtor de Funcion�rio. Sobrecarga do M�todo acima.
	 * @param nP -> String contendo nome do Funcion�rio.
	 * @param t  -> String contendo telefone do Funcion�rio.
	 * @param id -> Int contendo ID do Funcion�rio.
	 * @param s  -> Double contendo sal�rio do Funcion�rio.
	 * @param ano-> Int contendo ano de ingresso na empresa do Funcion�rio
	 */
	public Funcionario(String nP, String t, int id, double s, int ano) {
		nome = nP;
		telefone = t;
		idFunc = id;
		salario = s;
		anoIngresso = ano;
	}
	
	public int getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(int idFunc) {
		this.idFunc = idFunc;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	/**
	 * Fun��o para implementar a interface Model (n�o � realmente usada no programa).
	 * @return String
	 */
	@Override
	public String getModel() {
		return nome + " - " + telefone;
	}
	
}
