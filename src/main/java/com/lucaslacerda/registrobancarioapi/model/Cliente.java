package com.lucaslacerda.registrobancarioapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente{

	  @Id
	  @OneToMany(cascade = CascadeType.ALL)
	  @Column(name="cliente_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Column(name="cpf",nullable = false,unique = true)
	  private String cpf;
	  
	  @Column(name="nome",nullable = false)
	  private String nome;
	  
	  @Column(name="email",nullable = false,length = 50)
	  private String email;
	  
	  @Column(name="nascimento",nullable = false)
	  private String nascimento;

	
	}
