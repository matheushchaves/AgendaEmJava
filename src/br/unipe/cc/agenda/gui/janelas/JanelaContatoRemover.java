package br.unipe.cc.agenda.gui.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.unipe.cc.agenda.fachada.AgendaFachada;
import br.unipe.cc.agenda.gui.funcoes.G;
import br.unipe.cc.agenda.modelo.Contato;

public class JanelaContatoRemover extends JanelaContato implements
		ActionListener {

	public JanelaContatoRemover(AgendaFachada a) {
		super(a);
		preparaTelefone();
		preparaBotoes();
		preparaJanela("Agenda Eletronica - Remover");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean fecharJanela = e.getSource().equals(botaoRetornar); 
		if (e.getSource().equals(campoTelefone))
			validarTelefone();
		if (e.getSource().equals(botaoConfirmar)) {
			if (fecharJanela=agenda.removerContato(new Contato("", campoTelefone.getText()))) {
				G.msgInfo("Contato Removido!!!", "Informação");
			} else
				G.msgInfo("Contato não Encontrado!!!", "Informação");
		}
		if (fecharJanela)
			janelaContato.dispose();

	}

	@Override
	public boolean validarTelefone() {
		boolean retorno = super.validarTelefone();
		if (retorno)
			botaoConfirmar.grabFocus();
		return retorno;

	}

}
