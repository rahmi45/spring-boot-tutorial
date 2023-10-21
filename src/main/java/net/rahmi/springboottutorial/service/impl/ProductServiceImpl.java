package net.rahmi.springboottutorial.service.impl;

import org.springframework.stereotype.Service;

import net.rahmi.springboottutorial.data.dto.ProductDto;
import net.rahmi.springboottutorial.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{

	@Override
	public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}


}
