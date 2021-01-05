package com.lucaslacerda.registrobancarioapi.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "conta")
@EntityListeners(AuditingEntityListener.class)
public class Conta implements Serializable {

	  @Id
	  @Column(name="conta_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @ManyToOne
	  @JoinColumn(name = "cliente",referencedColumnName = "cliente_id",nullable = false)
	  private Long cliente;
	  
	  @Column(name="saldo")
	  private float saldo = 0;
	}
