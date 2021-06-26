package com.campus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.campus.dao.GradoDAO;
import com.campus.dao.UsuarioDAO;
import com.campus.model.Grado;
import com.campus.model.Usuario;

@ManagedBean(name= "gradoBean")
@RequestScoped
public class GradoBean {
//MENU
	public String home() {
		return "/faces/index.xhtml";
	}
	public String gestion_alumnos() {
		return "/faces/gestion_alumnos/index.xhtml";
	}
	public String gestion_aulas() {
		return "/faces/gestion_aulas/index.xhtml";
	}
	public String gestion_calificaciones() {
		return "/faces/g_calificaciones.xhtml";
	}
	//////
	
	public List<Grado> obtenerGrados(){
		GradoDAO gradoDAO= new GradoDAO();
		return gradoDAO.obtenerGrados();
	}
	
	public String editar(Long idgrado) {
		GradoDAO gradoDAO= new GradoDAO();
		Grado g = new Grado();
		g = gradoDAO.buscar(idgrado);
		System.out.println("***************************");
		System.out.println(g);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("grado", g);
		return "/faces/gestion_aulas/editar-grado.xhtml";
	}
	
	public String actualizar(Grado grado) {
		GradoDAO gradoDAO =new GradoDAO();
		gradoDAO.editar(grado);
		return "/faces/gestion_aulas/index.xhtml";
	}
	
}
