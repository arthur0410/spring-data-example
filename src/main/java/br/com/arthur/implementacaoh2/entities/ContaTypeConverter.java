package br.com.arthur.implementacaoh2.entities;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ContaTypeConverter implements AttributeConverter<ContaType, Integer>{

	@Override
	public Integer convertToDatabaseColumn(ContaType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode();
	}

	@Override
	public ContaType convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
 
        return Stream.of(ContaType.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
	}

}
