package br.com.unip.aps.chat.dto;

import br.com.unip.aps.modelo.User;

public class Userdto {
	
	private String nome;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public User toUser() {
		User user = new User();
		user.setNome(nome);
		user.setSenha(senha);
		user.setEmail(email);
		return user;
	}

}
