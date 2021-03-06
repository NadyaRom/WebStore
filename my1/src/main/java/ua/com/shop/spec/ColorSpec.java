package ua.com.shop.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.BasicFilter;
import ua.com.shop.entity.Color;

public class ColorSpec implements Specification<Color>{
	
private final BasicFilter filter;
	
	public ColorSpec(BasicFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Color> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
		if(filter.getSearch().isEmpty()) 
			return null;
		return arg2.like(arg2.lower(arg0.get("name")), filter.getSearch().toLowerCase()+"%");
	}


}
