package br.com.arthur.implementacaoh2.entrypoints;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.arthur.implementacaoh2.domain.AcordoComercial;

public class ValidadorDatas implements ConstraintValidator<ValidaDatas, AcordoComercial> {

	@Override
	public boolean isValid(AcordoComercial value, ConstraintValidatorContext context) {
		
		if (vigenciaIndeterminadaComDataFimNula(value, context))
			return false;
		
		if (dataFimMenorQueInicio(value, context))
			return false;
		
		if (vigenciaDeterminadaComDataFimNaoNula(value, context))
			return false;
		
		return true;
	}

	private boolean dataFimMenorQueInicio(AcordoComercial value, ConstraintValidatorContext context) {
		if (!value.getVigenciaIndeterminada() && 
				equalsOrBefore(value.getDataInicioVigencia(), value.getDataFimVigencia())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data de fim de vigência precisa ser posterior "
					+ "a data de início de vigência").addConstraintViolation();
			return true;
		}
		return false;
	}
	
	private boolean equalsOrBefore(Date dataInicio, Date dataFim) {
		return dataFim.before(dataInicio) || dataFim.equals(dataInicio);
	}
	
	private boolean vigenciaIndeterminadaComDataFimNula(AcordoComercial value, ConstraintValidatorContext context) {
		if (!value.getVigenciaIndeterminada() && value.getDataFimVigencia() == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Data de fim de vigência obrigatória quando o "
					+ "fim de vigência não é indeterminado").addConstraintViolation();
			return true;
		}
		return false;
	}

	private boolean vigenciaDeterminadaComDataFimNaoNula(AcordoComercial value, ConstraintValidatorContext context) {
		if (value.getVigenciaIndeterminada() && value.getDataFimVigencia() != null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("Não informar data fim de vigência quando a "
					+ "vigência for indeterminada").addConstraintViolation();
			return true;
		}
		return false;
	}

}