package br.unipe.cc.agenda.gui.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.unipe.cc.agenda.fachada.AgendaFachada;
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
		if (e.getSource() == campoNome) {
			botaoConfirmar.grabFocus();
		}
		if (e.getSource() == botaoConfirmar) {
			if (agenda.removerContato(new Contato(campoNome.getText(),""))){
				JOptionPane.showMessageDialog(null, "Contato Removido!", "Informação", JOptionPane.INFORMATION_MESSAGE);
				janelaContato.dispose();
			}
			else
				JOptionPane.showMessageDialog(null, "Contato não encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
		}
		if (e.getSource() == botaoRetornar)
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
