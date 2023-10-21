package net.rahmi.springboottutorial.data.dao;

import net.rahmi.springboottutorial.data.entity.Product;

public interface ProductDAO 
{
	  Product saveProduct(Product theProduct);

	  Product getProduct(String theId);
}
