package com.wpsnetwork.dao.memoria;

import java.util.ArrayList;
import java.util.List;

import com.wpsnetwork.dao.entidades.Libro;
import com.wpsnetwork.dao.entidades.Persona;
import com.wpsnetwork.dao.interfaces.DaoPersonas;

public class RepositorioPersonasMemoriaDao implements DaoPersonas {

	private static List<Persona> listaPersonas = new ArrayList<Persona>();
	
	// singleton
	
	private static RepositorioPersonasMemoriaDao repositorio ;

	private RepositorioPersonasMemoriaDao (){
	}
	
	public static RepositorioPersonasMemoriaDao getInstance (){
		if(repositorio == null)
			repositorio = new RepositorioPersonasMemoriaDao();
		return repositorio ;
	}
	
	// interfaz

	@Override
	public Persona getId(int id) {
		Persona r = new Persona();
		
		for (Persona a : listaPersonas ){
			if  ( a.getId() == id ){
				r = a ;
			}
		}
		return r;
	}

	@Override
	public void insert(Persona obj) {
		
		boolean insertar = true ;
		
		for (Persona a : listaPersonas ){
			if  (a.equals(obj)){
				insertar = false ;
			}
		}
		
		if (insertar) 		
			listaPersonas.add( obj );
	}

	@Override
	public void update (Persona obj) {
		for (Persona a : listaPersonas ){
			if  (a.equals(obj)){
				a.setNombre(obj.getNombre());
				a.setCodigoPostal(obj.getCodigoPostal());
				a.setDireccion(obj.getDireccion());
				a.setDni(obj.getDni());
				a.setFechaNacimiento(obj.getFechaNacimiento());
				a.setPais(obj.getPais());
				a.setProvincia(obj.getProvincia());
				a.setTelefono(obj.getTelefono());
			}
		}
	}

	@Override
	public void delete(Persona obj) {
		listaPersonas.remove(obj) ;
	}

	@Override
	public List<Persona> getAll() {
		return listaPersonas;
	}

}
