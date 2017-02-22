package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;
import ua.com.shop.entity.Producer;
import ua.com.shop.service.ProducerService;

public class ProducerEditor extends PropertyEditorSupport {

	private final ProducerService producerService;
	
	public ProducerEditor (ProducerService producerService) {
		this.producerService=producerService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Producer producer = producerService.findById(Integer.valueOf(text));
		setValue(producer);
	}
	
	
}