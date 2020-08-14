package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("miServicioSimple") //Esto indica que es una instacia singleton
//  Un componente debe tener un constructor sin parámetros, o se toma el por defecto sin parámetros, también se puede tener un constructor anotado con Autowired y que en los atributos se haga la inyección . 
//    El contenedor gestiona las instancias y usa el patrón ServiceLocator.
// @Service - También se puede con esta anotación - Indica que es lógica de negocio
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante Simple....";
	}

}
