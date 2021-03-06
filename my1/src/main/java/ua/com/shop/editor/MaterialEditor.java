package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;
import ua.com.shop.entity.Material;
import ua.com.shop.service.MaterialService;

public class MaterialEditor extends PropertyEditorSupport {

	private final MaterialService materialService;
	
	public MaterialEditor (MaterialService materialService) {
		this.materialService=materialService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Material material = materialService.findById(Integer.valueOf(text));
		setValue(material);
	}
	
	
}
