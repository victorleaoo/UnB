package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.ControleFunc;

/**
 * Tela que lista os funcion�rios. Pode-se selecionar algum Funcion�rio na lista para o alterar ou excluir. Tamb�m h� o bot�o de cadastro e o de refresh da lista.
 * @author Victor Le�o
 * @version 1.0 (Out. 2021)
 */

public class TelaFuncionario implements ActionListener, ListSelectionListener {
	private JFrame janela = new JFrame("Funcion�rios");
	private JLabel titulo = new JLabel("Controle de Funcion�rios");
	private JButton cadastrarFunc = new JButton("Cadastrar Funcion�rio");
	private JButton refresh = new JButton("Refresh");
	public static ControleFunc dados;
	private JList<String> listaFuncCadastrados;
	private String[] listaNomesFuncs = new String[50];
	
    /**
     * Design dos elementos da Tela.
     */
	
	public void mostrarFuncionarios() {
		dados = new ControleFunc();
		
		listaNomesFuncs = dados.getNomeFuncs();
		listaFuncCadastrados = new JList<String>(listaNomesFuncs);
		
		titulo.setFont(new Font("Helvetica", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaFuncCadastrados.setBounds(20, 50, 350, 120);
		listaFuncCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaFuncCadastrados.setVisibleRowCount(10);
		
		cadastrarFunc.setBounds(70, 177, 100, 30);
		refresh.setBounds(200, 177, 100, 30);
		
		janela.setLayout(null);
		janela.setLocationRelativeTo(null);

		janela.add(titulo);
		janela.add(listaFuncCadastrados);
		janela.add(cadastrarFunc);
		janela.add(refresh);

		janela.setSize(400, 250);
		janela.setVisible(true);
		
		cadastrarFunc.addActionListener(this);
		refresh.addActionListener(this);
		listaFuncCadastrados.addListSelectionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo funcion�rio
		if(src == cadastrarFunc)
			new TelaDetalheFunc().inserirEditar(1, dados, this, 0);
		
		// Atualiza a lista de nomes de funcion�rios mostrada no JList
		if(src == refresh) {
			listaFuncCadastrados.setListData(dados.getNomeFuncs());			
			listaFuncCadastrados.updateUI();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaFuncCadastrados) {
			new TelaDetalheFunc().inserirEditar(2, dados, this, 
					listaFuncCadastrados.getSelectedIndex());
		}
		
	}
	
}
