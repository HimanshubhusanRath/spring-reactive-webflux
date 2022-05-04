package com.hr.springboot.reactivemongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.springboot.reactivemongo.dto.ProductDTO;
import com.hr.springboot.reactivemongo.repo.ProductRepository;
import com.hr.springboot.reactivemongo.util.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	
	public Flux<ProductDTO> getAllProducts()
	{
		return productRepo.findAll().map(AppUtils::convertEntityToDto);
	}
	
	public Mono<ProductDTO> getProductByID(final String id)
	{
		return productRepo.findById(id).map(AppUtils::convertEntityToDto);
	}
	
	public Mono<ProductDTO> saveProduct(final Mono<ProductDTO> prodDTO)
	{
		return prodDTO.map(AppUtils::convertDtoToEntity)
				.flatMap(productRepo::insert)
				.map(AppUtils::convertEntityToDto);
	}
	
	public Mono<ProductDTO> updateProduct(final Mono<ProductDTO> prodDTO, final String id)
	{
		return productRepo.findById(id)
				.flatMap(p -> prodDTO.map(AppUtils::convertDtoToEntity)) // copy the content of request to the existing record 
				.doOnNext(e -> e.setId(id)) // Update the ID in the record
				.flatMap(productRepo::save)
				.map(AppUtils::convertEntityToDto);
	}
	
	public Mono<Void> deleteProduct(final String id)
	{
		return productRepo.deleteById(id);
	}
	
	
	
}
