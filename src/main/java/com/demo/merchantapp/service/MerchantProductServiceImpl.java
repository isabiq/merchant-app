package com.demo.merchantapp.service;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.merchantapp.business.MerchantBusiness;
import com.demo.merchantapp.springcontext.SpringContext;

@WebService(endpointInterface = "com.demo.merchantapp.service.MerchantProductService")
public class MerchantProductServiceImpl implements MerchantProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MerchantProductServiceImpl.class);

	@Override
	public void assignMerchantToProduct(int merchantId, int productId) {
		LOGGER.debug("Add new merchant : {} and {}", merchantId, productId);
		MerchantBusiness merchantBusiness = SpringContext.getBean(MerchantBusiness.class);
		merchantBusiness.assignMerchantToProduct(merchantId, productId);

	}

}
