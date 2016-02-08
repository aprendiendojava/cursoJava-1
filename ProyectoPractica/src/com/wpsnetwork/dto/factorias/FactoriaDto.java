package com.wpsnetwork.dto.factorias;

import com.wpsnetwork.dao.enumerados.Objetos;
import com.wpsnetwork.dto.entidades.Autor;
import com.wpsnetwork.dto.entidades.CategoriaLibro;
import com.wpsnetwork.dto.entidades.Libro;
import com.wpsnetwork.dto.entidades.Persona;
import com.wpsnetwork.dto.entidades.Prestamo;

public abstract class FactoriaDto {
<<<<<<< HEAD
	
	public abstract Autor Autor();
	public abstract CategoriaLibro CategoriaLibro();
	public abstract Libro Libro();
	public abstract Persona Persona();
	public abstract Prestamo Prestamo();
	
	// marc lo hace similar pero lo que devuvle es un objeto Dao
	// public static Dao getFactoriaDao (String tipoAcceso , Objetos tipoObjeto){
	// y abajo hace un new AutoresDto que es el repositorio del dto (RepositorioAutoresMemoriaDto) que hay que hacer
	
	public static <Dto> Dto getFactoriaDao (String tipoAcceso , Objetos tipoObjeto){
=======
		
	public static <Dto> Dto FactoriaDto (String tipoAcceso , Objetos tipoObjeto){
>>>>>>> refs/remotes/origin/master
		
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
