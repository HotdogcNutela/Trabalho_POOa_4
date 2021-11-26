package br.ufscar.dc.dsw.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.dao.IAgenciaDAO;
import br.ufscar.dc.dsw.domain.Agencia;

@Component
public class UniqueCnpjValidator implements ConstraintValidator<UniqueCnpj, String> {

	@Autowired
	private IAgenciaDAO dao;

	@Override
	public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
		if (dao != null) {
			Agencia Agencia = dao.findByCnpj(CNPJ);
			return Agencia == null;
		} else {
            // Não necessidade de validação
			// Durante a execução da classe LivrariaMvcApplication
			// não há injeção de dependência. 
			return true;
		}
	}
}
