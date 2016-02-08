package com.wpsnetwork.dto;

import java.util.List;

import com.wpsnetwork.dao.enumerados.Objetos;
import com.wpsnetwork.dao.factorias.FactoriaDao;
import com.wpsnetwork.dto.entidades.Autor;;

public class AutoresDto {
	
	// los atributos deben ser los mismos que los de las clases dto.entidades.Autor
	
	private int id;
	private String nombre ;
	private List<com.wpsnetwork.dto.entidades.Libro> libros;

	public AutoresDto( String tipoAcceso ) {
		
		// inicializar el tipo Autor y asignar a las variables del paquete
		Autor autor = new Autor();
		
		// creo que lo siguiente esta mal
		autor = (Autor) FactoriaDao.getObjetoDao(tipoAcceso, Objetos.AUTOR) ;
		
		setId(autor.getId()) ;
		setNombre(autor.getNombre()) ;

		// inicializar todos los libros y luego filtrar por los del autor
		
		List<com.wpsnetwork.dto.entidades.Libro> totallibros = FactoriaDao.getObjetoDao(tipoAcceso, Objetos.LIBRO).getAll();
		
		setLibros(totallibros) ;
		
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<com.wpsnetwork.dto.entidades.Libro> getLibros() {
		return libros;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLibros(List<com.wpsnetwork.dto.entidades.Libro> libros) {
		this.libros = libros;
	}


}
