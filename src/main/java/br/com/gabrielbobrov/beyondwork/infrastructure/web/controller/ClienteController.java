package br.com.gabrielbobrov.beyondwork.infrastructure.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gabrielbobrov.beyondwork.application.serice.ClienteService;
import br.com.gabrielbobrov.beyondwork.domain.cliente.Cliente;
import br.com.gabrielbobrov.beyondwork.domain.cliente.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	//metodo deve estar na public controller
	@GetMapping("/cadastro")
	public String home(@ModelAttribute("cliente") Cliente cliente,Model model) {
		
		return "/cliente-cadastro";
	}
	@PostMapping("/save")
	public String cadastro( @ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/cliente-cadastro";
		}
		clienteService.saveCliente(cliente);
		
		return "/cliente-cadastro";
	}

}
