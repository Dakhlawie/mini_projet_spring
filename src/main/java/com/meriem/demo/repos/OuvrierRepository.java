package com.meriem.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.meriem.demo.entities.Ouvrier;

public interface OuvrierRepository extends JpaRepository<Ouvrier, Long>{
	List<Ouvrier> findByChantierIdChantier(Long id);
	List<Ouvrier> findByNomContains(String nom);
}
