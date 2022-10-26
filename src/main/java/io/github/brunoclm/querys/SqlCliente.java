package io.github.brunoclm.querys;

public class SqlCliente {
	
	public static final String INSERT = "insert into cliente values (?, ?)";
	
	public static final String SELECT_ALL = "select * from cliente";
	
	public static final String UPDATE = "update cliente set nome = ? where id = ?";
	
	public static final String DELETE_ID = "delete cliente where id = ?";

}
