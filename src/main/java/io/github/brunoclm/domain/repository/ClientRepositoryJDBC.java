package io.github.brunoclm.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import io.github.brunoclm.domain.entity.Cliente;
import io.github.brunoclm.querys.SqlCliente;

@Repository
@SuppressWarnings("deprecation")
public class ClientRepositoryJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//POST
	public Boolean salvar(Cliente cliente) {
		try {
			jdbcTemplate.update(SqlCliente.INSERT, new Object[] {cliente.getId(), cliente.getNome()});
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return Boolean.FALSE;
	}
	
	//GET
	public List<Cliente> listarClientes() {
		return jdbcTemplate.query(SqlCliente.SELECT_ALL, rowMapperCliente());
	}
	
	//GET
	public List<Cliente> listarPorNome(String nome){
		return jdbcTemplate.query(SqlCliente.SELECT_ALL.concat(" where nome like ?"), new Object[] {"%" + nome + "%"}, rowMapperCliente());
	}
	
	//PUT
	public Boolean updateCliente(Cliente cliente, String id) {
		try {
			jdbcTemplate.update(SqlCliente.UPDATE, new Object[] {cliente.getNome(), id});
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Boolean.FALSE;
	}
	
	//Delete 
	public Boolean deletarCliente(String id) {
		try {
			jdbcTemplate.update(SqlCliente.DELETE_ID,id);
			return Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return Boolean.FALSE;
	}
	
	public RowMapper<Cliente> rowMapperCliente(){
		return new RowMapper<Cliente>() {
			@Override
			public Cliente mapRow(ResultSet resultSet, int i) throws SQLException{
				return new Cliente(resultSet.getString("id"), resultSet.getString("nome"));
			}
		};
	}
}
