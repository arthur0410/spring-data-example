package br.com.arthur.implementacaoh2.entities;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SituacaoDbTypeConverter implements AttributeConverter<SituacaoDbType, String>{

	@Override
	public String convertToDatabaseColumn(SituacaoDbType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
	}

	@Override
	public SituacaoDbType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
 
        return Stream.of(SituacaoDbType.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

}
