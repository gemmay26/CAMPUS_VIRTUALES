package com.campus.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.campus.model.JPAUtil;
import com.campus.model.Usuario;

public class UsuarioDAO {
	EntityManager entity=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	//GUARDAR USUARIO
	public void guardar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
	//	JPAUtil.shutdown();
		
	}
	
	//EDITAR USUARIO 
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
		//JPAUtil.shutdown(); Cerrar sesión
	}
	
	//BUSCAR USUARIO
	public Usuario buscar(Long idusuario) {
		Usuario u = new Usuario();
		u = entity.find(Usuario.class, idusuario);
		//JPAUtil.shutdown();  Cerrar sesión
		return u;
	}
	
	//ELIMINAR USUARIO
	public void eliminar(Long idusuario) {
		Usuario u = new Usuario();
		u =  entity.find(Usuario.class, idusuario);
		entity.getTransaction().begin();
		entity.remove(u);
		entity.getTransaction().commit();
	}
	
	//OBTENER TODOS LOS CLIENTES 
	public List<Usuario> obtenerUsuarios(){
		List<Usuario> listaUsuarios = new ArrayList<>();
		Query  q=entity.createQuery("SELECT u FROM Usuario u");
		listaUsuarios = q.getResultList();
		return listaUsuarios;
	}
}
