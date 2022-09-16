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
	
	public static void enviar() {
		
		try {
			System.out.println("Iniciando...");
			
			System.out.println("Criando cabo 1...");
			Cabo cabo1 = new Cabo();
		    
			System.out.println("Criando host origem...");
			Host hostOrigem = new Host();
			
			System.out.println("Criando porta host origem...");
			PortaHost portaOrigem = new PortaHost("00:00:5e:00:53:af", "3.99.169.224",hostOrigem);
			hostOrigem.setPortaHost(portaOrigem);

			System.out.println("Criando switch...");
			Switch swi = new Switch();
			
			System.out.println("Criando lista de portas do switch...");
		    List<PortaSwitch> switchPorts = new ArrayList<PortaSwitch>();
			
			for(Integer i=0;i<=2;i++) {
				Integer j = i + 5;
				System.out.println("Criando e adicionando porta switch na lista de portas do switch...");

				PortaSwitch portaSwitch1 = new PortaSwitch("a"+j.toString()+":f7:df:6c:94:3"+i.toString(),swi);
				switchPorts.add(portaSwitch1);
			}
		    
		    swi.setPorts(switchPorts);
		    
		    System.out.println("Criando cabo 2...");
		    Cabo cabo2 = new Cabo();

		    System.out.println("Criando host destino...");
			Host hostDestino = new Host();
			
			System.out.println("Criando porta host destino...");
			PortaHost portaDestino = new PortaHost("fc:5e:e0:68:ce:94", "150.30.79.5", hostDestino);
			
			hostDestino.setPortaHost(portaDestino);
			
		    try {
		    	PortaSwitch portaDesconectada1 = swi.getPrimeiraPortaDesconectada();
				cabo1.atrelar(portaOrigem, portaDesconectada1);
				
				PortaSwitch portaDesconectada2 = swi.getPrimeiraPortaDesconectada();
				cabo2.atrelar(portaDestino, portaDesconectada2);	// mudar depois pra 3
			} catch (Exception e) {
				System.out.println("Error    Não tem portas deconectadas...");
			}
		    
	    	Scanner sc = new Scanner(System.in);

		    while (true) {
		    	System.out.println();
		    	System.out.println("Necessitamos de inputs...");
			    System.out.print("Digite um Payload, ou xxx para sair: ");
			    String payload = sc.nextLine();
			    
			    if (payload.equals("xxx")) {
			    	System.out.println("Saindo...");
			    	sc.close();
			    	break;
			    }
			    
			    System.out.print("Digite um IP de destino (pode digitar 1 para default): ");
			    String ipDestino = sc.nextLine();
			    
			    if (ipDestino.equals("1")) {
			    	ipDestino = "150.30.79.5";
			    }
			    
			    System.out.println("");
			    System.out.println("");
			    
			    hostOrigem.enviar(ipDestino, payload);
			    
			    System.out.println("Continuando...");
		    }
		    
		} catch (Exception e) {
			System.out.println("Error   " + e.getMessage());
		}   
	}
	

	public static void main(String[] args) {
		enviar();
	}

}
