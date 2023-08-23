package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleFunc;

/**
 * Tela que apresenta os dados do Funcion�rio (vazios ou preenchidos dependendo do selecionado na TelaFuncionario). Pode-se alterar os dados do Funcion�rio ou exclu�-lo.
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */

public class TelaDetalheFunc implements ActionListener {
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelID = new JLabel("Id do Funcion�rio: ");
	private JTextField valorID;
	private JLabel labelSalario = new JLabel("Sal�rio (em reais): ");
	private JTextField valorSalario;
	private JLabel labelAnoIng = new JLabel("Ano de Ingresso: ");
	private JTextField valorAnoIng;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleFunc dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Design dos elementos da tela.
	 * @param op -> Op��o:
	 * (1) Cadastro de Funcion�rio: Os campos que deveriam conter os dados estar�o vazios, esperando os dados de cadastro do novo Funcion�rio.
	 * (2) Detalhe de Funcion�rio: Os campos estar�o preenchidos com dados do Funcion�rio selecionado na lista. O bot�o de excluir estar� dispon�vel.
	 * @param d  -> Dados de Funcion�rio.
	 * @param f  -> TelaFuncionario (no caso, a �nica que o programa possui).
	 * @param pos-> Posi��o do Funcion�rio selecionado no array de funcion�rios.
	 */
	public void inserirEditar(int op, ControleFunc d, TelaFuncionario f, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) s = "Cadastro de Funcion�rio";
		if (op == 2) s = "Detalhe de Funcion�rio";
		
		janela = new JFrame(s);
		
		if (op == 2) { //Preenche dados com dados do funcion�rio clicado
			
			valorNome = new JTextField(dados.getLista()[pos].getNome(), 200);
			valorTelefone = new JTextField(dados.getLista()[pos].getTelefone(),200);
			valorID = new JTextField(String.valueOf(dados.getLista()[pos].getIdFunc()), 200);
			valorSalario = new JTextField(String.valueOf(dados.getLista()[pos].getSalario()),200);
			valorAnoIng = new JTextField(String.valueOf(dados.getLista()[pos].getAnoIngresso()),4);
			
		} else { //N�o preenche com dados

			valorNome = new JTextField(200);
			valorTelefone = new JTextField(200);
			valorID = new JTextField(200);
			valorSalario = new JTextField(200);
			valorAnoIng = new JTextField(4);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		labelTelefone.setBounds(30, 50, 150, 25);
		valorTelefone.setBounds(180, 50, 180, 25);	
		labelID.setBounds(30, 80, 150, 25);
		valorID.setBounds(180, 80, 180, 25);	
		labelSalario.setBounds(30, 110, 150, 25);
		valorSalario.setBounds(180, 110, 180, 25);	
		labelAnoIng.setBounds(30, 140, 150, 25);
		valorAnoIng.setBounds(180, 140, 180, 25);
		
		//Coloca botoes de excluir e salvar
		if (op == 2) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}
		
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelTelefone);
		this.janela.add(valorTelefone);
		this.janela.add(labelID);
		this.janela.add(valorID);
		this.janela.add(labelSalario);
		this.janela.add(valorSalario);
		this.janela.add(labelAnoIng);
		this.janela.add(valorAnoIng);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);
		janela.setLocationRelativeTo(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			try {
				boolean res;				
				novoDado[1] = valorNome.getText();
				novoDado[2] = valorTelefone.getText();
				novoDado[3] = valorID.getText();
				novoDado[4] = valorSalario.getText();
				novoDado[5] = valorAnoIng.getText();
				if(opcao == 1) { //Cadastro de novo funcionario
					novoDado[0] = Integer.toString(dados.getQtd());
					res = dados.inserir(novoDado);
				}
				else { //Edi��o de funcion�rio				
					novoDado[0] = Integer.toString(posicao);
					res = dados.editar(novoDado);
				}
												
				if(res) {
					mensagemSucessoCadastro();
				} else mensagemErroCadastro();
			}
			catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}
		
		
		if(src == botaoExcluir) { 
			boolean res = false;
		 
		//exclui cliente
			res = dados.remover(posicao);
			if (res) mensagemSucessoExclusao(); 
			else mensagemErroExclusao(); 
		}
		
	}
	
	/**
	 * Mensagem de Sucesso de cadastro.
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Mensagem de Sucesso de exclus�o.
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Mensagem de Erro de cadastro.
	 * Aparece caso todos os campos n�o estejam preenchidos ou dado(s) com tipos inv�lidos.
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n " + "Nem todos os campos foram preenchidos OU \n"
	+ "Dados com tipos inv�lidos", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Mensagem de Erro de exclus�o
	 */
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n"+ 
							"D� o refresh antes de excluir o pr�ximo funcion�rio.", null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
