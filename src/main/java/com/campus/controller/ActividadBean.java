package com.campus.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.campus.dao.ActividadDAO;
import com.campus.model.Actividad;


@ManagedBean(name= "actividadBean")
@RequestScoped
public class ActividadBean {

	public String nuevo() {
		Actividad a = new Actividad();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("actividad", a);
		return "/faces/gestion_aulas/crear-actividad.xhtml";
	}
	
	public String guardar(Actividad actividad) {
		ActividadDAO actividadDAO = new ActividadDAO();
		actividadDAO.guardar(actividad);
		return "/faces/gestion_aulas/index.xhtml";
	}
	
	public List<Actividad> obtenerActividad(){
		ActividadDAO actividadDAO= new ActividadDAO();
		return actividadDAO.obtenerActividad();
	}
	
	public String editar(Long idactividad) {
		ActividadDAO actividadDAO= new ActividadDAO();
		Actividad a = new Actividad();
		a = actividadDAO.buscar(idactividad);
		System.out.println("***************************");
		System.out.println(a);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("actividad", a);
		return "/faces/gestion_aulas/editar-actividad.xhtml";
	}
	
	public String actualizar(Actividad actividad) {
		ActividadDAO actividadDAO =new ActividadDAO();
		actividadDAO.editar(actividad);
		return "/faces/gestion_aulas/index.xhtml";
	}
	
}
