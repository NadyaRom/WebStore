package ua.com.shop.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.dto.form.ProductForm;


public class ProductValidator implements Validator{
	
	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProductForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductForm product = (ProductForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
		if(!PATTERN.matcher(product.getPrice()).matches()){
			errors.rejectValue("price", "", "Wrong format, only 2 digits after separator");
		}
	}
}