package net.rahmi.springboottutorial.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import net.rahmi.springboottutorial.data.dto.ProductDto;
import net.rahmi.springboottutorial.service.impl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTest 
{	
	@Autowired
	private MockMvc mockMvc;

	// ProductController에서 잡고 있는 Bean 객체에 대해 Mock 형태의 객체를 생성해줌
    @MockBean
    ProductServiceImpl productService;
    
    // http://localhost:8080/api/v1/product-api/product/{productId}
    @Test
    @DisplayName("get Product")
    void getProductTest() throws Exception 
    {

      // given : Mock Méthodes qui définissent ce qu'un objet doit faire dans certaines situations
      given(productService.getProduct("12315")).willReturn(
          new ProductDto("12315", "pen", 5000, 2000));

      String productId = "12315";

      // andExpect : Méthode pour vérifier si la valeur attendue est obtenue
      mockMvc.perform(
              get("/api/v1/product-api/product/" + productId))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.productId").exists()) 
          .andExpect(jsonPath("$.productName").exists())
          .andExpect(jsonPath("$.productPrice").exists())
          .andExpect(jsonPath("$.productStock").exists())
          .andDo(print());

      // verify : Vérifie si la méthode de l'objet a été exécutée
      verify(productService).getProduct("12315");
    }
    
    // http://localhost:8080/api/v1/product-api/product
    @Test
    @DisplayName("create Product")
    void createProductTest() throws Exception 
    {
      //Mock 
      given(productService.saveProduct("15871", "pen", 5000, 2000)).willReturn(
          new ProductDto("15871", "pen", 5000, 2000));

      ProductDto productDto = ProductDto.builder().productId("15871").productName("pen")
          .productPrice(5000).productStock(2000).build();
      Gson gson = new Gson();
      String content = gson.toJson(productDto);
      
      // Peut remplacer les opérations de conversion de forme (json)
      // String json = new ObjectMapper().writeValueAsString(productDto);

      mockMvc.perform(
              post("/api/v1/product-api/product")
                  .content(content)
                  .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.productId").exists())
          .andExpect(jsonPath("$.productName").exists())
          .andExpect(jsonPath("$.productPrice").exists())
          .andExpect(jsonPath("$.productStock").exists())
          .andDo(print());

      verify(productService).saveProduct("15871", "pen", 5000, 2000);
      
    }
	

}
