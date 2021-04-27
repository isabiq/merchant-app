package com.demo.merchantapp.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.merchantapp.business.config.SpringTestConfiguration;
import com.demo.merchantapp.config.SpringApplicationConfig;
import com.demo.merchantapp.dao.Merchant;
import com.demo.merchantapp.dao.MerchantProduct;
import com.demo.merchantapp.dao.Product;
import com.demo.merchantapp.repository.MerchantProductRepository;
import com.demo.merchantapp.repository.MerchantRepository;
import com.demo.merchantapp.vo.MerchantVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringApplicationConfig.class })
@Import(SpringTestConfiguration.class)
@ActiveProfiles("test")
public class MerchantBusinessTest {

	@Autowired
	private MerchantBusiness merchantBusiness;

	@Autowired
	private MerchantRepository merchantRepository;

	@Autowired
	private MerchantProductRepository merchantProductRepository;

	@Test
	public void testAdd() {
		LocalDateTime createDate = LocalDateTime.now();
		merchantBusiness.add(new MerchantVO(10, createDate, "David", "Dubois", LocalDate.of(1990, 12, 1)));
		Merchant merchant = merchantRepository.findById(10);
		Merchant expectedMerchant = new Merchant(10, createDate, "David", "Dubois", LocalDate.of(1990, 12, 1));
		assertThat(merchant).isEqualTo(expectedMerchant);
	}

	@Test
	public void testUpdate() {
		merchantBusiness.update(
				new MerchantVO(1, LocalDateTime.of(2020, 04, 01, 00, 00), "David", "Choi", LocalDate.of(1995, 05, 01)));
		Merchant merchant = merchantRepository.findById(1);
		assertThat(merchant.getName()).isEqualTo("David");
	}

	@Test
	public void testDelete() {
		merchantBusiness.delete(3);
		Merchant merchant = merchantRepository.findById(3);
		assertThat(merchant).isNull();
	}

	@Test
	public void testAssignMerchantToProduct() {
		merchantBusiness.assignMerchantToProduct(2, 1);
		List<Integer> productsId = merchantProductRepository.findByMerchantId(2).stream()
				.map(MerchantProduct::getProduct).map(Product::getId).collect(Collectors.toList());
		assertThat(productsId).contains(1);
	}

}
