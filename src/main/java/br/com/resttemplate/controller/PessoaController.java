package br.com.resttemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/hello")
public class PessoaController {

	@RequestMapping(value="/teste", method= RequestMethod.GET)
	public String teste(){
		System.out.println("Chegou aqui !");
		return "Joao";
	}
}
