package com.wpsnetwork.consola;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

import org.omg.Messaging.SyncScopeHelper;

public class Main {
	
	
	public static void main ( String[] args ) throws ClassNotFoundException, 
	                                                 NoSuchMethodException, 
	                                                 SecurityException, 
	                                                 InstantiationException, 
	                                                 IllegalAccessException, 
	                                                 IllegalArgumentException, 
	                                                 InvocationTargetException {

		/* METADATOS
		 * 
		 * 		obtener datos de claes, metodos, etc en tempo de ejecucion
		 * 
		 * 		3 clases importantes
		 * 			* Class
		 * 				-> da metadatos de una clase o interfaz
		 * 			* Method
		 * 				-> da metadatos del metodo de una clase o interfaz
		 *  		* Field
		 *  
		 *  	
		 *  	Otras clases interesantes
		 *  
		 *  		* ClassLoader
		 *  			-> permite cargar clases, librerias, etc dinamicamente
		 *  
		 *  			ClassLoader.getSystemClassLoader()
		 *  			ClassLoader.getSystemResourceAsStream(name)
		 *  
		 * 		
		 * */
			
		
		System.out.println("*************  Crear umn objeto a traves de su metadato constructor");

		Class metadatos = Class.forName("java.lang.StringBuffer" ) ;
		
		// forma alternativa 
		
		StringBuffer buffer = new StringBuffer();
		Class metadatos2 = buffer.getClass() ;
		
		// forma alternativa 2
		
		Class metadatos3 = StringBuffer.class ;
		
		// obtener el constructor de la clase que hemos definido
		
		Constructor constructor = metadatos.getConstructor(String.class) ;
		
		StringBuffer buffer2 = (StringBuffer) constructor.newInstance("Cadena inicial");
		
		/* Esto quye hemos hecho arriba no tiene mucho sentod a primera vista
		 * pero puede ser util por ejemplo si tuvieramos una clase que crea objetos
		 * de esta forma, recibiriamos el tpo de objeto a crear y tendríamos que crear un constructor , etc etc  
		 * 
		 * */
		
		
		System.out.println(buffer2.toString());
		
		// Acceso a la propiedad de una clase
		
		System.out.println("*************  Acceso a la propiedad de una clase");

		LocalDate lc = LocalDate.now() ;
		
		Class metadatoLc = lc.getClass() ;
		
		Method metodoLc = metodoGet(metadatoLc,"year") ; // me he creado un metodo para obtener el metod getAlgo
		
		// llamamos al metodo
		int año = (int) metodoLc.invoke(lc) ; 
		
		System.out.println("El año actual es: " + año);

		System.out.println("*************  Como acceder a un fichero que esta dentro de mi fichero");
		
		// -> se hace usando metadato.getResourceAsStream(name)
		
		
		System.out.println("*************  Como acceder a un fichero que esta dentro de mi fichero");
		
		/* Anotaciones
		 * 	
		 * 	+ De compilador (una vez compiladas, desaparecen)
		 * 		
		 * 		Ejemplos:
		 * 			@Override 				-> mira si existe en alguna superclase
		 * 			@Supres Warnings 		-> para eliminar ciertos warnings
		 * 			@Deprecated 			-> en el editor sale con una llinea tachada y en el compilador salta  una alerta
		 * 			@FunctionlaInterface	-> el compilador comprueba que la interfaz solo tenga un unico metodo
		 * 
		 * 	+ Anotaciones que "sobreviven" al compilador
		 * 		
		 * 		Aquí es donde crearemos nuestras propias anotaciones
		 * 
		 * */
		
		
	}

	private static Method metodoGet(Class metadato, String atributo) {
		Method metodo = null ;
		
		String trozo = Character.toUpperCase(atributo.charAt(0)) + atributo.substring(1) ;
		
		try {

			metodo = metadato.getMethod("get" + trozo) ; // si el getMiMetodoNoExiste, intentamos otra forma...
			
			/* el getMethod devuelve metodos publicos
			 * 
			 * existe un getDeclaredMethod que devuelve metodos privados...el problema es que
			 * al ser privador, no podre hacer el method.invoke
			 * 
			 * Tambien existe el getField y el getDeclaredField y un getDeclaredFields (este ultimo te devuelve
			 * todos los atributos)
			 * 
			 * Existen otros muchos metodos method.getXXXX
			 * 
			 * 
			 * */
			
		} catch (NoSuchMethodException e) {

			try {
				
				metodo = metadato.getMethod("is" + trozo) ;
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // asi puede pasar que el metodo GetMiAtributo lo tenga o no
		
		return metodo ;
	}

}
