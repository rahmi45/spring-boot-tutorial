package net.rahmi.springboottutorial.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.rahmi.springboottutorial.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> 
{

}
