package br.unipe.cc.agenda.dados;

import br.unipe.cc.agenda.modelo.Contato;

public interface IRepositorioAgenda {
	
	void inserir(Contato conta);
	
	boolean remover(String telefone);

	boolean atualizar(Contato c);

	boolean existeTelefone(String telefone);

	Contato procurarTelefone(String telefone);
	
	Contato procurarNome(String nome) ;
	
	Contato[] procurarPorParteDoNome(String nome) ;
	
	Contato[] paraArray();
	
	void ordenar();
}
