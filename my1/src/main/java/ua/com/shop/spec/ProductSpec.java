package ua.com.shop.spec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.dto.filter.ProductFilter;
import ua.com.shop.entity.Product;

public class ProductSpec implements Specification<Product>{

	private ProductFilter filter;
	
	private List<Predicate> predicates = new ArrayList<>();
	
	public ProductSpec(ProductFilter filter) {
		this.filter=filter;
	}
	
	private void filterByPrice(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
			if(filter.getMax()!=null&&filter.getMin()!=null){
				predicates.add(cb.between(root.get("price"), filter.getMin(), filter.getMax()));
			}else if(filter.getMax()!=null){
				predicates.add(cb.lessThanOrEqualTo(root.get("price"), filter.getMax()));
			}else if(filter.getMin()!=null){
				predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filter.getMin()));
			}
		}
	
	private void filterBySearch(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("name"), filter.getSearch()+"%"));
		}
	}
//	public ProductSpec(ProductFilter filter) {
//		this.filter = filter;
//		if(PATTERN.matcher(filter.getMaxPrice()).matches()){
//			filter.setMax(new BigDecimal(filter.getMaxPrice().replace(',', '.')));
//		}
//		if(PATTERN.matcher(filter.getMinPrice()).matches()){
//			filter.setMin(new BigDecimal(filter.getMinPrice().replace(',', '.')));
//		}
//	}		
	
	private void filterByCategory(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getCategoryIds().isEmpty()){
			predicates.add(root.get("category").in(filter.getCategoryIds()));
		}
	}
	
	private void filterByType(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getTypeIds().isEmpty()){
			predicates.add(root.get("type").in(filter.getTypeIds()));
		}
	}
	
	private void filterByColor(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getColorIds().isEmpty()){
			predicates.add(root.get("color").in(filter.getColorIds()));
		}
	}
	private void filterByDesign(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getDesignIds().isEmpty()){
			predicates.add(root.get("design").in(filter.getDesignIds()));
		}
	}
	
	private void filterByMaterial(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getMaterialIds().isEmpty()){
			predicates.add(root.get("material").in(filter.getMaterialIds()));
		}
	}
	
	private void filterByProducer(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getProducerIds().isEmpty()){
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}
	
	private void filterByPs(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getPsIds().isEmpty()){
			predicates.add(root.get("phoneCompatibility").in(filter.getPsIds()));
		}
	}
	
	
	
	private void fetch(Root<Product> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("category");
			root.fetch("type");
			root.fetch("color");
			root.fetch("design");
			root.fetch("material");
			root.fetch("phoneCompatibility");
			root.fetch("producer");
			
		}
	}
			
	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		filterBySearch(root, query, cb);
		filterByPrice(root, query, cb);
		filterByCategory(root, query, cb);
		filterByColor(root, query, cb);
		filterByDesign(root, query, cb);
		filterByMaterial(root, query, cb);
		filterByProducer(root, query, cb);
		filterByType(root, query, cb);
		filterByPs(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}
	

}
