package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Prestamo;
import com.wpsnetwork.dao.interfaces.DaoPrestamos;

public class RepositorioPrestamosMemoriaDao implements DaoPrestamos {

	private static List<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
	
	// singleton
	
	private static RepositorioPrestamosMemoriaDao repositorio ;

	private RepositorioPrestamosMemoriaDao (){
	}
	
	public static RepositorioPrestamosMemoriaDao getInstance (){
		if(repositorio == null)
			repositorio = new RepositorioPrestamosMemoriaDao();
		return repositorio ;
	}
	
	// interfaz

	@Override
	public Prestamo getId(int id) {
		Prestamo r = new Prestamo();
		
		for (Prestamo a : listaPrestamos ){
			if  ( a.getId() == id ){
				r = a ;
			}
		}
		return r;
	}

	@Override
	public void insert(Prestamo obj) {
		
		boolean insertar = true ;
		
		for (Prestamo a : listaPrestamos ){
			if  (a.equals(obj)){
				insertar = false ;
			}
		}
		
		if (insertar) 		
			listaPrestamos.add( obj );
	}

	@Override
	public void update(Prestamo obj) {
		for (Prestamo a : listaPrestamos ){
			if  (a.equals(obj)){			
				a.setDevuelto(obj.isDevuelto());
				a.setFechaFin(obj.getFechaFin());
				a.setFechaInicio(obj.getFechaInicio());
				a.setLibro(obj.getLibro());
				a.setPersona(obj.getLibro());
			}
		}
	}

	@Override
	public void delete(Prestamo obj) {
		listaPrestamos.remove(obj) ;
	}

	@Override
	public List<Prestamo> getAll() {
		return listaPrestamos;
	}

}
