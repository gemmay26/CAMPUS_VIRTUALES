package com.campus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.campus.model.JPAUtil;
import com.campus.model.Actividad;

public class ActividadDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

//GUARDAR GRADO	
	public void guardar(Actividad actividad) {
		entity.getTransaction().begin();
		entity.persist(actividad);
		entity.getTransaction().commit();
	//	JPAUtil.shutdown();
		
	}
	
//EDITAR GRADO 
	public void editar(Actividad actividad) {
		entity.getTransaction().begin();
		entity.merge(actividad); //Guarda lo que recibimos a traves de grado
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); Cerrar sesión
	}
	
//BUSCAR GRADO
	public Actividad buscar(Long idactividad) {
		Actividad a = new Actividad();
		a = entity.find(Actividad.class, idactividad);
		//JPAUtil.shutdown();  Cerrar sesión
		return a;
	}
	
//OBTENER TODOS LOS GRADOS 
	public List<Actividad> obtenerActividad(){
		List<Actividad> listaActividad = new ArrayList<>();
		Query  q=entity.createQuery("SELECT a FROM Actividad a");
		listaActividad = q.getResultList();
		return listaActividad;
	}
	
//CONTAR LOS USUARIO DE CADA GRADO 
/*	public Grado contar(Long idgrado) {
	 Grado c = new Grado();
	 return c;
	}*/
}
