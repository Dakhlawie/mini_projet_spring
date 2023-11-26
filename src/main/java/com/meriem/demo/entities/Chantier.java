package com.meriem.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chantier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChantier;
	private String nomChantier;
	@JsonIgnore

	@OneToMany(mappedBy = "chantier")
	private List<Ouvrier> ouvriers;
	


}
