package net.rahmi.springboottutorial.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		  info = @Info(
		  title = "Code-First Spring-boot tutorial",
		  description = "" +
		    "Apprendre à coder une API REST ...",
		  contact = @Contact(
		    name = "Reflectoring", 
		    url = "https://reflectoring.io", 
		    email = "petros.stergioulas94@gmail.com"
		  ),
		  license = @License(
		    name = "MIT Licence", 
		    url = "https://github.com/thombergs/code-examples/blob/master/LICENSE")),
		  servers = @Server(url = "http://localhost:9090")
		)
public class OpenAPIConfiguration {

}
