package com.meriem.demo.services;

import java.util.List;

import com.meriem.demo.dto.OuvrierDTO;
import com.meriem.demo.entities.Ouvrier;

public interface OuvrierService {
	OuvrierDTO saveOuvrier(OuvrierDTO p);
	OuvrierDTO updateOuvrier(OuvrierDTO p);
	void deleteOuvrier(Ouvrier p);
	 void deleteOuvrierById(Long id);
	 OuvrierDTO getOuvrier(Long id);
	 Ouvrier getOuvrierById(Long id);
	List<OuvrierDTO> getAllOuvriers();
	List<Ouvrier> findByChantierIdChantier(Long id);
	OuvrierDTO convertEntityToDto (Ouvrier ouvrier);
	Ouvrier convertDtoToEntity(OuvrierDTO ouvrierDto);
	List<Ouvrier> findByNomContains(String nom);



}
