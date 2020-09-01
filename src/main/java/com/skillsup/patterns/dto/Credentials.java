package com.skillsup.patterns.dto;

public class Credentials {
	private final String login;
	private final String password;

	private Credentials(CredentialsBuilder credentialsBuilder) {
		this.login = credentialsBuilder.login;
		this.password = credentialsBuilder.password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}


	public static class CredentialsBuilder {

		private String login;
		private String password;

		public CredentialsBuilder setLogin(String login) {
			this.login = login;
			return this;
		}

		public CredentialsBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

public Credentials create(){return new Credentials(this);}
	}
}


