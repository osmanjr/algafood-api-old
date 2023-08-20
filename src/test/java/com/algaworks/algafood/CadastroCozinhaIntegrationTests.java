package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroCozinhaIntegrationTests {
	
	@Autowired
	CadastroCozinhaService cadastroCozinha;
	
	@Test
	public void testarCadastroCozinhaComSucesso() {

		//Cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Cozinha Mediterrânea");
		
		
		//Ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		
		
		//Validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
		
	}

	@Test
	public void testarCadastroCozinhaSemNome() {
	     assertThrows(ConstraintViolationException.class, () -> {
         Cozinha novaCozinha = new Cozinha();
		 novaCozinha.setNome(null);
	         novaCozinha = cadastroCozinha.salvar(novaCozinha);
	     });
	}

}
