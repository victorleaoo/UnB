package modelo;

/**
 * Classe modelo de Cliente e filha de PessoaFisica. Possui seus atributos, construtor e gets/sets.
 * Caso de Heran�a
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */

public class Cliente extends PessoaFisica implements Model {
	
	/**
	 * Atributos de Cliente.
	 */
	private String email;
	private String endCliente;
	
	/**
	 * Construtor de Cliente.
	 * @param nP -> String contendo nome do Cliente.
	 * @param t  -> String contendo telefone do Cliente. 
	 * @param em -> String contendo e-mail do Cliente.
	 * @param eC -> String contendo endere�o do Cliente.
	 */
	public Cliente(String nP, String t, String em, String eC) {
		nome = nP;
		telefone = t;
		email = em;
		endCliente = eC;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndCliente() {
		return endCliente;
	}
	public void setEndCliente(String endCliente) {
		this.endCliente = endCliente;
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
