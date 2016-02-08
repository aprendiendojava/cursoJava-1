package com.wpsnetwork.dao.factorias;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.enumerados.Objetos;
import com.wpsnetwork.dao.interfaces.Dao;

public class FactoriaDao {
	
	public static Dao getObjetoDao(String tipoAcceso , Objetos tipoObjeto){
		
		Dao r = null ;
		
		if (tipoAcceso == "MEMORIA")
			switch (tipoObjeto){
				case LIBRO:
					r = (Dao) new Libro() ;
				case AUTOR:
					r = (Dao) new Autor() ;
				case PERSONA:
					r = (Dao) new Persona() ;
				case PRESTAMO:
					r = (Dao) new Prestamo() ;
				case CATEGORIA:
					r = (Dao) new CategoriaLibro() ;
			}
		
		return r ;
		
	}
	
}
