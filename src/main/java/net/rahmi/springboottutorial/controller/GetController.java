package net.rahmi.springboottutorial.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.rahmi.springboottutorial.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController 
{

	   //http:localhost:8080/api/v1/get-api/hello
		@GetMapping("/hello")
		String getHello() 
		{
			return "Hello rachid !";
		}
		
		//http:localhost:8080/api/v1/get-api/name
		@GetMapping("/name")
		String getName() 
		{
			return "Rachid";
		}
		
		//http:localhost:8080/api/v1/get-api/variable1/{String rahmi}
		@GetMapping("/variable1/{variable}")
		String getVariable1(@PathVariable String variable) 
		{
			return variable;
		}

		//http:localhost:8080/api/v1/get-api/variable2/{String ipconfig}
		@GetMapping("/variable2/{variable}")
		String getVariable2(@PathVariable("variable") String var) 
		{
			return var;
		}
		
		//http://localhost:8080/api/v1/get-api/request1?name=rahmi&email=test.api@gmail.com&organization=net.Rahmi
		//http://localhost:8080/api/v1/get-api/request1?email=test.api@gmail.com&name=rachid&organization=net.Rahmi
	    @GetMapping(value = "/request1")
	    public String getRequestParam1(
	        @RequestParam String name,
	        @RequestParam String email,
	        @RequestParam String organization) {
	        return name + " " + email + " " + organization;
	    }
	    
	    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
	    @GetMapping(value = "/request2")
	    public String getRequestParam2(@RequestParam Map<String, String> param) {
	        StringBuilder sb = new StringBuilder();

	        param.entrySet().forEach(map -> {
	            sb.append(map.getKey() + " : " + map.getValue() + "\n");
	        });

	    //param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));

	        return sb.toString();
	    }
	    
	    //http://localhost:8080/api/v1/get-api/request3?name=rachid&email=rahmi.rachid@gmail.com&organization=net.rahmi
	    @GetMapping(value="/request3")
	    public String getRequestParam3(MemberDTO memberDTO){
	        //return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization();
	        return memberDTO.toString();
	    }

}
