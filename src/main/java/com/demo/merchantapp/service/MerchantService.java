package com.demo.merchantapp.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.demo.merchantapp.vo.MerchantVO;

@WebService
@SOAPBinding(style = Style.RPC)
public interface MerchantService {

	@WebMethod
	public void add(MerchantVO merchantVO);

	@WebMethod
	public void update(MerchantVO merchantVO);

	@WebMethod
	public void delete(int id);
}
