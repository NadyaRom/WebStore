package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Design;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DesignService;

public class DesignValidator implements Validator{

	private final DesignService designService;

	public  DesignValidator (DesignService designService) {
		this.designService = designService;
	}

	public boolean supports(Class<?> clazz) {
		return Design.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Design design = (Design) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can not be empty!");
		if(designService.findByName(design.getName())!=null){
			errors.rejectValue("name","", "It already exists");
		}
	}


}
