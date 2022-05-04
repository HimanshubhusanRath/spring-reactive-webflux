package com.hr.springboot.reactivemongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springboot.reactivemongo.dto.ProductDTO;
import com.hr.springboot.reactivemongo.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@GetMapping("/all")
	public Flux<ProductDTO> getProducts()
	{
		return prodService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Mono<ProductDTO> getProductById(@PathVariable final String id)
	{
		return prodService.getProductByID(id);
	}
	
	@PostMapping("/save")
	public Mono<ProductDTO> saveProduct(@RequestBody Mono<ProductDTO> productDTO)
	{
		return prodService.saveProduct(productDTO);
	}
	
	@PutMapping("/update/{id}")
	public Mono<ProductDTO> updateProduct(@RequestBody final Mono<ProductDTO> productDTO, @PathVariable final String id)
	{
		return prodService.updateProduct(productDTO, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteProduct(@PathVariable final String id)
	{
		return prodService.deleteProduct(id);
	}
}
