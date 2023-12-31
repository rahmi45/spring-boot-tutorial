package net.rahmi.springboottutorial.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rahmi.springboottutorial.data.dto.ProductDto;
import net.rahmi.springboottutorial.data.entity.Product;
import net.rahmi.springboottutorial.data.handler.ProductDataHandler;
import net.rahmi.springboottutorial.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService
{
	private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductDataHandler productDataHandler;
	
	@Override
	public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) 
	{
		LOGGER.info("[saveProduct] productDataHandler ");
		Product product = productDataHandler.saveProduct(productId, productName, productPrice, productStock);

	    ProductDto productDto = new ProductDto(product.getId(),
	        product.getName(), product.getPrice(), product.getStock());

	    return productDto;
	}

	@Override
	public ProductDto getProduct(String productId) 
	{
		Product product = productDataHandler.getProduct(productId);
		ProductDto productDto = new ProductDto(product.getId(),
			        product.getName(), product.getPrice(), product.getStock());
		
		return productDto;
		 
	}


}
