package net.rahmi.springboottutorial.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rahmi.springboottutorial.data.dao.ProductDAO;
import net.rahmi.springboottutorial.data.entity.Product;
import net.rahmi.springboottutorial.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product theProduct) {
		productRepository.save(theProduct);
		return theProduct;
	}

	@Override
	public Product getProduct(String theId) {
		
		@SuppressWarnings("deprecation")
		Product theProduct = productRepository.getById(theId);
		
		return theProduct;
	}

}
