package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;
import ua.com.shop.entity.Design;
import ua.com.shop.service.DesignService;

public class DesignEditor extends PropertyEditorSupport {

	private final DesignService designService;
	
	public DesignEditor (DesignService designService) {
		this.designService=designService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Design design = designService.findById(Integer.valueOf(text));
		setValue(design);
	}
	
	
}

