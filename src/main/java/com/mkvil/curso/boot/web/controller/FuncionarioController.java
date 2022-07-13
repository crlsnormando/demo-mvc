package com.mkvil.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkvil.curso.boot.domain.Cargo;
import com.mkvil.curso.boot.domain.Funcionario;
import com.mkvil.curso.boot.domain.UF;
import com.mkvil.curso.boot.service.CargoService;
import com.mkvil.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		
		return "/funcionario/lista";
	}
	
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addAttribute("success", "Funcionário inserido com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
		
	}
	
}
