package io.github.brunoclm.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import io.github.brunoclm.domain.entity.Cliente;

@Repository
public class ClientRepository {
	
	private static String INSERT = "insert into cliente values (?, ?) ";
	private static String SELECT_ALL = "select * from cliente";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Boolean salvar(Cliente cliente) {
		try {
			jdbcTemplate.update(INSERT, new Object[] {cliente.getId(), cliente.getNome()});
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Boolean.FALSE;
	}
	
	public List<Cliente> listarClientes() {
		return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException{
				return new Cliente(resultSet.getString("id"), resultSet.getString("nome"));
			}
		});
	}
	
}
