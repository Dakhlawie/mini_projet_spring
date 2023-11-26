package com.meriem.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.meriem.demo.entities.Chantier;
import com.meriem.demo.entities.Ouvrier;
@SpringBootApplication
public class OuvrierApplication implements CommandLineRunner{
@Autowired
RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(OuvrierApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Ouvrier.class,Chantier.class);
	}


}
