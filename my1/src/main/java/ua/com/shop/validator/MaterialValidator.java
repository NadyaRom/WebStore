package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

public class MaterialValidator implements Validator {

	private final MaterialService materialService;

	public MaterialValidator(MaterialService materialService) {
		this.materialService = materialService;
	}

	public boolean supports(Class<?> clazz) {
		return Material.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Material material = (Material) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can not be empty");
		if(materialService.findByName(material.getName())!=null){
			errors.rejectValue("name", "", "It already exists");
		}

}
	

}
