package com.meriem.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.meriem.demo.entities.Chantier;
@RepositoryRestResource(path = "cat")
@CrossOrigin("*") //pour autoriser angular 
public interface ChantierRepository  extends JpaRepository<Chantier, Long>{

}
