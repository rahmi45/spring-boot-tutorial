package net.rahmi.springboottutorial.data.handler.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rahmi.springboottutorial.data.dao.ProductDAO;
import net.rahmi.springboottutorial.data.entity.Product;
import net.rahmi.springboottutorial.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler
{
	private final Logger LOGGER = LoggerFactory.getLogger(ProductDataHandlerImpl.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public Product saveProduct(String theId, String theName, int thePrice, int theStock) {
		LOGGER.debug("[saveProduct] : Création de l'objet product via les paramètres");
        Product product = new Product(theId, theName, thePrice,
        		theStock);

        LOGGER.info("[saveProduct] : Demande de stockage d'informations sur le produit avec productDAO. theId : {}", theId);
        return productDAO.saveProduct(product);
		
	}

	@Override
	public Product getProduct(String theId) {
		 LOGGER.info("[saveProductEntity] : Demander des informations sur le produit avec productDAO. theId : {}", theId);
	     return productDAO.getProduct(theId);
	}

}
