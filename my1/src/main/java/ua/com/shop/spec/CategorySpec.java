package ua.com.shop.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Category;

public class CategorySpec implements Specification<Category>  {
	
	private final BasicFilter filter;
	
	public CategorySpec(BasicFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(cb.lower(root.get("name")), filter.getSearch().toLowerCase()+"%");
	}

}
