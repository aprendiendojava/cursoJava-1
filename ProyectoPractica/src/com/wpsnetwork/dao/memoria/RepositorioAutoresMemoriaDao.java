package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Autor;
import com.wpsnetwork.dao.interfaces.DaoAutores;

public class RepositorioAutoresMemoriaDao implements DaoAutores {
	
	private static List<Autor> listaAutores = new ArrayList<Autor>();
	
	// singleton
	
	private static RepositorioAutoresMemoriaDao repositorio ;

	private RepositorioAutoresMemoriaDao (){
	}
	
	public static RepositorioAutoresMemoriaDao getInstance (){
		if(repositorio == null)
			repositorio = new RepositorioAutoresMemoriaDao();
		return repositorio ;
	}
	
	// interfaz

	@Override
	public Autor getId(int id) {
		Autor r = new Autor();
		
		for (Autor a : listaAutores ){
			if  ( a.getId() == id ){
				r = a ;
			}
		}
		return r;
	}

	@Override
	public void insert(Autor obj) {
		
		boolean insertar = true ;
		
		for (Autor a : listaAutores ){
			if  (a.equals(obj)){
				insertar = false ;
			}
		}
		
		if (insertar) 		
			listaAutores.add( obj );
	}

	@Override
	public void update(Autor obj) {
		for (Autor a : listaAutores ){
			if  (a.equals(obj)){
				a.setNombre(obj.getNombre());
			}
		}
	}

	@Override
	public void delete(Autor obj) {
		listaAutores.remove(obj) ;
	}

	@Override
	public List<Autor> getAll() {
		return listaAutores;
	}

}
