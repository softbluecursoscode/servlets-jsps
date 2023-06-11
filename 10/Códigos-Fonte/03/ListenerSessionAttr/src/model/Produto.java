package model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Produto implements HttpSessionBindingListener {

	private String nome;

	public String getNome() {
		return nome;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent e) {
		this.nome = e.getName();
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent e) {
		this.nome = null;
	}
}
