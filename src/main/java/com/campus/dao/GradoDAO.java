package com.campus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.campus.model.JPAUtil;
import com.campus.model.Usuario;
import com.campus.model.Grado;

public class GradoDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

//GUARDAR GRADO	
	public void guardar(Grado grado) {
		entity.getTransaction().begin();
		entity.persist(grado);
		entity.getTransaction().commit();
	//	JPAUtil.shutdown();
		
	}
	
//EDITAR GRADO 
	public void editar(Grado grado) {
		entity.getTransaction().begin();
		entity.merge(grado); //Guarda lo que recibimos a traves de grado
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); Cerrar sesión
	}
	
//BUSCAR GRADO
	public Grado buscar(Long idgrado) {
		Grado g = new Grado();
		g = entity.find(Grado.class, idgrado);
		//JPAUtil.shutdown();  Cerrar sesión
		return g;
	}
	
//OBTENER TODOS LOS GRADOS 
	public List<Grado> obtenerGrados(){
		List<Grado> listaGrados = new ArrayList<>();
		Query  q=entity.createQuery("SELECT g FROM Grado g");
		listaGrados = q.getResultList();
		return listaGrados;
	}
	
//CONTAR LOS USUARIO DE CADA GRADO 
/*	public Grado contar(Long idgrado) {
	 Grado c = new Grado();
	 return c;
	}*/
}
