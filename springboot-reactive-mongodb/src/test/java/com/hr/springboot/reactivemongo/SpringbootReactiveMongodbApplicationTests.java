package com.hr.springboot.reactivemongo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.hr.springboot.reactivemongo.controller.ProductController;
import com.hr.springboot.reactivemongo.dto.ProductDTO;
import com.hr.springboot.reactivemongo.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
class SpringbootReactiveMongodbApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private ProductService service;
	
	@Test
	public void addProductTest()
	{
		final Mono<ProductDTO> product = Mono.just(new ProductDTO("1","Amitabh",1,100.0));
		// Set what would be returned when we call saveProduct method.
		// This will not save the object in database as this service is a mock one, not the actual one
		when(service.saveProduct(product)).thenReturn(product);

		// Call the api
		webTestClient.post().uri("/products/save")
				.body(Mono.just(product), ProductDTO.class)
				.exchange()
				.expectStatus().isOk();
		
	}
	
	@Test
	public void getProductsTest()
	{
		final Flux<ProductDTO> products = Flux.just(
				new ProductDTO("1","Amitabh",1,100.0),
				new ProductDTO("2","Hrithik",2,200.0),
				new ProductDTO("3","Abhishek",3,300.0));
		when(service.getAllProducts()).thenReturn(products);
		
		final Flux<ProductDTO> responseBody = webTestClient.get().uri("/products/all")
				.exchange()
				.expectStatus()
				.isOk()
				.returnResult(ProductDTO.class)
				.getResponseBody();
		
		StepVerifier.create(responseBody)
				.expectSubscription()
				.expectNext(new ProductDTO("1","Amitabh",1,100.0))
				.expectNext(new ProductDTO("2","Hrithik",2,200.0))
				.expectNext(new ProductDTO("3","Abhishek",3,300.0))
				.verifyComplete();
		
		
	}
	
	@Test
	public void getProductsByIdTest()
	{
		final Mono<ProductDTO> product = Mono.just(new ProductDTO("100","Amitabh",1,100.0));
		when(service.getProductByID(any())).thenReturn(product);
		
		final Flux<ProductDTO> responseBody = webTestClient.get().uri("/products/100")
				.exchange()
				.expectStatus()
				.isOk()
				.returnResult(ProductDTO.class)
				.getResponseBody();
		
		StepVerifier.create(responseBody)
				.expectSubscription()
				.expectNextMatches(e->e.getName().equals("Amitabh"))
				.verifyComplete();
		
		
	}
	
	@Test
	public void updateProductTest()
	{
		final Mono<ProductDTO> product = Mono.just(new ProductDTO("100","Amitabh",1,100.0));
		when(service.updateProduct(product,"100")).thenReturn(product);
		
		webTestClient.put().uri("/products/update/100")
				.exchange()
				.expectStatus()
				.isOk()
				.returnResult(ProductDTO.class)
				.getResponseBody();
		
	}
	
	@Test
	public void deleteProductTest()
	{
		when(service.deleteProduct("100")).thenReturn(Mono.empty());
		
		webTestClient.delete().uri("/products/delete/100")
				.exchange()
				.expectStatus()
				.isOk();
		
	}
	
	
}
