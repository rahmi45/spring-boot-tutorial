package net.rahmi.springboottutorial.data.handler;

import net.rahmi.springboottutorial.data.entity.Product;

public interface ProductDataHandler 
{
	Product saveProduct(String theId, String theName, int thePrice, int theStock);

	Product getProduct(String theId);

}
