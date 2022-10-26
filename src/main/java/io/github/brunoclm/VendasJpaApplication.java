package io.github.brunoclm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.brunoclm.domain.entity.Cliente;
import io.github.brunoclm.domain.repository.ClientRepository;

@SpringBootApplication
public class VendasJpaApplication {
	
	@Bean
	public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
		return args -> {
			System.out.println(clientRepository.salvar(new Cliente("Bruno")));
		};
	}
	
	@Bean
	public CommandLineRunner listAll(@Autowired ClientRepository clientRepository) {
		
		clientRepository.salvar(new Cliente("Irineu"));
		clientRepository.salvar(new Cliente("Carrara"));
		clientRepository.salvar(new Cliente("Luiza"));
		clientRepository.salvar(new Cliente("Isabella"));
		clientRepository.salvar(new Cliente("Carneiro"));
		clientRepository.salvar(new Cliente("Teste"));
		clientRepository.salvar(new Cliente("Teste2"));
		
		return args -> {
			for (Cliente cliente : clientRepository.listarClientes()) {
				 System.out.println(cliente);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasJpaApplication.class, args);
	}

}
