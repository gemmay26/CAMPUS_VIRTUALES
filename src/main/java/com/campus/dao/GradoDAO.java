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

//EDITAR USUARIO 
	public void editar(Grado grado) {
		entity.getTransaction().begin();
		entity.merge(grado);
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); Cerrar sesión
	}
	
//BUSCAR USUARIO
	public Grado buscar(Long idgrado) {
		Grado g = new Grado();
		g = entity.find(Grado.class, idgrado);
		//JPAUtil.shutdown();  Cerrar sesión
		return g;
	}
	
//OBTENER TODOS LOS CLIENTES 
	public List<Grado> obtenerGrados(){
		List<Grado> listaGrados = new ArrayList<>();
		Query  q=entity.createQuery("SELECT g FROM Grado g");
		listaGrados = q.getResultList();
		return listaGrados;
	}
}
