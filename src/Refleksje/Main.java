package Refleksje;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Class.forName("com.mysql.jdbc.Driver");
		
		//Refleksja
		try {
			Class<?> mojaKlasa = Class.forName("Refleksje.Data");
			
			System.out.println("GET DECLARED METHODS: ");
			for(Method m : mojaKlasa.getDeclaredMethods()){
				System.out.println("Nazwa: " + m.getName());
			}
			//getMethods nie zwraca prywatnej klasy
			System.out.println("GET METHODS: ");
			for(Method m : mojaKlasa.getMethods()){
				System.out.println("Nazwa: " + m.getName());
			}
		
			System.out.println("________________");
			
			//pdoejscuie standardowe
			Data mojObiekt = new Data();
			String imie = mojObiekt.returnName("Standardowo");
			System.out.println(imie);
			
			for(Method m : mojaKlasa.getMethods()){
				//System.out.println(m.getName());
				for(Class<?> c : m.getParameterTypes())
				{
					System.out.println("Metoda: " + m.getName() + ", par: " + c.getName());
				}
			}
			
			
			//konstrukotry tez mozemy za pomoca refleksj i tworzyc
			//refleksja
			try {
				Object konstruktor = mojaKlasa.newInstance();
				Method funkcja = konstruktor.getClass().getMethod("returnName", String.class);
				Object wynik = funkcja.invoke(konstruktor, "Ciag znakow przekazany");
				System.out.println(wynik);
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
