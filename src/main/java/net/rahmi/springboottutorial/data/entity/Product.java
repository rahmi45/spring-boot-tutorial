package net.rahmi.springboottutorial.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.rahmi.springboottutorial.data.dto.ProductDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "product")
public class Product extends BaseEntity 
{
	@Id
	private String id;

	private String name;

	private Integer price;

	private Integer stock;

	public ProductDto toDto() 
	{
		return ProductDto.builder()
				.productId(id)
				.productName(name)
				.productPrice(price)
				.productStock(stock)
				.build();
	}

}
