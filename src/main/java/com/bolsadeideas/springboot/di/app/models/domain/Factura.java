package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@RequestScope //Cada usuario conectado tendrá su propia factura, dura durante el request
//@SessionScope //Contexto de sesión, ejemplo para un carro de compra, finaliza cuando hay timeout o se invalida la sesión, debe implementar Serializable
//@ApplicationScope  //Muy similar al singleton, pero se guarda en el servlet context. Es común que haya un server context por defecto en las aplicaciones
public class Factura implements Serializable {

	private static final long serialVersionUID = 946004357128146951L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct  //Ejecuta después de contruir el objeto e inyectar las dependencias
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat(" María"));
		descripcion = descripcion.concat(" Agregando una descripción adicional");
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
}
