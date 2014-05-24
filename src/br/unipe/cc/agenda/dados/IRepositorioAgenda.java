package br.unipe.cc.agenda.dados;

import br.unipe.cc.agenda.modelo.Contato;

public interface IRepositorioAgenda {
	
	void inserir(Contato conta);
	
	Contato procurarTelefone(String telefone);
	
	Contato procurarNome(String nome) ;
	
	Contato[] procurarPorParteDoNome(String nome) ;

	boolean remover(String telefone);

	boolean atualizar(Contato c);

	boolean existe(String telefone);
	
	Contato[] listar();
	
	void ordenar();
	

}
