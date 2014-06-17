package br.unipe.cc.agenda.gui.janelas.contato;

import java.awt.event.ActionEvent;


import br.unipe.cc.agenda.fachada.AgendaFachada;
import br.unipe.cc.agenda.gui.funcoes.G;
import br.unipe.cc.agenda.modelo.Contato;

public class JanelaContatoAtualizar extends JanelaContato {
	public JanelaContatoAtualizar(AgendaFachada a) {
		super(a);
		preparaNome();
		preparaTelefone();
		preparaBotoes();
		preparaJanela("Agenda Eletronica - Atualizar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		boolean fecharJanela = false;
		if (e.getSource().equals(botaoConfirmar)) {
			fecharJanela =  validarTelefone() && super.validarNome()  && agenda.atualizarContato(new Contato(campoNome.getText(), campoTelefone.getText()));
			if (fecharJanela)
				G.msgInfo("Contato Atualizado Com Sucesso.", "Informação");
		}
		if (fecharJanela)
			janelaContato.dispose();

	}

	@Override
	public boolean validarNome() {
		boolean retorno = super.validarNome();
		Contato contato = agenda.procurarContatoPorNome(new Contato(campoNome
				.getText(), ""));
		retorno = contato != null ? true : retorno;
		if (retorno) {
			if (contato != null) {
				campoTelefone.setText(contato.getTelefone());
				campoTelefone.grabFocus();
			} else {
				G.msgAlert("Nome informado não encontrado!", "Alerta");
				campoNome.setText("");
				campoNome.grabFocus();
			}
		}
		return retorno;
	}

	@Override
	public boolean validarTelefone() {
		boolean retorno = super.validarTelefone();
		if (retorno) {
			botaoConfirmar.grabFocus();
		}

		return retorno;
	}

}
