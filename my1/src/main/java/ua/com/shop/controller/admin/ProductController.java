package ua.com.shop.controller.admin;



import java.util.ArrayList;
import java.util.HashSet;

import javax.enterprise.inject.New;
import javax.validation.Valid;
import javax.validation.spi.ValidationProvider;

import org.hibernate.boot.jaxb.spi.Binder;
import org.hibernate.validator.parameternameprovider.ParanamerParameterNameProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.dto.filter.ProductFilter;
import ua.com.shop.dto.form.ProductForm;
import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.ColorEditor;
import ua.com.shop.editor.DesignEditor;
import ua.com.shop.editor.MaterialEditor;
import ua.com.shop.editor.PhoneCompatibilityEditor;
import ua.com.shop.editor.ProducerEditor;
import ua.com.shop.editor.TypeEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Color;
import ua.com.shop.entity.Design;
import ua.com.shop.entity.Material;
import ua.com.shop.entity.PhoneCompatibility;
import ua.com.shop.entity.Producer;
import ua.com.shop.entity.Product;
import ua.com.shop.entity.Type;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.ColorService;
import ua.com.shop.service.DesignService;
import ua.com.shop.service.MaterialService;
import ua.com.shop.service.PhoneCompatibilityService;
import ua.com.shop.service.ProducerService;
import ua.com.shop.service.ProductService;
import ua.com.shop.service.TypeService;
import ua.com.shop.util.ParamBuilder;
import ua.com.shop.validator.ProductValidator;


@Controller
@RequestMapping("/admin/product")
@SessionAttributes("product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService  categoryService ;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private DesignService designService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private PhoneCompatibilityService phoneCompatibilityService;
	
	@ModelAttribute("product")
	public ProductForm getForm(){
		return new ProductForm();
	}

	@ModelAttribute("filter")
	public ProductFilter getFilter(){
		return new ProductFilter();
	}
	
	@PostMapping
	public String save(@ModelAttribute("product") @Valid ProductForm product, BindingResult br, Model model,  
			SessionStatus status, @PageableDefault Pageable pageable,  @ModelAttribute("filter") ProductFilter filter){
		if(br.hasErrors()){
			return show (model,pageable, filter);
		}
		productService.save(product);
		status.setComplete();
		return "redirect:/admin/product"+getParams(pageable, filter);
	}
	

//	@RequestMapping(method=POST)
//	public String save(@RequestParam String name, @RequestParam double price, 
//			@RequestParam int categoryId, @RequestParam int producerId,
//			@RequestParam int colorId, @RequestParam int designId, @RequestParam int materialId, @RequestParam int typeId, @RequestParam int psId){
//		productService.save(name, price, categoryId, producerId, colorId, designId, materialId, typeId, psId);
//		return "redirect:/admin/product";
//	}
	
	@InitBinder("product")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Design.class, new DesignEditor(designService));
		binder.registerCustomEditor(Material.class, new MaterialEditor(materialService));
		binder.registerCustomEditor(PhoneCompatibility.class, new PhoneCompatibilityEditor(phoneCompatibilityService));	
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Type.class, new TypeEditor(typeService));
		binder.setValidator(new ProductValidator());	
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") ProductFilter filter ) { 
		productService.deleteById(id);
		return"redirect:/admin/product"+ getParams(pageable, filter);
	}

	@RequestMapping
	private String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ProductFilter filter){
		model.addAttribute("page", productService.findAll(pageable, filter));
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("producers",producerService.getAll());
		model.addAttribute("colors", colorService.getAll());
		model.addAttribute("designs", designService.getAll());
		model.addAttribute("materials", materialService.getAll());	
		model.addAttribute("types",typeService.getAll());
		model.addAttribute("pss",phoneCompatibilityService.getAll());
		return "admin-product";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id,Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") ProductFilter filter ) {
		model.addAttribute("product", productService.findForm(id));
		return show(model,pageable,filter);
	}
	
	private String getParams(Pageable pageable, ProductFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		if(!filter.getSearch().isEmpty()){
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		if(!filter.getMaxPrice().isEmpty()){
			buffer.append("&maxPrice=");
			buffer.append(filter.getMaxPrice());
		}
		if(!filter.getMinPrice().isEmpty()){
			buffer.append("&minPrice=");
			buffer.append(filter.getMinPrice());
		}
		if(!filter.getCategoryIds().isEmpty()){
			for (int id : filter.getCategoryIds()) {
				buffer.append("&categoryIds=");
				buffer.append(id);
			}
		}
		if(!filter.getTypeIds().isEmpty()){
			for (int id : filter.getTypeIds()) {
				buffer.append("&typeIds=");
				buffer.append(id);
			}
		}
		if(!filter.getColorIds().isEmpty()){
			for (int id : filter.getColorIds()) {
				buffer.append("&colorIds=");
				buffer.append(id);
			}
		}
		if(!filter.getDesignIds().isEmpty()){
			for (int id : filter.getDesignIds()) {
				buffer.append("&designIds=");
				buffer.append(id);
			}
		}
		if(!filter.getMaterialIds().isEmpty()){
			for (int id : filter.getMaterialIds()) {
				buffer.append("&materialIds=");
				buffer.append(id);
			}
		}
		if(!filter.getPsIds().isEmpty()){
			for (int id : filter.getPsIds()) {
				buffer.append("&psIds=");
				buffer.append(id);
			}
		}
		if(!filter.getProducerIds().isEmpty()){
			for (int id : filter.getProducerIds()) {
				buffer.append("&producerIds=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
}

