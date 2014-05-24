package br.unipe.cc.agenda.gui.janelas;

import java.awt.event.ActionEvent;

import br.unipe.cc.agenda.fachada.AgendaFachada;
import br.unipe.cc.agenda.gui.funcoes.G;
import br.unipe.cc.agenda.modelo.Contato;

public class JanelaContatoAdicionar extends JanelaContato {

	public JanelaContatoAdicionar(AgendaFachada a) {
		super(a);
		preparaTelefone();
		preparaNome();
		preparaBotoes();
		preparaJanela("Agenda Eletronica - Adicionar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		boolean fecharJanela = false;
		boolean camposValidos = true;
		if (e.getSource().equals(botaoConfirmar)) {
			camposValidos = camposValidos && validarTelefone();
			camposValidos = camposValidos && validarNome();
			fecharJanela = camposValidos && agenda.cadastrarContato(new Contato(campoNome.getText(),campoTelefone.getText()));
			if (!fecharJanela && camposValidos)
				G.msgErro("Numero já Existe!!", "Erro");
		}
		if (fecharJanela)
			janelaContato.dispose();

	}

	@Override
	public boolean validarNome() {
		boolean retorno = super.validarNome();
		if (retorno)
			botaoConfirmar.grabFocus();
		return retorno;
	}

	@Override
	public boolean validarTelefone() {
		boolean retorno = super.validarTelefone();
		if (retorno)
			campoNome.grabFocus();
		return retorno;
	}
}