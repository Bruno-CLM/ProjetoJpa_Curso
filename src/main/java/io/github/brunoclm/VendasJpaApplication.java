package io.github.brunoclm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import io.github.brunoclm.domain.entity.Cliente;
import io.github.brunoclm.domain.entity.Pedido;
import io.github.brunoclm.domain.repository.ClientRepositoryJDBC;
import io.github.brunoclm.domain.repository.ClientRepositoryJPA;
import io.github.brunoclm.domain.repository.ClientRepositoryJPARepository;
import io.github.brunoclm.domain.repository.PedidoRepository;

@SpringBootApplication
public class VendasJpaApplication {

	/*** JDBCTemplate ***/
	/*
	 * @Bean public CommandLineRunner init(@Autowired ClientRepository
	 * clientRepository) { return args -> { System.out.println("\u001B[33m"
	 * +"\nSalvando na base"); System.out.println(clientRepository.salvar(new
	 * Cliente("Bruno"))); }; }
	 * 
	 * @Bean public CommandLineRunner listAll(@Autowired ClientRepository
	 * clientRepository) {
	 * 
	 * System.out.println("\u001B[33m" +"\nSalvando na base");
	 * clientRepository.salvar(new Cliente("Irineu")); clientRepository.salvar(new
	 * Cliente("Carrara")); clientRepository.salvar(new Cliente("Luiza"));
	 * clientRepository.salvar(new Cliente("Isabella")); clientRepository.salvar(new
	 * Cliente("Carneiro")); clientRepository.salvar(new Cliente("Teste"));
	 * clientRepository.salvar(new Cliente("Teste")); clientRepository.salvar(new
	 * Cliente("Teste")); clientRepository.salvar(new Cliente("Teste"));
	 * clientRepository.salvar(new Cliente("Teste")); clientRepository.salvar(new
	 * Cliente("Teste")); clientRepository.salvar(new Cliente("Teste2"));
	 * 
	 * Cliente cliente2 = new Cliente(); cliente2.setNome("Burno");
	 * clientRepository.salvar(cliente2); return args -> {
	 * 
	 * System.out.println("\u001B[33m" +"\nConsultando na base"); for (Cliente
	 * cliente : clientRepository.listarClientes()) {
	 * System.out.println("\u001B[30m" +cliente); }
	 * 
	 * cliente2.setNome("Bruno Cunha Ludolf Irineu Carrara");
	 * 
	 * clientRepository.updateCliente(cliente2, cliente2.getId());
	 * 
	 * System.out.println("\u001B[33m" +"\nConsultando na base, após um update");
	 * for (Cliente cliente : clientRepository.listarClientes()) {
	 * System.out.println("\u001B[30m" +cliente); }
	 * 
	 * System.out.println("\u001B[33m" + "\nConsultando pelo nome 'Teste' na base");
	 * for (Cliente cliente : clientRepository.listarPorNome("Teste")) {
	 * System.out.println("\u001B[30m" +cliente); }
	 * 
	 * System.out.println(clientRepository.listarPorNome("Teste").size());
	 * 
	 * clientRepository.deletarCliente(cliente2.getId());
	 * 
	 * System.out.println("\u001B[33m" +"\nConsultando na base, após um delete");
	 * for (Cliente cliente : clientRepository.listarClientes()) {
	 * System.out.println("\u001B[30m" + cliente); } }; }
	 */

	/*** JPA EntityManager ***/
	/*
	 * @Bean public CommandLineRunner jpa(@Autowired ClientRepositoryJPA
	 * clientRepositoryJPA) { return args -> { System.out.println("\u001B[33m" +
	 * "\nSalvando na base"); System.out.println("\u001B[30m" +
	 * clientRepositoryJPA.salvar(new Cliente("Bruno"))); }; }
	 */

	/*** JPARepository ***/
	/*
	 * @Bean public CommandLineRunner jpaRepository(@Autowired
	 * ClientRepositoryJPARepository clientRepositoryJPARepository) { return args ->
	 * {
	 * 
	 * System.out.println("Salvando clientes");
	 * clientRepositoryJPARepository.save(new Cliente("Dougllas",
	 * "email@teste.com")); clientRepositoryJPARepository.save(new
	 * Cliente("Outro Cliente", "email@teste.com"));
	 * 
	 * List<Cliente> todosClientes = clientRepositoryJPARepository.findAll();
	 * todosClientes.forEach(System.out::println);
	 * 
	 * System.out.println("Atualizando clientes"); todosClientes.forEach(c -> {
	 * c.setNome(c.getNome() + " atualizado.");
	 * clientRepositoryJPARepository.save(c); });
	 * 
	 * todosClientes = clientRepositoryJPARepository.findAll();
	 * todosClientes.forEach(System.out::println);
	 * 
	 * System.out.println("Buscando clientes");
	 * clientRepositoryJPARepository.encontrarPorNome("Cli").forEach(System.out::
	 * println);
	 * 
	 * System.out.println("deletando clientes");
	 * clientRepositoryJPARepository.findAll().forEach(c -> {
	 * clientRepositoryJPARepository.delete(c); });
	 * 
	 * todosClientes = clientRepositoryJPARepository.findAll(); if
	 * (todosClientes.isEmpty()) { System.out.println("Nenhum cliente encontrado.");
	 * } else { todosClientes.forEach(System.out::println); }
	 * 
	 * System.out.println("Salvando clientes");
	 * clientRepositoryJPARepository.save(new Cliente("Dougllas",
	 * "email@teste.com"));
	 * 
	 * System.out.println("Consultando se o email já foi cadastrado");
	 * 
	 * if (clientRepositoryJPARepository.existsByEmail("email@teste.com"))
	 * System.out.println("Cliente já possui cadastro"); else
	 * System.out.println("Cliente não encontrado");
	 * 
	 * }; }
	 */
	
	@Bean
	public CommandLineRunner jpaRepositoryEntitys(@Autowired ClientRepositoryJPARepository clientRepositoryJPARepository, @Autowired PedidoRepository pedidoRepository) {
		return args -> {
			
			System.out.println("Salvando cliente");
			Cliente c = new Cliente("Fulano", "fulano@gmail.com");
			clientRepositoryJPARepository.save(c);
			
			System.out.println("Salvando pedido");
			Pedido p = new Pedido();
			p.setClienteId(c);
			p.setDataPedido(LocalDate.now());
			p.setTotalPedido(BigDecimal.ONE);
			
			pedidoRepository.save(p);
			
			System.out.println("Cliente e Pedidos");
			Cliente c2 = clientRepositoryJPARepository.findClienteFetchPedidos(c.getId());
			System.out.println(c2);
			
			
			  System.out.println("Cliente e Pedidos"); 
			  Pedido p2 = pedidoRepository.pedidoPeloId(p.getId()); 
			  System.out.println(p2);
			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasJpaApplication.class, args);
	}

}
