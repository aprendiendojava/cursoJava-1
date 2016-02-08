package com.wpsnetwork.consola;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		/* Clases para fechas
		 *	Date 	fecha en milisegundos a partir de 1/1/1970 (con jdk <=7)  (del paquete java.util, no del java.sql)
		 * 
		 *  a partir de la jdk8 se han añadido varias clases
		 *  
		 *  LocalDate 		solo la fecha
		 *  LocalTime 		solo guarda la hora
		 *  LocalDateTime 	guarda fecha y hora
		 *  ZoneDateTime 	igual que el LocalDateTime + la zona horaria
		 *  
		 *  Calendar 		manipula fechas de la clase Date
		 * 
		 *  TimeZone
		 * 
		 * Clases para intervalor 
		 *  Period 			permite almacenar un intervalo de tiempo igual o superior a dias 			
		 *  Duration  		permite almacenar un intervalo de tiempo igual o inerior a dias
		 *  		
		 * 
		 * */
		
		Date fecha = new Date (); 		// crea por defecto un objeto con la fecha y hora actual
		
		System.out.println("Fecha y hora actual: " + fecha); // aunque guarda los milisegundos, se pinta segun la conf del usuario
		
		// sumar 6 segundos a la fecha (....tipo Date OJO!)
		
		fecha.setTime(fecha.getTime() + 6000 );
		System.out.println("Fecha y hora actual + 6s: " + fecha); // aunque guarda los milisegundos, se pinta segun la conf del usuario
		
		// operar con objetos Date a través de la clase Calendar
		
		Calendar cal = Calendar.getInstance() ; // crea por defecto un objeto con la fecha y hora actual
		
		System.out.println("Cal actual: " + cal);
		System.out.println("Primer día de la semana: " + cal.getFirstDayOfWeek() );
		System.out.println("Zona horaria del cal: " + cal.getTimeZone());
		
		// como poner una fecha al objeto Calendar
		
		System.out.println("         ******       ");
		
		cal.set(2016, Calendar.FEBRUARY, 28);
		System.out.println("Cal modificado a 28 de Feb: " + cal.getTime());
		
		// añadir un día
		
		cal.add(Calendar.DAY_OF_MONTH, 2);
		System.out.println("Cal modificado a 28 y sumado 2: " + cal.getTime() );
		
		// dia de la semana de una echa dada
		System.out.println("dia de la semana: " + cal.get(Calendar.DAY_OF_WEEK));
		
		// dia de la semana de una echa dada
		System.out.println("dia de la semana: " + cal.get(Calendar.DAY_OF_WEEK));
		
		
		// Clase TimeZone
		
		System.out.println("************ Ejemplos de clase TimeZone");
		
		System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
		
		// Clase LocalDate
		
		System.out.println("************ Ejemplos de clase LocalDate");
		
		LocalDate lc = LocalDate.of(2016, Calendar.MARCH, 28) ; // NO SE PUEDE UTILIZAR EL Calendar.<nombre del mes>
		
		System.out.println(lc);
		
		/*		lc.plusDays(1) ;
		 * 		System.out.println(lc);
		 * 
		 * 	haciendo tal cual eso, no modificamos lc porque estas clases con INMUTABLEs...
		 *  tengo que reaginar el valor a la variable lc

		 * 
		 * 
		 * */	
		
		lc = lc.plusDays(2) ; // minusDays para restar

		System.out.println(lc);
		
		System.out.println("Día de la semana: " + lc.getDayOfWeek());
		System.out.println("Día del mes: " + lc.getDayOfMonth());
		System.out.println("Día del año: " + lc.getDayOfYear());
		System.out.println("Mes: " + lc.getMonth());
		System.out.println("Mes: " + lc.getMonthValue());
		System.out.println("Año: " + lc.getYear());

		// sumar semanas
		
		System.out.println("Sumando semanas...");
		
		lc = lc.plusWeeks(2) ;

		System.out.println(lc);

		System.out.println("************ Ejemplos de intervalos");
		
		Period p = Period.ofYears(1) ; // este periodo se puede utilizar para modificar una fecha
		
		lc = lc.plus(p) ;
		System.out.println("Nueva fecha sumando period: " + lc);
		
		// para utilizar Duration, tenemos que utilizar el LocalTime xq tiene los segundo, si no da una exception
		
		LocalTime hora = LocalTime.now() ;
		
		Duration d = Duration.ofHours(1) ;
		
		System.out.println("Duration: " + d );

		hora = hora.plus( d) ;
		System.out.println("Nueva fecha sumando Duration: " + hora);
		
		// otra forma de crear un duration
		
		Duration d2 = Duration.of(1, ChronoUnit.HOURS) ;
		System.out.println(d2);
		
		hora = hora.plus( d2) ;
		System.out.println("Nueva fecha sumando Duration d2: " + hora);
		
		System.out.println("************ Ejemplo de comparacion de fechas");
		
		LocalDate fecha_actual = LocalDate.now() ;
		LocalDate fecha_antigua = fecha_actual.minusDays(1) ; // dia anterior
		LocalDate fecha_futura = fecha_actual.plusDays(1) ; // dia posterior
		
		System.out.println("Resultado comparacion fechas: " + fecha_actual.isAfter(fecha_antigua));
		System.out.println("Resultado comparacion fechas: " + fecha_actual.isBefore(fecha_futura));
		
		System.out.println("************ Ejemplo de la clase LocalTime");
		
		LocalTime lt = LocalTime.now();
		LocalTime lt2 = LocalTime.of(16, 30, 55);
		
		System.out.println("Hora actual: " + lt);
		System.out.println("Hora 2: " + lt2);
		
		// modiicar localtime sumando o restando...
		
		lt = lt.minusHours(2) ;
		System.out.println("LocalTime menos 2 horas: " + lt );
		
		System.out.println("************ Ejemplo de la clase LocalDateTime");
		
		LocalDateTime ldt = LocalDateTime.of(2016, Month.FEBRUARY, 28, 16, 30 ) ;
		System.out.println("Ejemplo localDateTime: " + ldt);

		System.out.println("************ Convertir entre tipos de fechas: Date 2 LocalDateTime");
		
		Date fechaD = new Date() ;
		Instant i = fechaD.toInstant() ;
		LocalDateTime fechaLdt = LocalDateTime.ofInstant( i, ZoneId.systemDefault()) ;
		
		System.out.println("Fecha Date: " + fechaD );
		System.out.println("Fecha convertida a LocaDateTime: " + fechaLdt );
		
		System.out.println("************ Convertir entre tipos de fechas: LocalDate 2 Date");
		
		Instant instante = fechaLdt.toInstant(ZoneOffset.UTC) ; // obtenemos los milisedgundos desde 1/1/1970
		Date fechaDConvertida = Date.from(instante) ;
		System.out.println("Fecha convertida a Date: "  + fechaDConvertida );
		
		System.out.println("************ Localizacion de fechas");
		
		/* Localizacio y formateo de fechas
		 * 
		 * jdk 1.7 y anteriores
		 *  DateFormat
		 * 	SimpleDateFormat 
		 * 
		 * jdk 1.8 y superiores
		 * 	
		 * 	DateTimeFormatter
		 * 
		 * 
		 * */

		System.out.println("************ Localizacion de fechas -> Ejemplo jdk <= 1.7 con SimpleFormat");
		
		DateFormat df = DateFormat.getDateInstance() ;
		String fechaString = df.format( new Date() ) ;
		
		System.out.println("Fecha en formato locale del usuario: " + fechaString );

		Date fechaDateString = df.parse(fechaString) ;
		
		System.out.println("Formateo inverso de String a Date (utilizamos un parse): " + fechaDateString );
		
		// para el DateFormat, el problema es que tenemos que saber que formato tiene el locale y ademas no podemos camvbiarlo
		// para enmendar esto, esta la SimpleDateFormat
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy HH24:mm") ;
		System.out.println("Fecha sdf: " + sdf );
		System.out.println("Fecha sdf: " + sdf.format(new Date() ) );
		
		System.out.println("************ Localizacion de fechas -> Ejemplo jdk >= 1.8 con DateTimeFormatter");
		
		System.out.println("Fecha actual con DateTimeFormatter: " + fecha_actual.format(DateTimeFormatter.ISO_LOCAL_DATE)  );
		
		// si ese no es el que queremos, tambien podemos crear el que nosotros queramos
		
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT) ;
		System.out.println( "fecha actual formateada: " + fecha_actual.format(dtf));
		
		// no hace falta que definamos el dtf...podemos ponerlo directamente en el format
		System.out.println( "fecha actual formateada: " + fecha_actual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println( "fecha actual formateada: " + fecha_actual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		
		// tambien podemos crear nuestro propio formato de fechas...
		
		DateTimeFormatter manual_dtf = DateTimeFormatter.ofPattern("dd/MMMM/YYYY", Locale.ENGLISH) ;
		System.out.println( "fecha actual formateada: " + fecha_actual.format(manual_dtf));
		
		/* FORMATEO  de numeros y de monedas
		 * 
		 * Clase NumberFormat
		 * 
		 * */

		System.out.println("************ Formateo de numeros y de monedas");
		
		NumberFormat nf = NumberFormat.getInstance() ;
		System.out.println("Formateando un numero...: " + nf.format(1234500.2346) );
		
		NumberFormat nfCurrency = NumberFormat.getCurrencyInstance() ;
		System.out.println("Formateando un numero con moneda: " + nfCurrency.format(1234500.2356) );
		
		// tambien podemos pasarle un locale

		NumberFormat nfCurrencyLocale = NumberFormat.getCurrencyInstance(Locale.UK) ;
		System.out.println("Formateando un numero con moneda y locale: " + nfCurrencyLocale.format(1234500.2356) );
		
		double numero = (Double) nf.parse("23,45") ;
		System.out.println("Parse de un numero...: " + numero);
		
	}

}
