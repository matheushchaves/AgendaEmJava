package br.unipe.cc.agenda.gui.janelas;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.unipe.cc.agenda.fachada.AgendaFachada;
import br.unipe.cc.agenda.gui.funcoes.G;
import br.unipe.cc.agenda.gui.janelas.contato.*;

public class JanelaPrincipal implements ActionListener {

	private AgendaFachada agenda = new AgendaFachada();

	private JFrame janelaPrincipal = new JFrame();

	private JLabel textoTitulo = new JLabel();
	private JButton botaoAdicionar = new JButton();
	private JButton botaoAtualizar = new JButton();
	private JButton botaoRemover = new JButton();
	private JButton botaoListar = new JButton();
	private JButton botaoProcurar = new JButton();
	private JButton botaoSair = new JButton();

	private JPanel painelBotoes = new JPanel();

	public JanelaPrincipal() {
		preparaBotoes();
		preparaJanela();
	}

	private void preparaBotoes() {

		botaoAdicionar.setText("1.Adicionar");
		botaoAtualizar.setText("2.Editar");
		botaoRemover.setText("3.Remover");
		botaoListar.setText("4.Listar");
		botaoProcurar.setText("5.Procurar");
		botaoSair.setText("6.Sair");
		botaoAdicionar.addActionListener(this);
		botaoAtualizar.addActionListener(this);
		botaoRemover.addActionListener(this);
		botaoListar.addActionListener(this);
		botaoProcurar.addActionListener(this);
		botaoSair.addActionListener(this);
		painelBotoes = new JPanel(new GridLayout(6, 0));
		painelBotoes.add(botaoAdicionar);
		painelBotoes.add(botaoAtualizar);
		painelBotoes.add(botaoRemover);
		painelBotoes.add(botaoListar);
		painelBotoes.add(botaoProcurar);
		painelBotoes.add(botaoSair);

	}

	private void preparaJanela() {
		janelaPrincipal.setSize(250, 300);
		janelaPrincipal.setTitle("Agenda Eletronica");
		janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER));
		textoTitulo.setText("Agenda Eletronica Em Java");
		ImageIcon icone = new ImageIcon(G.IconePrograma);
		janelaPrincipal.setIconImage(icone.getImage());
		janelaPrincipal.add(textoTitulo);
		janelaPrincipal.add(painelBotoes);
		janelaPrincipal.setBackground(Color.WHITE);
		janelaPrincipal.setResizable(false);
		janelaPrincipal.setLocationRelativeTo(null);
		janelaPrincipal.setVisible(true);

	}

	public static void main(String[] args) {
		new JanelaPrincipal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoAdicionar) {
			new JanelaContatoAdicionar(agenda);
		}
		if (e.getSource() == botaoAtualizar) {
			new JanelaContatoAtualizar(agenda);
		}
		if (e.getSource() == botaoRemover) {
			new JanelaContatoRemover(agenda);
		}
		if (e.getSource() == botaoListar) {
			G.msgAlert("Opção em Desenvolvimento.", "Atenção");
		}
		if (e.getSource() == botaoProcurar) {
			G.msgAlert("Opção em Desenvolvimento.", "Atenção");
		}

		if (e.getSource() == botaoSair) {

			G.msgInfo("Tchau ...", "Informação");

			System.exit(0);

		}

	}

}
