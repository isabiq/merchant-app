package com.demo.merchantapp.service;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.merchantapp.business.MerchantBusiness;
import com.demo.merchantapp.springcontext.SpringContext;
import com.demo.merchantapp.vo.MerchantVO;

@WebService(endpointInterface = "com.demo.merchantapp.service.MerchantService")
public class MerchantServiceImpl implements MerchantService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MerchantServiceImpl.class);

	@Override
	public void add(MerchantVO merchantVO) {
		LOGGER.debug("Add new merchant : {}", merchantVO);
		MerchantBusiness merchantBusiness = SpringContext.getBean(MerchantBusiness.class);
		merchantBusiness.add(merchantVO);
	}

	@Override
	public void update(MerchantVO merchantVO) {
		LOGGER.debug("Update merchant : {}", merchantVO);
		MerchantBusiness merchantBusiness = SpringContext.getBean(MerchantBusiness.class);
		merchantBusiness.update(merchantVO);
	}

	@Override
	public void delete(int id) {
		LOGGER.debug("Delete merchant : {}", id);
		MerchantBusiness merchantBusiness = SpringContext.getBean(MerchantBusiness.class);
		merchantBusiness.delete(id);

	}
}
