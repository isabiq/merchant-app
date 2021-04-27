package com.demo.merchantapp.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.merchantapp.dao.Product;
import com.demo.merchantapp.repository.ProductRepository;
import com.demo.merchantapp.vo.ProductVO;

@Component
public class ProductBusiness {

	@Autowired
	private ProductRepository productRepository;

	public void add(ProductVO productVO) {
		productRepository.save(Product.createProduct(productVO));
	}

	public void update(ProductVO productVO) {
		productRepository.update(Product.createProduct(productVO));
	}

	public void delete(int id) {
		productRepository.delete(id);
	}
}
