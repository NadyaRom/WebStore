package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Color;
import ua.com.shop.service.ColorService;

public class ColorValidator implements Validator{
	
	private final ColorService colorService;

	public ColorValidator(ColorService colorService) {
		this.colorService = colorService;
	}

	public boolean supports(Class<?> clazz) {
		return Color.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Color color = (Color) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can not be empty");
		if(colorService.findByName(color.getName())!=null){
			errors.rejectValue("name", "", "It already exists");
		}
		
	}

}
