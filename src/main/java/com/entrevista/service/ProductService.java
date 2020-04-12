package com.entrevista.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entrevista.exception.ProductDuplicatedException;
import com.entrevista.model.Product;
import com.entrevista.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private LogService logService;

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void saveProduct(Product product) throws Exception {
		Exception exception = new Exception();
		try {
			product = productRepository.save(product);
		} catch (Exception ex) {
			if(ex.getCause().getClass().equals(ConstraintViolationException.class)) {
				exception = ex;
				throw new ProductDuplicatedException();
			}
		} finally {
			logService.logProduct(product, exception);
		}
		
	}

}
