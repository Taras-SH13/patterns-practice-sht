package com.skillsup.patterns.dto;

public class Credentials {
	private final String login;
	private final String password;

	public Credentials(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public static class CredentialsBuilder{

		private String login;
		private String password;

		public CredentialsBuilder setLogin(String login){
			this.login = login;
			return this;
		}
		public CredentialsBuilder setLpassword(String password){
			this.password = password;
			return this;
		}
		public Credentials credentialsBuild() {
			return new Credentials(login, password);
		}
	}

}
