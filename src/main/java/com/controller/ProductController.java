package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

@RestController
public class ProductController{

	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(method = RequestMethod.POST, value = "/product")
	public ProductEntity addProduct(@RequestBody ProductEntity product) {
		
		productRepository.save(product);
		return product;
	}
	
	@GetMapping("/product")
	public List<ProductEntity> getAllProducts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{productId}")
	public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
		Optional<ProductEntity> proOptional = productRepository.findById(productId);
		if(proOptional.isEmpty()) {
			return null;
		}
		else {
			return proOptional.get();
		}
	}
	
	@GetMapping("/productbyname/{name}")
	public List<ProductEntity> getProductByName(@PathVariable("name")String name){
		return productRepository.findByName(name);
	}
	
	@DeleteMapping("/product/{productId}")
	public ProductEntity deleteProductId(@PathVariable("productId")Integer productId) {
		
		Optional<ProductEntity> proOptional = productRepository.findById(productId);
		
		if(proOptional.isEmpty()) {
			return null;
		}else {
			ProductEntity productEntity = proOptional.get();
			productRepository.deleteById(productId);
			return productEntity;
		
		}
	}
	
}
