package main;
import java.util.Scanner;

import objects.Cabo;
import objects.Host;
import objects.PortaHost;

public class Main {
	
	public static void enviar(String payload) {
		Host hostOrigem = new Host("macAddress", "ip");
		
		PortaHost portaHost = new PortaHost(0, true, "macAddress");
		
		hostOrigem.setPortaHost(portaHost);
		
		
				
		Cabo cabo = new Cabo(null, null);
	}
	
	
	

	public static void main(String[] args) {
		
		String payload = "";
		int i = 0;
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Digite um Payload:");
	    payload = sc.nextLine();
	    //System.out.println();
	    sc.close(); //Encerra o programa
		
		
		
		
		

	}

}
