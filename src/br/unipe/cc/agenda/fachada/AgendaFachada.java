package br.unipe.cc.agenda.fachada;

import br.unipe.cc.agenda.dados.RepositorioAgendaArray;
import br.unipe.cc.agenda.modelo.Contato;
import br.unipe.cc.agenda.negocio.UsaAgenda;


public class AgendaFachada {
	private UsaAgenda agenda;
	public AgendaFachada() {
		this.agenda = new UsaAgenda(new RepositorioAgendaArray(0));
	}

	public boolean cadastrarContato(Contato c) {
		return agenda.cadastrar(c);
	}
	
	public Contato procurarContatoPorTelefone(Contato c) {
		return agenda.procurarTelefone(c);
	}
	public Contato procurarContatoPorNome(Contato c) {
		return agenda.procurarNome(c);
	}
	public Contato[] procurarContatosPorParteDoNome(Contato c) {
		return agenda.procurarPorParteNome(c);
	}

	public boolean removerContato(Contato c) {
		return agenda.removerContato(c);
	}
	
	public boolean atualizarContato(Contato c) {
		return agenda.atualizar(c);
	}
	public Contato[] listarContatos() {
		return agenda.listarContatos();
	}
	public Contato[] listarContatosOrdenado() {
		agenda.ordenarContatos();
		return agenda.listarContatos();
	}
	

}

