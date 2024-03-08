package br.com.api.fatec.apifatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ClassificaIdade {
	
	/* 
	 *
	 * CLASSIFICADOR DE IDADE: Escreva um programa que classifique uma pessoa em categorias baseadas na sua idade
	 * 
	 * INSTRUÇÕES:
	 * 1 - O programa deve solicitar ao usuário que insira uma idade(URL).
	 * 2 - Se a idade for menor que 12 anos, o progama deve exibir "Criança"
	 * 3 - Se a idade for entre 12 e 18 anos, inclusive, o programa deve exibir "Adolescente".
	 * 4 - Se a idade for entre 19 e 60, inclusive, o programa deve exibir "Adulto".
	 * 5 - Se a idade for maior que 60 anos, o programa deve exibir "idoso".
	 * 6 - O programa deve tratar entradas inválidas, como números negativos ou não numéricos, exibindo "idade Inválida".
	*/
	
	@RequestMapping("/idade/{num}")
	String classificaIdade(@PathVariable String num) {
		
		try {
			
			int idade = Integer.parseInt(num);
			
			if (idade < 0) {
				throw new NumberFormatException();
			}
				
			if (idade < 13) {
				return "Criança";
			} else if (idade < 19) {
				return "Adolescente";
			} else if (idade < 61) {
				return "Adulto";
			} else if (idade > 60) {
				return "Idoso";
			}
			
		}catch (NumberFormatException e){
			return "Idade Inválida" + "\nErro: " + e;
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClassificaIdade.class, args);
	}

}