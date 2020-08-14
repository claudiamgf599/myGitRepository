package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.services.IServicio;
import com.bolsadeideas.springboot.di.app.models.services.MiServicio;

@Controller
public class IndexController {

	//private MiServicio servicio = new MiServicio();
	
	//Se desacopla el new, haciendo inyección de dependencia
	/*
	@Autowired
	private MiServicio servicio;
	*/
	
	//Cuando ya se desacopla de una clase concreta, y se usan interfaces, es mejor
	//Inyecta la primera implementación concreta que existe, pero si hay varias, debe especificar 
	//Inyección en el atributo
	@Autowired
	@Qualifier("miServicioSimple")  //Permite inyectar a través del componente en específico, por encima del Primary
	private IServicio servicio;
	
	//Se puede inyectar la dependencia en el constructor - No es necesaria la anotación Autowired cuando es desde el constructor
	/*
	@Autowired
	public IndexController(IServicio servicio) {
		this.servicio = servicio;
	}
	*/

	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

	//Se puede inyectar la dependencia en el set
	/*
	@Autowired
	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}
	*/
	
	
}
