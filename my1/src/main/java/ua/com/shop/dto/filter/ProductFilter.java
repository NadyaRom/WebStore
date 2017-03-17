package ua.com.shop.dto.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ProductFilter {
	
	private static final Pattern PEATTERN = Pattern.compile("[0-9]+");

	private String search = "";
	
	private String maxPrice = "";
	
	private String minPrice = "";
	
	private Integer max;
	
	private Integer min;
	
	private List<Integer> typeIds = new ArrayList<>();

	private List<Integer> designIds = new ArrayList<>();
	
	private List<Integer> materialIds = new ArrayList<>();

	private List<Integer> colorIds = new ArrayList<>();

	private List<Integer> psIds = new ArrayList<>();
	
	private List<Integer> producerIds = new ArrayList<>();
	
	private List<Integer> categoryIds = new ArrayList<>();

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(PEATTERN.matcher(maxPrice).matches())max = Integer.valueOf(maxPrice);
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(PEATTERN.matcher(minPrice).matches())min = Integer.valueOf(minPrice);
		this.minPrice = minPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public List<Integer> getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(List<Integer> typeIds) {
		this.typeIds = typeIds;
	}

	public List<Integer> getDesignIds() {
		return designIds;
	}

	public void setDesignIds(List<Integer> designIds) {
		this.designIds = designIds;
	}

	public List<Integer> getMaterialIds() {
		return materialIds;
	}

	public void setMaterialIds(List<Integer> materialIds) {
		this.materialIds = materialIds;
	}

	public List<Integer> getColorIds() {
		return colorIds;
	}

	public void setColorIds(List<Integer> colorIds) {
		this.colorIds = colorIds;
	}

	public List<Integer> getPsIds() {
		return psIds;
	}

	public void setPsIds(List<Integer> psIds) {
		this.psIds = psIds;
	}

	public List<Integer> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public static Pattern getPeattern() {
		return PEATTERN;
	}

	

}
