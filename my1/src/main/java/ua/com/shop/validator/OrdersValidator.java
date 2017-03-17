//package ua.com.shop.validator;
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//
//import ua.com.shop.entity.Color;
//import ua.com.shop.entity.Orders;
//import ua.com.shop.service.ColorService;
//import ua.com.shop.service.MaterialService;
//import ua.com.shop.service.OrdersService;
//
//public class OrdersValidator {
//	private final OrdersService ordersService;
//
//	public OrdersValidator(OrdersService ordersService) {
//		this.ordersService = ordersService;
//	}
//
//	public boolean supports(Class<?> clazz) {
//		return Orders.class.equals(clazz);
//	}
//
//	public void validate(Object target, Errors errors) {
//		Orders orders = (Orders) target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can not be empty");
//		if(ordersService.findByName(orders.getName()!=null)){
//			errors.rejectValue("name", "", "It already exists");
//		}
//		
//	}

//}
