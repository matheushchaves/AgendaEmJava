package br.unipe.cc.agenda.negocio;


import br.unipe.cc.agenda.dados.IRepositorioAgenda;
import br.unipe.cc.agenda.modelo.Contato;

public class UsaAgenda {
	private IRepositorioAgenda agenda;

	public UsaAgenda(IRepositorioAgenda agenda) {
		this.agenda = agenda;
	}

	public boolean cadastrar(Contato c) {
		// Aplicaçao da Regra de Negocio 
		if (!agenda.existe(c.getTelefone())) {
			agenda.inserir(c);
			return true;
		} else {
			return false;
		}
	}

	public boolean atualizar(Contato c) {
		return agenda.atualizar(c);
	}

	public Contato procurarTelefone(Contato c) {
		return agenda.procurarTelefone(c.getTelefone());
	}
	public Contato procurarNome(Contato c) {
		return agenda.procurarNome(c.getNome());
	}
	public Contato[] procurarPorParteNome(Contato c) {
		return agenda.procurarPorParteDoNome(c.getNome());
	}

	public boolean apagar(Contato c) {
		return agenda.remover(c.getNome());

	}
    public void ordenarContatos(){
    	agenda.ordenar();
    }
	public Contato[] listarContatos() {
		return agenda.listar();
	}


}
