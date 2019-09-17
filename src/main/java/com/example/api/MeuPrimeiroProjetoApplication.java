package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.api.utils.SenhaUtils;

import org.springframework.beans.factory.annotation.Value;


@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args);
		System.out.println("Meu Primeiro Projeto 5...");		
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("##### Qtd de elementos por pagina = " + this.qtdPorPagina);
			String senhaEncode = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha Encoded: " + senhaEncode);
			
			senhaEncode = SenhaUtils.gerarBCrypt("123456");
			System.out.println("Senha Encoded Novamente: " + senhaEncode);
			
			System.out.println("Senha Valida: " + SenhaUtils.senhaValida("123456", senhaEncode));
			
		};
	}

}
