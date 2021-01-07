package com.lucaslacerda.registrobancarioapi.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.ParameterExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.lucaslacerda.registrobancarioapi.model.Cliente;
import com.lucaslacerda.registrobancarioapi.model.Conta;
import com.lucaslacerda.registrobancarioapi.repository.ClienteRepository;
import com.lucaslacerda.registrobancarioapi.repository.ContaRepository;

@RestController
@RequestMapping("/cadastro")
public class ContaController {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ContaRepository contaRepository;
	
	//Abertura de conta
	@PostMapping("/abrirconta")
	public Conta aberturaConta(@RequestBody Cliente cliente) {
		
		cliente = cadastraCliente(cliente);
		
		Conta conta = new Conta(cliente.getId(),0);

		return contaRepository.save(conta);
	}
	
	//Cadastro cliente
	public Cliente cadastraCliente(@RequestBody Cliente cliente) {
		
		int codeReturn = 400;
		String campoInvalido = "Requisição invalida";
		
		try {
			if(0==0) {
				codeReturn = 409;
				campoInvalido = "Requisição invalida";
			}else if(0==1) {
				codeReturn = 409;
				campoInvalido = "Requisição invalida";
			}
			
			
			 return clienteRepository.save(cliente);
		}catch (Exception e) {
			throw new ResponseStatusException(codeReturn, campoInvalido, e);
		}
			 
	}
}
