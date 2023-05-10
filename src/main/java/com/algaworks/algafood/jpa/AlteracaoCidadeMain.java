package com.algaworks.algafood.jpa;

import java.util.Optional;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

public class AlteracaoCidadeMain {
	
	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		EstadoRepository estadoRepository = applicationContext.getBean(EstadoRepository.class);
		
		Optional<Estado> estado = estadoRepository.findById(1L);
		
		Cidade cidade = new Cidade();
		cidade.setId(1L);
		cidade.setNome("Tracunhaem");
		cidade.setEstado(estado.get());
		cidadeRepository.save(cidade);



	}


}
