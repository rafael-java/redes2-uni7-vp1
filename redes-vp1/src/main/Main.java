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
		
		try {
			System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: Método enviar do main");
			
			Cabo cabo1 = new Cabo();
		    Cabo cabo2 = new Cabo();
		    
			Host hostOrigem = new Host();
			PortaHost portaHost = new PortaHost("macAddresssodmfa", "ip1",hostOrigem);
			hostOrigem.setPortaHost(portaHost);
			
			Host hostDestino = new Host();
			PortaHost portaDestino = new PortaHost("macAddress2", "ip2", hostDestino);
			hostDestino.setPortaHost(portaDestino);
			
			Switch swi = new Switch();
		    List<PortaSwitch> ports = new ArrayList<PortaSwitch>();
			System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new List Porta Switch");
		    
		    PortaSwitch portaSwitch1 = new PortaSwitch("macAddress123",swi);
		    PortaSwitch portaSwitch2 = new PortaSwitch("macAddress1984721864123",swi);
		    PortaSwitch portaSwitch3 = new PortaSwitch("mackasjdlasjdo2356",swi);
		    
		    ports.add(portaSwitch1);
		    ports.add(portaSwitch2);
		    ports.add(portaSwitch3);
			System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: add Porta Switch na lista");
		    
		    swi.setPorts(ports);
		    
		    try {
		    	PortaSwitch portaDesconectada1 = swi.getPrimeiraPortaDesconectada();
				cabo1.atrelar(portaHost, portaDesconectada1);
				
				PortaSwitch portaDesconectada2 = swi.getPrimeiraPortaDesconectada();
				cabo2.atrelar(portaDestino, portaDesconectada2);	// mudar depois pra 3
			} catch (Exception e) {
				System.out.println("Error, não tem portas deconectadas");
			}
		    
		    hostOrigem.enviar(hostDestino.getPortaHost().getIp(), payload);
		    hostOrigem.enviar(hostDestino.getPortaHost().getIp(), payload+"2");
		    hostDestino.enviar(hostOrigem.getPortaHost().getIp(), payload+"@3");
		} catch (Exception e) {
			System.out.println("Error   " + e.getMessage());
		}   
	}
	

	public static void main(String[] args) {
		
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Digite um Payload:");
	    String payload = sc.nextLine();
	    
	    enviar(payload);
	    
	    sc.close(); //Encerra o scanner

	}

}
