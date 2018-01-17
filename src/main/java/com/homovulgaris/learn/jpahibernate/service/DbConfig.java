package com.homovulgaris.learn.jpahibernate.service;



public class DbConfig {

	private String dbPassword;

	private String dbName;

	private String dbUser;

	private String dbPort;

	private String dbHost;

	public String getDbPassword() {
		return dbPassword;
	}

	public String getDbName() {
		return dbName;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDbPort() {
		return dbPort;
	}

	public String getDbHost() {
		return dbHost;
	}

	
	public DbConfig() {
		super();
	}

	public DbConfig(String dbPassword, String dbName, String dbUser, String dbPort, String dbHost) {
		super();
		this.dbPassword = dbPassword;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPort = dbPort;
		this.dbHost = dbHost;
	}
}
