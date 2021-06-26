package com.campus.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	/***METODO DE CONEXION A NUESTRA UNIDAD DE PRESISTENCIA ***/
	
	private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory==null) {
			factory=Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		return factory;				
	}
	
	//Cierra conexion
	public static void shutdown() {
		if (factory!=null) {
			factory.close();
		}		
	}

}
