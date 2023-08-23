package controle;

/**
 * M�todo que possui m�todos de valida��o de alguns dados das classes de Modelo.
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */
public class Servicos {
	
	/**
	 * M�todo que valida o e-mail de um cliente. Nesse caso, o e-mail deve conter o '@' e n�o pode come�ar com '@'.
	 * @param email -> E-mail a ser verificado
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o e-mail seja v�lido.
	 * (2) False/Falso: caso o e-mail seja inv�lido.
	 */
	public static boolean validaEmail(String email) {
		if(email.contains("@") && !(email.startsWith("@"))) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida o ID de um funcion�rio. Nesse caso, o ID deve ser maior ou igual a 0.
	 * @param id -> ID a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o ID seja v�lido.
	 * (2) False/Falso: caso o ID seja inv�lido.
	 */
	public static boolean validaIDFunc(int id) {
		if(id >= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida o ano de ingresso de um funcion�rio. Nesse caso, o ano deve ser maior ou igual ao ano de funda��o da empresa e menor que 2021 (ano atual).
	 * @param ano -> Ano a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o Ano seja v�lido.
	 * (2) False/Falso: caso o Ano seja inv�lido.
	 */
	public static boolean validaAnoIng(int ano) {
		ControleEmpresa dadosEmpresa;
		dadosEmpresa = new ControleEmpresa();
		if(ano >= dadosEmpresa.getEmpresa().getAnoFund() && ano <= 2021) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida o ano de funda��o de uma empresa. Nesse caso, o ano deve ter no m�nimo 4 d�gitos.
	 * @param ano -> Ano a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o Ano seja v�lido.
	 * (2) False/Falso: caso o Ano seja inv�lido.
	 */
	public static boolean validaAnoFund(int ano) {
		if(ano >= 1000) { //Ter pelo menos 4 d�gitos.
			return true;
		}
		return false;
	}

	
	/**
	 * M�todo que valida o modelo de um sapato. Nesse caso, o sapato tem que ser um dos tr�s modelos: Casual (C/c), Sand�lia (S/s) ou Esportivo (E/e).
	 * @param modelo -> Caract�r a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o Modelo seja v�lido.
	 * (2) False/Falso: caso o Modelo seja inv�lido.
	 */
	public static boolean validaModelo(char modelo) {
		if(modelo == 'C' || modelo == 'c' || modelo == 'S' || modelo == 's' || modelo == 'E' || modelo == 'e'){
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida a quantidade em estoque de um sapato a ser cadastrado.
	 * @param qtdEstoque -> Quantidade a ser verificada.
	 * @return boolean:
	 * (1) True/Verdadeiro: Caso a quantidade seja v�lida.
	 * (2) False/Falso: Caso a quantidade seja inv�lida.
	 */
	public static boolean validaEstoque(int qtdEstoque) {
		if(qtdEstoque > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida a grade de tamanhos de um sapato. Nesse caso, o sapato pode ter tamanho m�nimo de 15 e tamanho m�ximo de 46 (tamanhos comuns).
	 * @param tamanho -> Tamanho a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o Tamanho seja v�lido.
	 * (2) False/Falso: caso o Tamanho seja inv�lido.
	 */
	public static boolean validaTamanho(double tamanho) {
		if(tamanho >= 15 && tamanho <= 46) {
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida o m�todo de pagamento de uma venda. Nesse caso, a venda tem que ter um dos tr�s m�todos de pagamento: Cart�o (C/c), Boleto (B/b) ou Pix (P/p).
	 * @param metpag -> Caract�r a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o M�todo de Pagamento seja v�lido.
	 * (2) False/Falso: caso o M�todo de Pagamento seja inv�lido.
	 */
	public static boolean validaMetPag(char metpag) {
		if(metpag == 'C' || metpag == 'c' || metpag == 'B' || metpag == 'b' || metpag == 'P' || metpag == 'p'){
			return true;
		}
		return false;
	}
	
	/**
	 * M�todo que valida ser um valor double � maior que zero. Pode ser usado em mais de um caso no programa.
	 * @param valor -> Valor double a ser verificado.
	 * @return boolean:
	 * (1) True/Verdadeiro: caso o valor seja v�lido.
	 * (2) False/Falso: caso o valor seja inv�lido.
	 */
	public static boolean validaDouble(double valor) { 
		if(valor >= 0) {
			return true;
		}
		return false;
	}

}
