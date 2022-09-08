package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objects.Cabo;
import objects.Host;
import objects.PortaHost;
import objects.PortaSwitch;
import objects.Switch;

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
	    
	    
	    Switch swi = new Switch();
	    
	    PortaSwitch port1 = new PortaSwitch(1,false,"macAddress123",swi);
	    PortaSwitch port2 = new PortaSwitch(1,false,"macAddress1984721864123",swi);
	    PortaSwitch port3 = new PortaSwitch(1,false,"mackasjdlasjdo2356",swi);
	    
	    List<PortaSwitch> ports = new ArrayList<PortaSwitch>();
	    
	    ports.add(port1);
	    ports.add(port2);
	    ports.add(port3);
	    
	    swi.setPorts(ports);
	    
	    //System.out.println();
	    sc.close(); //Encerra o programa
		
		
		
		
		

	}

}
