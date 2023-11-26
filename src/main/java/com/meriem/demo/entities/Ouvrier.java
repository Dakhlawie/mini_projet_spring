package com.meriem.demo.entities;



import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ouvrier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOuvrier ;
	private String nom;
	private String tel;
	private Date dateEmbauche;
	private double salaire;
	@ManyToOne
	private Chantier chantier;
	/*@OneToOne
	private Image image;*/
	@OneToMany (mappedBy = "ouvrier")
	private List<Image> images;
	private String imagePath;



	
}
