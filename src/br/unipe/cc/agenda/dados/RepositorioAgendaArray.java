package br.unipe.cc.agenda.dados;

import br.unipe.cc.agenda.modelo.Contato;

public class RepositorioAgendaArray implements IRepositorioAgenda {

	private Contato[] contatos;
	private int qtdcontatos;

	public RepositorioAgendaArray(int capacidade) {
		contatos = new Contato[capacidade];
	}

	public Contato[] getContatos() {
		return contatos;
	}

	public int getQtdcontatos() {
		return qtdcontatos;
	}

	@Override
	public void inserir(Contato c) {
		garanteEspaço();
		contatos[qtdcontatos++] = c;
	}

	@Override
	public boolean remover(String telefone) {
		Contato buscaContato = procurarTelefone(telefone);
		int i = buscaContato!=null ? this.getPosicao(buscaContato.getTelefone()) : 0 ;
		// se a posiçao não for o tamanho de contatos
		boolean remover = i != this.qtdcontatos  ; 
		if (remover) {
			this.qtdcontatos = this.qtdcontatos - 1; // diminue o tamanho
			this.contatos[i] = this.contatos[this.qtdcontatos];
			// pega o ultimo contato e troca com o atual
			this.contatos[this.qtdcontatos] = null;
			// troca o ultimo contato com null
		}
		return remover;
	}

	@Override
	public boolean atualizar(Contato c) {
		Contato p = procurarNome(c.getNome()); 
		int i = this.getPosicao(p!=null?p.getTelefone():"");
		boolean atualizar = i != this.qtdcontatos;
		if (atualizar) {
			this.contatos[i] = c;
		}
		return atualizar;

	}

	@Override
	public boolean existeTelefone(String telefone) {
		int i = this.getPosicao(telefone);
		return (i != this.qtdcontatos);
	}

	private int getPosicao(String telefone) {
		String n;
		boolean achou = false;
		int i = 0;
		// Enquanto não achar e nao for o final dos contatos
		while ((!achou) && (i < this.qtdcontatos)) {
			n = contatos[i].getTelefone();
			if (n.equals(telefone)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i; // retorno do indice
	}

	void garanteEspaço() {
		Contato[] newcontato;
		if (qtdcontatos == contatos.length) {
			newcontato = new Contato[contatos.length + 2];
			for (int i = 0; i < contatos.length; i++) {
				newcontato[i] = contatos[i];
			}
			contatos = newcontato;

		}

	}

	@Override
	public Contato procurarTelefone(String telefone) {

		Contato c = null;
		int i = this.getPosicao(telefone);
		if (i != this.qtdcontatos)
			c = this.contatos[i];
		return c;

	}

	@Override
	public Contato procurarNome(String nome) {

		for (int j = 0; j < this.qtdcontatos; j++)
			if (contatos[j].getNome().compareTo(nome) == 0)
				return contatos[j];
		return null;
	}

	@Override
	public Contato[] procurarPorParteDoNome(String nome) {

		Contato[] encontrados1 = new Contato[qtdcontatos];

		Contato[] encontrados2 = null;
		int posicao = 0;

		for (int i = 0; i < qtdcontatos; i++) {
			if (contatos[i].getNome().contains(nome))
				encontrados1[posicao++] = contatos[i];
		}

		encontrados2 = new Contato[posicao];
		for (int i = 0; i < encontrados2.length; i++) {
			encontrados2[i] = encontrados1[i];
		}

		return encontrados2;
	}


	@Override
	public void ordenar() {
		Contato temporario = null;
		for (int i = 0; i < qtdcontatos; i++) {
			for (int j = 0; j < qtdcontatos; i++) {
				if (qtdcontatos < i + 1) {
					temporario = contatos[i];
					contatos[i] = contatos[i + 1];
					contatos[i + 1] = temporario;
				}
			}
		}
	}

	@Override
	public Contato[] paraArray() {
		return contatos;
	}



}
