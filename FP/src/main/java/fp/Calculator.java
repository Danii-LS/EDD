package fp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;

public class Calculator {

	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> fibonacciList = new ArrayList<Integer>();
		Integer suma;
		Integer num1 = 0;
		Integer num2 = 1;
		fibonacciList.add(1);
		for(int i=0; i<n-1; i++) {
			suma = num1 + num2;
			num1 = num2;
			num2 = suma;
			fibonacciList.add(suma);
		}
		
		return fibonacciList;
	}
	
	

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> numbersList = new ArrayList<>();
		while( (number - step) > 0)
			numbersList.add(number -= step);
		
		return listToArray(numbersList);
	}
	
	
	
	public static int[] listToArray(List<Integer> list) {
		int array[] = new int[list.size()];
		for(int i=0; i < list.size(); i++)
			array[i] = list.get(i);
		return array;
	}
	
	

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> divisorsList = new ArrayList<Integer>();
		int counter;
		if(n==0)
			return null;
		if(n>=0 && n<=20) {
			counter = 0;
			for(int i=20; i>0; i--)
				if(n%i == 0)
					divisorsList.add(i);
			return listToArray(divisorsList);
		}
		return new int[]{-1};	
	}
	
	
	

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		int i,j;
		if(cadena == null) 
			return false;
		
		String cadena2 = StringUtils.stripAccents(cadena).toLowerCase();
		cadena2 = cadena2.replaceAll(" ", "");
		cadena2 = cadena2.replaceAll("\\.", "");
		cadena2 = cadena2.replaceAll(",", "");
		cadena2 = cadena2.replaceAll("\\?", "");
		cadena2 = cadena2.replaceAll("\\¿", "");
		cadena2 = cadena2.replaceAll(":", "");
		cadena2 = cadena2.replaceAll("·", "");
		
		i=0;
		j = cadena2.length() - 1;	
		while(i < j) {
			if(cadena2.charAt(i) != cadena2.charAt(j)) 
				return false;
			i++;
			j--;
		}
		return true;
	}

	
	
	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String text;
		int unidad;
		int decena;
		
		unidad = n%10;
		n = n/10;
		text = unidadLetras(unidad);
		decena = n%10;
		n=n/10;
		if( (unidad==0) && (decena>0) ) 
			text = decenaLetras(decena);
		else if(decena==1) 
			text = decenas(unidad + 10);
		else if (decena > 1)
			text = decenaLetras(decena) + " y " + text.toLowerCase();
		return text;
	}
	
	// Método unidadLetras
	public static String unidadLetras(int num){
		switch(num) {
			case 0: return "Cero";
			case 1: return "Uno";
			case 2: return "Dos";
			case 3: return "Tres";
			case 4: return "Cuatro";
			case 5: return "Cinco";
			case 6: return "Seis";
			case 7: return "Siete";
			case 8: return "Ocho";
			case 9: return "Nueve";
			default: return "";
		}
	}
	
	// Método decenaLetras	
	public static String decenaLetras(int num){
		switch(num) {
			case 1: return "Diez";
			case 2: return "Veinte";
			case 3: return "Treinta";
			case 4: return "Cuarenta";
			case 5: return "Cincuenta";
			case 6: return "Sesenta";
			case 7: return "Setenta";
			case 8: return "Ochenta";
			case 9: return "Noventa";
			default: return "";
		}
	}
	
	public static String decenas(int num) {
		switch(num) {
		case 11: return "once";
		case 12: return "doce";
		case 13: return "trece";
		case 14: return "catorce";
		case 15: return "quince";
		case 16: return "dieciseis";
		case 17: return "diecisiete";
		case 18: return "dieciocho";
		case 19: return "diecinueve";
		default: return "";
		}
	}
	
	
	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if(fecha.equals("")) return false;
		DateTimeFormatter dt_formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(fecha,dt_formatter).isLeapYear();
	}

	
	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		DateFormat d_format = new SimpleDateFormat("dd-MM-yyyy");
		d_format.setLenient(false);
		try {
			d_format.parse(date);
		} catch(ParseException ex) {
			return false;
		}
		return true;
	}
	
}
