package com.demo.merchantapp.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.merchantapp.business.ProductBusiness;
import com.demo.merchantapp.business.config.SpringTestConfiguration;
import com.demo.merchantapp.config.SpringApplicationConfig;
import com.demo.merchantapp.dao.Product;
import com.demo.merchantapp.repository.ProductRepository;
import com.demo.merchantapp.vo.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringApplicationConfig.class })
@Import(SpringTestConfiguration.class)
@ActiveProfiles("test")
public class ProductBusinessTest {

	@Autowired
	private ProductBusiness productBusiness;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testAdd() {
		LocalDateTime createDate = LocalDateTime.now();
		productBusiness.add(new ProductVO(10, createDate, "car", 2000, "EUR", 2000, 200));
		Product product = productRepository.findById(10);
		Product expectedProduct = new Product(10, createDate, "car", 2000, "EUR", 2000, 200);
		assertThat(product).isEqualTo(expectedProduct);
	}

	@Test
	public void testUpdate() {
		productBusiness.update(new ProductVO(1, LocalDateTime.of(2020, 04, 4, 00, 00), "mobile", 200, "EUR", 20, 30));
		Product product = productRepository.findById(1);
		assertThat(product.getLabel()).isEqualTo("mobile");
	}

	@Test
	public void testDelete() {
		productBusiness.delete(3);
		Product product = productRepository.findById(3);
		assertThat(product).isNull();
	}

}
