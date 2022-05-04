package com.hr.springboot.reactivemongo.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.hr.springboot.reactivemongo.entity.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}
