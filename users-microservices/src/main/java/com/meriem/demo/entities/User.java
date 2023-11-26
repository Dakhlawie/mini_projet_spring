package com.meriem.demo.entities;

import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.meriem.demo.entities.Role;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.FetchType;
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long user_id;
	@Column(unique=true)
	private String username;
	
	private String email;
	 @Column(unique=true)
	    private String code;
	private String password;
	private Boolean enabled;
	 @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") , 
	 inverseJoinColumns = @JoinColumn(name="role_id")) 
	private List<Role> roles; 
}
