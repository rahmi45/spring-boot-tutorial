package net.rahmi.springboottutorial.service;

import net.rahmi.springboottutorial.data.dto.ProductDto;

public interface ProductService 
{
	ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

	ProductDto getProduct(String productId);
}
