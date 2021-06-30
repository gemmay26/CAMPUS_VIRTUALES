package com.campus.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.campus.dao.GrupoDAO;
import com.campus.model.Grupo;

@ManagedBean(name= "grupoBean")
@RequestScoped
public class GrupoBean {

	public String nuevo() {
		Grupo g = new Grupo();
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("grupo", g);
		return "/faces/gestion_aulas/crear-grupo.xhtml";
	}
	
	public String guardar(Grupo grupo) {
		GrupoDAO grupoDAO = new GrupoDAO();
		grupoDAO.guardar(grupo);
		return "/faces/gestion_aulas/index.xhtml";
	}
		
	public List<Grupo> obtenerGrupos(){
		GrupoDAO grupoDAO= new GrupoDAO();
		return grupoDAO.obtenerGrupos();
	}
	
	public String editar(Long idgrupo) {
		GrupoDAO grupoDAO= new GrupoDAO();
		Grupo g = new Grupo();
		g = grupoDAO.buscar(idgrupo);
		System.out.println("***************************");
		System.out.println(g);
		Map<String, Object> sessionMap=FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("grupo", g);
		return "/faces/gestion_aulas/editar-grupo.xhtml";
	}
	
	public String actualizar(Grupo grupo) {
		GrupoDAO grupoDAO =new GrupoDAO();
		grupoDAO.editar(grupo);
		return "/faces/gestion_aulas/index.xhtml";
	}
}
