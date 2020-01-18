package br.com.arthur.implementacaoh2.entities;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SituacaoTypeConverter implements AttributeConverter<SituacaoType, String>{

	@Override
	public String convertToDatabaseColumn(SituacaoType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
	}

	@Override
	public SituacaoType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
 
        return Stream.of(SituacaoType.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

}
