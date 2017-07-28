package com.sgv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.sgv.core.dao.domain.Company;
import com.sgv.core.dao.mapper.CompanyMapper;
import com.sgv.customer.procesar.service.EquivalenciaProductoService;

@SpringBootApplication
//@MapperScan("com.sgv.core.fakturama.dao.mapper")
//@ComponentScan("com.sgv.customer.procesar.service")
public class SisgesvenWebApplication {

	private static final Logger log = LoggerFactory.getLogger(SisgesvenWebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SisgesvenWebApplication.class, args);
	}
	/*
	@Bean
	public CommandLineRunner loadData(EquivalenciaProductoService service) {
		return (args) -> {
			System.out.println("SERVICE ES  : "+service);
			//System.out.println("Tamañano : "+service.obtenerListaEquivalenciaProductos("20549706500").size());

		};
	}*/
	
	/*
 	@Bean
	public CommandLineRunner loadData(CompanyMapper repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Company("Jack", "Pagina01"));
			repository.save(new Company("Chloe", "Pagina05"));
			repository.save(new Company("Kim", "Pagina04"));
			repository.save(new Company("David", "Pagina03"));
			repository.save(new Company("Michelle", "Pagina02"));

			// fetch all customers
			log.info("Companys found with findAll():");
			log.info("-------------------------------");
			for (Company customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Company customer = repository.findOne(1L);
			log.info("Company found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Company found with findByFilter('Bauer'):");
			log.info("--------------------------------------------");
			for (Company bauer : repository
					.findByFilter("xx")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
		//*/	
}
