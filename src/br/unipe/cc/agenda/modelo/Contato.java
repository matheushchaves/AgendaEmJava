package br.unipe.cc.agenda.modelo;

/**
 * Classe que compoe os dados nome e telefone
 * 
 * @author Matheus
 */

public class Contato {
	private String nome;
	private String telefone;

	/**
	 * Construtor para Classe Contato Inicializando os atributos de Nome e
	 * Telefone.
	 */

	public Contato(String nome, String telefone) {

		this.nome = nome;
		this.telefone = telefone;
	}

	/**
	 * Retorna o nome do Contato
	 * 

	 * @return nome
	 */

	public String getNome() {
		return nome;
	}

	/**
	 * Atribui nome ao nome do contato
	 * 
	 * @param nome
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o Telefone do Contato
	 * 
	 * @return telefone
	 */

	public String getTelefone() {
		return telefone;
	}

	/**
	 * Atribui telefone ao telefone do contato
	 * 
	 * @param telefone
	 */

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return getNome() + " - " + getTelefone();
	}

}
