package com.wpsnetwork.visualizacion.consola;

import com.wpsnetwork.dao.enumerados.Objetos;
import com.wpsnetwork.dao.factorias.FactoriaDao;
import com.wpsnetwork.dto.entidades.Autor;

public class Consola {

	public static void main(String[] args) {
		
		String tipoAcceso = "MEMORIA" ;
		
		Autor autor = new Autor();
		autor = (Autor) FactoriaDao.getObjetoDao(tipoAcceso, Objetos.AUTOR) ;
		
		// inicializar 
		
		autor.setId(1);
		autor.setNombre("Paco Umbral");
		autor.setLibros(null);
		
		// 
		
	}

}
