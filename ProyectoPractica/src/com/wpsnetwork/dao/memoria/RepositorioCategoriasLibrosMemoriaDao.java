package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;


import com.wpsnetwork.dao.entidades.CategoriaLibro;
import com.wpsnetwork.dao.interfaces.DaoCategoriasLibros;

public class RepositorioCategoriasLibrosMemoriaDao implements DaoCategoriasLibros {

	private static List<CategoriaLibro> listaCategoriaLibros = new ArrayList<CategoriaLibro>();
	
	// singleton
	
	private static RepositorioCategoriasLibrosMemoriaDao repositorio ;

	private RepositorioCategoriasLibrosMemoriaDao (){
	}
	
	public static RepositorioCategoriasLibrosMemoriaDao getInstance (){
		if(repositorio == null)
			repositorio = new RepositorioCategoriasLibrosMemoriaDao();
		return repositorio ;
	}
	
	// interfaz

	@Override
	public CategoriaLibro getId(int id) {
		CategoriaLibro r = new CategoriaLibro();
		
		for (CategoriaLibro a : listaCategoriaLibros ){
			if  ( a.getId() == id ){
				r = a ;
			}
		}
		return r;
	}

	@Override
	public void insert(CategoriaLibro obj) {
		
		boolean insertar = true ;
		
		for (CategoriaLibro a : listaCategoriaLibros ){
			if  (a.equals(obj)){
				insertar = false ;
			}
		}
		
		if (insertar) 		
			listaCategoriaLibros.add( obj );
	}

	@Override
	public void update(CategoriaLibro obj) {
		for (CategoriaLibro a : listaCategoriaLibros ){
			if  (a.equals(obj)){
				a.setNombre(obj.getNombre());
			}
		}
	}

	@Override
	public void delete(CategoriaLibro obj) {
		listaCategoriaLibros.remove(obj) ;
	}

	@Override
	public List<CategoriaLibro> getAll() {
		return listaCategoriaLibros ;
	}

}
