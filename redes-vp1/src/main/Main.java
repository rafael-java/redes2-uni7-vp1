package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objects.Cabo;
import objects.Host;
import objects.Porta;
import objects.PortaHost;
import objects.PortaSwitch;
import objects.Switch;

public class Main {
	
	public static void enviar(String payload) {
		
		Cabo cabo1 = new Cabo();
	    Cabo cabo2 = new Cabo();
	    
		Host hostOrigem = new Host("macAddress", "ip1");
		PortaHost portaHost = new PortaHost(0, "macAddress", hostOrigem);
		hostOrigem.setPortaHost(portaHost);
		
		Host hostDestino = new Host("macAddress2", "ip2");
		PortaHost portaDestino = new PortaHost(1, "macAddress2", hostDestino);
		hostDestino.setPortaHost(portaDestino);
		
		Switch swi = new Switch();
	    List<PortaSwitch> ports = new ArrayList<PortaSwitch>();
	    
	    PortaSwitch portaSwitch1 = new PortaSwitch(2,"macAddress123",swi);
	    PortaSwitch portaSwitch2 = new PortaSwitch(3,"macAddress1984721864123",swi);
	    PortaSwitch portaSwitch3 = new PortaSwitch(4,"mackasjdlasjdo2356",swi);
	    
	    ports.add(portaSwitch1);
	    ports.add(portaSwitch2);
	    ports.add(portaSwitch3);
	    
	    swi.setPorts(ports);
	    
	    try {
	    	PortaSwitch portaDesconectada1 = swi.getPrimeiraPortaDesconectada();
			cabo1.atrelar(portaHost, portaDesconectada1);
			
			PortaSwitch portaDesconectada2 = swi.getPrimeiraPortaDesconectada();
			cabo2.atrelar(portaDestino, portaDesconectada2);	// mudar depois pra 3
		} catch (Exception e) {
			System.out.println("Error, não tem portas deconectadas");
		}
				
	}
	

	public static void main(String[] args) {
		
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Digite um Payload:");
	    sc.nextLine();
	    String payload = sc.nextLine();
	    
	    enviar(payload);
	    
	    //System.out.println();
	    sc.close(); //Encerra o programa

	}

}
