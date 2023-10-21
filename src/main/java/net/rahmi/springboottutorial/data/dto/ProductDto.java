package net.rahmi.springboottutorial.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.rahmi.springboottutorial.data.entity.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto 
{
	private String productId;
	private String productName;
	private int productPrice;
	private int productStock;
	
	public Product toEntity()
	{
	    return Product.builder()
	        .id(productId)
	        .name(productName)
	        .price(productPrice)
	        .stock(productStock)
	        .build();
	}

}
