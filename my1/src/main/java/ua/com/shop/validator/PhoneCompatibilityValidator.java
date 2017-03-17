package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Color;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.PhoneCompatibilityService;

public class PhoneCompatibilityValidator implements Validator {
	private final PhoneCompatibilityService phoneCompatibilityService;

	public  PhoneCompatibilityValidator(PhoneCompatibilityService phoneCompatibilityService) {
		this.phoneCompatibilityService = phoneCompatibilityService;
	}

	public boolean supports(Class<?> clazz) {
		return PhoneCompatibility.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		PhoneCompatibility phoneCompatibility = (PhoneCompatibility) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can not be empty!");
		if(phoneCompatibilityService.findByName(phoneCompatibility.getName())!=null){
			errors.rejectValue("name","", "It already exists");
		}
	
		
	}

}
