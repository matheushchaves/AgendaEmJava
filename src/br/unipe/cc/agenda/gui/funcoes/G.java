package br.unipe.cc.agenda.gui.funcoes;

import javax.swing.JOptionPane;

public abstract class G {

    public static String localImagem = System.getProperty("user.dir").concat("\\img\\");
    public static String IconePrograma = localImagem+"agenda.jpg";
	static void msg(String msg,String titulo,int tipo){
		JOptionPane.showMessageDialog(null, msg, titulo,tipo);
	}
	public static void msgInfo(String msg, String titulo) {
		msg(msg, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void msgAlert(String msg, String titulo) {
		msg(msg, titulo, JOptionPane.WARNING_MESSAGE);
	}
	public static void msgErro(String msg, String titulo) {
		msg(msg, titulo, JOptionPane.ERROR_MESSAGE);
	}

}