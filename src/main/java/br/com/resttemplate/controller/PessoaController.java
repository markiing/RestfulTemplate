package br.com.resttemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.resttemplate.model.Pessoa;


@RestController
@RequestMapping("/hello")
public class PessoaController {

	@RequestMapping(value="/teste", method= RequestMethod.GET)
	public @ResponseBody Pessoa teste(){
		Pessoa p = new Pessoa(1, "Marcus Cartágenes", "06058838312");
		return p;
	}
}
