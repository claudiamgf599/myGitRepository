package com.bolsadeideas.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
//@Primary  //Esto se usa para que esta implementación concreta sea escogida de primera
public class MiServicioComplejo implements IServicio {

	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante Complejo....";
	}

}
