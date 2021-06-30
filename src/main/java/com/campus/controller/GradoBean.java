package com.campus.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.campus.dao.GradoDAO;
import com.campus.dao.UsuarioDAO;
import com.campus.model.Grado;

@ManagedBean(name= "gradoBean")
@RequestScoped
public class GradoBean {

	public String nuevo() {
		Grado g = new Grado();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("grado", g);
		return "/faces/gestion_aulas/crear-grado.xhtml";
	}
	
	public String guardar(Grado grado) {
		GradoDAO gradoDAO = new GradoDAO();
		gradoDAO.guardar(grado);
		return "/faces/gestion_aulas/index.xhtml";
	}
	
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
	
	public String ver_grado(Long idgrado) {
		GradoDAO gradoDAO= new GradoDAO();
		Grado g = new Grado();
		g = gradoDAO.buscar(idgrado);
		System.out.println("***************************");
		System.out.println(g);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("grado", g);
		return "/faces/gestion_aulas/lista-cursos.xhtml";
	}
	
	
	public String actualizar(Grado grado) {
		GradoDAO gradoDAO =new GradoDAO();
		gradoDAO.editar(grado);
		return "/faces/gestion_aulas/index.xhtml";
	}
	
	public String eliminar(Long idgrado) {
		GradoDAO gradoDAO = new GradoDAO();
		gradoDAO.eliminar(idgrado);
		System.out.println("Grado eliminado...");
		return "/faces/gestion_aulas/index.xhtml";
	}
}
