package objects;

import java.util.ArrayList;
import java.util.List;

public final class Singleton {

	private static Singleton instance;
	private static String value;
	private static List<String> values;

	private Singleton(List<String> values) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:Singleton(List<String> values)");
		this.values = values;
	}

	public static Singleton getInstance() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:  Singleton getInstance()");
		if (instance == null) {
			List<String> values = new ArrayList<String>();
			instance = new Singleton(values);
		}
		return instance;
	}

	public static boolean checkIfExists(String value) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: checkIfExists(String value)");
		if (values.contains(value)) {
			return true;
		} else {
			values.add(value);
			return false;
		}
	}

	public static boolean checkIfExists(Integer value) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: checkIfExists(Integer value)");
		String val = value.toString();
		return checkIfExists(val);		
	}

}
