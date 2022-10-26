package io.github.brunoclm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import io.github.brunoclm.domain.entity.Cliente;
import io.github.brunoclm.domain.repository.ClientRepositoryJDBC;
import io.github.brunoclm.domain.repository.ClientRepositoryJPA;

@SpringBootApplication
public class VendasJpaApplication {
	
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
	
	@Bean public CommandLineRunner jpa(@Autowired ClientRepositoryJPA clientRepositoryJPA) { 
		return args -> { 
			System.out.println("\u001B[33m" + "\nSalvando na base"); 
			System.out.println("\u001B[30m" + clientRepositoryJPA.salvar(new Cliente("Bruno"))); 
		}; 
	}
	

	public static void main(String[] args) {
		SpringApplication.run(VendasJpaApplication.class, args);
	}

}
