package br.unipe.cc.agenda.gui.janelas;

import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.MaskFormatter;

import br.unipe.cc.agenda.fachada.AgendaFachada;
import br.unipe.cc.agenda.gui.funcoes.G;

public class JanelaContato implements ActionListener {
	AgendaFachada agenda;
	JFrame janelaContato = new JFrame();

	JPanel painelNome = new JPanel();
	JPanel painelTelefone = new JPanel();
	JPanel painelBotoes = new JPanel();

	JLabel textoNome = new JLabel();
	JLabel textoTelefone = new JLabel();

	JTextField campoNome = new JTextField();
	JTextField campoTelefone = new JTextField();
	MaskFormatter mascaraDeTelefone;

	JButton botaoConfirmar = new JButton();
	JButton botaoRetornar = new JButton();

	/**
	 * 
	 * usada para manipular os dados da agenda
	 * 
	 * @param agenda
	 */
	public JanelaContato(AgendaFachada agenda) {
		this.agenda = agenda;

	}

	/**
	 * usado para definir todas as configuraçoes da janela
	 * 
	 * @param titulo
	 */
	void preparaJanela(String titulo) {

		janelaContato.setSize(465, 150);
		janelaContato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaContato.setLayout(new GridLayout(3, 1));
		janelaContato.setResizable(false);
		janelaContato.setLocationRelativeTo(null);
		janelaContato.setTitle(titulo);
		janelaContato.setVisible(true);

	}

	/**
	 * usado para preparar o painel que contem o label e textfield refente ao
	 * nome
	 * 
	 */
	void preparaNome() {
		painelNome.setLayout(new FlowLayout(FlowLayout.LEFT));
		textoNome.setText("Nome:");
		campoNome.setColumns(35);
		campoNome.setToolTipText("Informe nome do contato.");

		painelNome.add(textoNome);
		painelNome.add(campoNome);
		janelaContato.add(painelNome);
		campoNome.addActionListener(this);
	}

	/**
	 * usado para preparar o painel que contem o label e textfield refente ao
	 * telefone
	 * 
	 */

	void preparaTelefone() {
		painelTelefone.setLayout(new FlowLayout(FlowLayout.LEFT));
		textoTelefone.setText("Telefone:");
		try {
			mascaraDeTelefone = new MaskFormatter("####-####");
			campoTelefone = new JFormattedTextField(mascaraDeTelefone);
		} catch (Exception e) {
		}
		campoTelefone.setColumns(8);
		campoTelefone.setToolTipText("Informe Telefone do contato.");
		painelTelefone.add(textoTelefone);
		painelTelefone.add(campoTelefone);
		janelaContato.add(painelTelefone);
		campoTelefone.addActionListener(this);
	}

	/**
	 * usado para preparar o painel que contem os botoes de confirmar e retornar
	 * 
	 */

	void preparaBotoes() {
		painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER));
		botaoConfirmar.setText("Confirmar");
		botaoRetornar.setText("Retornar");
		painelBotoes.add(botaoConfirmar);
		painelBotoes.add(botaoRetornar);
		janelaContato.add(painelBotoes);
		registraEnterNoBotao(botaoConfirmar);
		registraEnterNoBotao(botaoRetornar);
		botaoConfirmar.addActionListener(this);
		botaoRetornar.addActionListener(this);
	}

	/**
	 * usada para registrar evento do enter como o do click no botao parametro
	 * passado é o botao que recebera o registro
	 * 
	 * @param b
	 */
	private void registraEnterNoBotao(JButton b) {
		b.registerKeyboardAction(b.getActionForKeyStroke(KeyStroke
				.getKeyStroke(KeyEvent.VK_SPACE, 0, false)), KeyStroke
				.getKeyStroke(KeyEvent.VK_ENTER, 0, false),
				JComponent.WHEN_FOCUSED);

		b.registerKeyboardAction(b.getActionForKeyStroke(KeyStroke
				.getKeyStroke(KeyEvent.VK_SPACE, 0, true)), KeyStroke
				.getKeyStroke(KeyEvent.VK_ENTER, 0, true),
				JComponent.WHEN_FOCUSED);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(campoNome))
			validarNome();
		if (e.getSource().equals(campoTelefone))
			validarTelefone();
		if (e.getSource().equals(botaoRetornar))
			janelaContato.dispose();

	}

	/**
	 * 
	 * 
	 * @return valida se nome esta em branco
	 */
	public boolean validarNome() {
		boolean retorno = campoNome.getText().isEmpty();
		if (retorno) {
			G.msgAlert("Nome em Branco", "Alerta");
			campoNome.grabFocus();
		}
		return !retorno; // nao vazio
	}

	/**
	 * 
    *@return valida se telefone esta em branco
	 */
	public boolean validarTelefone() {
		String conteudoCampoTelefone = campoTelefone.getText().replaceAll(" ",
				"");
		conteudoCampoTelefone = conteudoCampoTelefone.replaceAll("-", "");
		boolean retorno = conteudoCampoTelefone.isEmpty();
		if (retorno) {
			G.msgAlert("Telefone em Branco", "Alerta");
			campoTelefone.grabFocus();
		}
		return !retorno; // nao vazio
	}

}
