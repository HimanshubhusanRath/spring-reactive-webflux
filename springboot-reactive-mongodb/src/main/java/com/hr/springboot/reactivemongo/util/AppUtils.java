package com.hr.springboot.reactivemongo.util;

import org.springframework.beans.BeanUtils;

import com.hr.springboot.reactivemongo.dto.ProductDTO;
import com.hr.springboot.reactivemongo.entity.Product;

public class AppUtils {

	public static ProductDTO convertEntityToDto(final Product product)
	{
		final ProductDTO dest = new ProductDTO();
		BeanUtils.copyProperties(product, dest);
		return dest;
	}
	
	public static Product convertDtoToEntity(final ProductDTO product)
	{
		final Product dest = new Product();
		BeanUtils.copyProperties(product, dest);
		return dest;
	}
}
