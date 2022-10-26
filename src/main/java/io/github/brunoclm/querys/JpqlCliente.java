package io.github.brunoclm.querys;

public class JpqlCliente {
	
	public static final String SELECT_BY_NAME = "select c from Cliente c where c.nome like :nome ";
	
	public static final String SELECT_ALL = "from Cliente";

}
