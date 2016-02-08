package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.interfaces.DaoLibros;

public class RepositorioLibrosMemoriaDao implements DaoLibros {

	private static List<Libro> listaLibros = new ArrayList<Libro>();
	
	// singleton
	
	private static RepositorioLibrosMemoriaDao repositorio ;

	private RepositorioLibrosMemoriaDao (){
	}
	
	public static RepositorioLibrosMemoriaDao getInstance (){
		if(repositorio == null)
			repositorio = new RepositorioLibrosMemoriaDao();
		return repositorio ;
	}
	
	// interfaz
	
	@Override
	public Libro getId(int id) {
		Libro r = new Libro();
		
		for (Libro a : listaLibros ){
			if  ( a.getId() == id ){
				r = a ;
			}
		}
		return r;
	}

	@Override
	public void insert(Libro obj) {
		
		boolean insertar = true ;
		
		for (Libro a : listaLibros ){
			if  (a.equals(obj)){
				insertar = false ;
			}
		}
		
		if (insertar) 		
			listaLibros.add( obj );
	}

	@Override
	public void update(Libro obj) {
		for (Libro a : listaLibros ){
			if  (a.equals(obj)){
				a.setEdicion(obj.getEdicion());
				a.setEditorial(obj.getEditorial());
				a.setPaginas(obj.getPaginas());
				a.setTitulo(obj.getTitulo());
			}
		}
	}

	@Override
	public void delete(Libro obj) {
		listaLibros.remove(obj) ;
	}

	@Override
	public List<Libro> getAll() {
		return listaLibros;
	}

}
