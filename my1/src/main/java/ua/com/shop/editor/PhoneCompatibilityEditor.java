package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.service.PhoneCompatibilityService;

public class PhoneCompatibilityEditor extends PropertyEditorSupport {

	private final PhoneCompatibilityService phoneCompatibilityService;
	
	public PhoneCompatibilityEditor (PhoneCompatibilityService phoneCompatibilityService) {
		this.phoneCompatibilityService=phoneCompatibilityService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		PhoneCompatibility phoneCompatibility = phoneCompatibilityService.findById(Integer.valueOf(text));
		setValue(phoneCompatibility);
	}
	
	
}