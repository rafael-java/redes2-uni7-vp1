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
	
	public static void enviar(String payload, String ipDestino) {
		
		try {
			System.out.println("Método enviar do main");
			
			Cabo cabo1 = new Cabo();
		    
			Host hostOrigem = new Host();
			PortaHost portaOrigem = new PortaHost("macAddresssodmfa", "ip1",hostOrigem);
			hostOrigem.setPortaHost(portaOrigem);

			Switch swi = new Switch();
		    List<PortaSwitch> switchPorts = new ArrayList<PortaSwitch>();
			System.out.println("new List Porta Switch");
		    
		    PortaSwitch portaSwitch1 = new PortaSwitch("macAddress123",swi);
		    PortaSwitch portaSwitch2 = new PortaSwitch("macAddress1984721864123",swi);
		    PortaSwitch portaSwitch3 = new PortaSwitch("mackasjdlasjdo2356",swi);
		    
		    switchPorts.add(portaSwitch1);
		    switchPorts.add(portaSwitch2);
		    switchPorts.add(portaSwitch3);
			System.out.println("Add Porta Switch na lista");
		    
		    swi.setPorts(switchPorts);
		    
		    Cabo cabo2 = new Cabo();

			Host hostDestino = new Host();
			PortaHost portaDestino = new PortaHost("macAddress2", "ip2", hostDestino);
			hostDestino.setPortaHost(portaDestino);
			
		    
		    try {
		    	System.out.println("PortaSwitch portaDesconectada1 = swi.getPrimeiraPortaDesconectada()");
		    	PortaSwitch portaDesconectada1 = swi.getPrimeiraPortaDesconectada();
				cabo1.atrelar(portaOrigem, portaDesconectada1);
				
				PortaSwitch portaDesconectada2 = swi.getPrimeiraPortaDesconectada();
				cabo2.atrelar(portaDestino, portaDesconectada2);	// mudar depois pra 3
			} catch (Exception e) {
				System.out.println("Error, não tem portas deconectadas");
			}
		    
		    hostOrigem.enviar(ipDestino, payload);
		    hostOrigem.enviar(ipDestino, payload+"2");
		    hostDestino.enviar(ipDestino, payload+"@3");
		} catch (Exception e) {
			System.out.println("Error   " + e.getMessage());
		}   
	}
	

	public static void main(String[] args) {
		
//	    Scanner sc = new Scanner(System.in);
//	    System.out.print("Digite um Payload:");
//	    String payload = sc.nextLine();
	    
	    enviar("a","ip2");
	    
//	    System.out.print("Digite um ip:");

	    
//	    sc.close(); //Encerra o scanner

	}

}
