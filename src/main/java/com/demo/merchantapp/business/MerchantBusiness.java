package com.demo.merchantapp.business;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.merchantapp.dao.Merchant;
import com.demo.merchantapp.dao.MerchantProduct;
import com.demo.merchantapp.dao.Product;
import com.demo.merchantapp.repository.MerchantProductRepository;
import com.demo.merchantapp.repository.MerchantRepository;
import com.demo.merchantapp.vo.MerchantVO;

@Component
public class MerchantBusiness {

	@Autowired
	private MerchantRepository merchantRepository;
	@Autowired
	private MerchantProductRepository merchantProductRepository;

	public void add(MerchantVO merchantVO) {
		merchantRepository.save(Merchant.createMerchant(merchantVO));
	}

	public void update(MerchantVO merchantVO) {
		merchantRepository.update(Merchant.createMerchant(merchantVO));
	}

	public void delete(int id) {
		merchantRepository.delete(id);
	}

	public void assignMerchantToProduct(int merchandId, int productId) {
		MerchantProduct merchantProduct = new MerchantProduct(new Merchant(merchandId), new Product(productId),
				LocalDateTime.now());
		merchantProductRepository.save(merchantProduct);

	}
}
