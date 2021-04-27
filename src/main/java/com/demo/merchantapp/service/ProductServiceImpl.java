package com.demo.merchantapp.service;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.merchantapp.business.ProductBusiness;
import com.demo.merchantapp.springcontext.SpringContext;
import com.demo.merchantapp.vo.ProductVO;

@WebService(endpointInterface = "com.demo.merchantapp.service.ProductService")
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public void add(ProductVO productVO) {
		LOGGER.debug("Add new product : {}", productVO);
		ProductBusiness productBusiness = SpringContext.getBean(ProductBusiness.class);
		productBusiness.add(productVO);
	}

	@Override
	public void update(ProductVO productVO) {
		LOGGER.debug("Update product : {}", productVO);
		ProductBusiness productBusiness = SpringContext.getBean(ProductBusiness.class);
		productBusiness.update(productVO);
	}

	@Override
	public void delete(int id) {
		LOGGER.debug("Delete product : {}", id);
		ProductBusiness productBusiness = SpringContext.getBean(ProductBusiness.class);
		productBusiness.delete(id);

	}
}
