package br.ufscar.dc.dsw;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IAgenciaDAO;
import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.IPacoteDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Pacote;


@SpringBootApplication
public class PacotesTuristicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacotesTuristicosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BCryptPasswordEncoder encoder, IClienteDAO clienteDAO, IPacoteDAO pacoteDAO, IAgenciaDAO agenciaDAO){
		return (args) -> {
			/*Agencia a1 = new Agencia();
			a1.setCnpj("55.789.390/0008-99");
			a1.setDescricao("[descricao 1]");
			a1.setEmail("turismagia@email.com");
			a1.setNome("Turismagia");
			agenciaDAO.save(a1);

			Agencia a2 = new Agencia();
			a2.setCnpj("12.345.678/9012-34");
			a2.setDescricao("[descricao 2]");
			a2.setEmail("zeviagens@email.com");
			a2.setNome("Ze Viagens");
			agenciaDAO.save(a2);
			
			Pacote p1 = new Pacote();
			p1.setAgencia(a1);
			p1.setDataPartida("29/01/2022");
			p1.setDescricao("[arquivo PDF]");
			p1.setDestino("Mogi Guacu,SP,Brasil");
			p1.setDuracao("7");
			p1.setImagens("[lista de imagens]");
			p1.setValor("250,00");
			pacoteDAO.save(p1);
			
			Pacote p2 = new Pacote();
			p2.setAgencia(a1);
			p2.setDataPartida("20/02/2022");
			p2.setDescricao("[arquivo PDF 2]");
			p2.setDestino("Campinas,SP,Brasil");
			p2.setDuracao("4");
			p2.setImagens("[lista de imagens 2]");
			p2.setValor("470,00");
			pacoteDAO.save(p2);

			Pacote p3 = new Pacote();
			p3.setAgencia(a2);
			p3.setDataPartida("01/04/2022");
			p3.setDescricao("[arquivo PDF 3]");
			p3.setDestino("Rio de Janeiro,RJ,Brasil");
			p3.setDuracao("8");
			p3.setImagens("[lista de imagens 3]");
			p3.setValor("400,00");
			pacoteDAO.save(p3);
			
			Cliente c1 = new Cliente();
			c1.setEmail("fulanosilva@email.com");
			c1.setSenha(encoder.encode("senha1"));
			c1.setCpf("123.456.789-01");
			c1.setNome("fulano");
			c1.setTelefone("(12)34567-8901");
			c1.setSexo("MASCULINO");
			c1.setDataNasc("01/02/1993");
			c1.setPapel("ROLE_CLIENTE");
			c1.setEnabled(true);
			clienteDAO.save(c1);

			Cliente c2 = new Cliente();
			c2.setEmail("cicranoprado@email.com");
			c2.setSenha(encoder.encode("lol"));
			c2.setCpf("123.456.789-01");
			c2.setNome("cicrano");
			c2.setTelefone("(11)44444-4444");
			c2.setSexo("MASCULINO");
			c2.setDataNasc("04/04/1994");
			c2.setPapel("ROLE_CLIENTE");
			c2.setEnabled(true);
			clienteDAO.save(c2);

			Cliente admin = new Cliente();
			admin.setEmail("admin@email.com");
			admin.setSenha(encoder.encode("admin"));
			admin.setCpf("111.222.333-44");
			admin.setNome("admin");
			admin.setTelefone("(11)22222-3333");
			admin.setSexo("MASCULINO");
			admin.setDataNasc("22/11/1993");
			admin.setPapel("ROLE_ADMIN");
			admin.setEnabled(true);
			clienteDAO.save(admin);*/
		};
	}

}
