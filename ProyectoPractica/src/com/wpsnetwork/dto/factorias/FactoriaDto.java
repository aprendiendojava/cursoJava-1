package com.wpsnetwork.dto.factorias;

import com.wpsnetwork.dto.entidades.Autor;
import com.wpsnetwork.dto.entidades.CategoriaLibro;
import com.wpsnetwork.dto.entidades.Libro;
import com.wpsnetwork.dto.entidades.Persona;
import com.wpsnetwork.dto.entidades.Prestamo;
import com.wpsnetwork.dao.enumerados.Objetos;
import com.wpsnetwork.interfaces.Dao;

public abstract class FactoriaDto {
	
	public abstract Autor Autor();
	public abstract CategoriaLibro CategoriaLibro();
	public abstract Libro Libro();
	public abstract Persona Persona();
	public abstract Prestamo Prestamo();
	
	public static <Dto> Dto getFactoriaDao (String tipoAcceso , Objetos tipoObjeto){
		
		Dto r = null ;
		
		if (tipoAcceso == "MEMORIA")
			switch (tipoObjeto){
				case LIBRO:
					r = (Dto) new Libro() ;
				case AUTOR:
					r = (Dto) new Autor() ;
				case PERSONA:
					r = (Dto) new Persona() ;
				case PRESTAMO:
					r = (Dto) new Prestamo() ;
				case CATEGORIA:
					r = (Dto) new CategoriaLibro() ;
			}
		
		return r ;
		
	}
}
