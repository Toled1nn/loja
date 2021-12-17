package br.com.api.loja.classes_avulsas;

import java.util.ArrayList;
import java.util.List;

public class ControladorSessao {
	
	private static ControladorSessao instance;
	
	public static ControladorSessao getInstance() {
		if (instance == null) {
			instance = new ControladorSessao();
		}
		return instance;
	}
	
	private List<String> usuarios = new ArrayList<String>();
	
	private ControladorSessao() {
		
	}
	public void autenticaUsuario(String login) {
		usuarios.add(login);
	}
	
	public boolean verificaAutenticacao(String login) {
		for (String user : usuarios) {
			if(user.equals(login)) {
				return true;
			}
		}
		return false;
	}

}
