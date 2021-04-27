package com.demo.merchantapp.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.demo.merchantapp.vo.ProductVO;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProductService {

	@WebMethod
	public void add(ProductVO productVO);

	@WebMethod
	public void update(ProductVO productVO);

	@WebMethod
	public void delete(int id);
}
