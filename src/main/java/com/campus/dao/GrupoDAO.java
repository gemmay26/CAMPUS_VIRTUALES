package com.campus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.campus.model.Grado;
import com.campus.model.Grupo;
import com.campus.model.JPAUtil;

public class GrupoDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();

//EDITAR USUARIO 
	public void editar(Grupo grupo) {
		entity.getTransaction().begin();
		entity.merge(grupo);
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); Cerrar sesión
	}
	
//BUSCAR USUARIO
	public Grupo buscar(Long idgrupo) {
		Grupo g = new Grupo();
		g = entity.find(Grupo.class, idgrupo);
		//JPAUtil.shutdown();  Cerrar sesión
		return g;
	}
	
//OBTENER TODOS LOS CLIENTES 
	public List<Grupo> obtenerGrupos(){
		List<Grupo> listaGrupos = new ArrayList<>();
		Query  q=entity.createQuery("SELECT g FROM Grupo g");
		listaGrupos = q.getResultList();
		return listaGrupos;
	}
}
