package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.Type;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.TypeService;

public class TypeValidator implements Validator {
	
	private final TypeService typeService;

	public  TypeValidator(TypeService typeService) {
		this.typeService = typeService;
	}

	public boolean supports(Class<?> clazz) {
		return Type.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Type type = (Type) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can not be empty");
		if(typeService.findByName(type.getName())!=null){
			errors.rejectValue("name", "", "It already exists");
		}
		
	}

}
