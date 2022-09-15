package objects;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Host {
	System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:Host");

	private HashMap<String, String> tabArp = new HashMap<>();
	private HashMap<String, Porta> tabEnc = new HashMap<>();
	private PortaHost portaHost;
	private Queue<Pacote> fila =  new LinkedList<Pacote>();
	
	public Host() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new Host");
	}

	public void enviar(String ipDestino, String payload) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: enviar (host)");

		Pacote pkg = new Pacote(this.portaHost.getMacAddress(), this.portaHost.getIp(), ipDestino, payload);
		String macDestino = buscarARP(ipDestino);
		Pacote pkgToSend = null;
		if(macDestino != null) {
			pkgToSend = pkg;
			pkg.setMacDestino(macDestino);
		} else {
			Pacote arpPkg = new Pacote(this.portaHost.getMacAddress(), "FF:FF:FF:FF:FF:FF", this.portaHost.getIp(), ipDestino, true);
			pkgToSend = arpPkg;
			fila.add(pkg); // Adiciona na Fila o Pacote para que fique na espera de um ArpReply
			System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: adicionar pacote na fila");
		}
		
		this.portaHost.enviar(pkgToSend);
	}
	
	public void receber(Pacote pacote, PortaHost portaHost) {
		this.tabEnc.put(pacote.getMacOrigem(), portaHost);
		this.tabArp.put(pacote.getIpOrigem(),pacote.getMacOrigem());

		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: receber");

		ler(pacote);
	}
	
	public void ler(Pacote pacote) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: ler pacote");
		if(pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF")) {
			if(pacote.getPayload().equals("Request") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
				Pacote pReply =  new Pacote(this.portaHost.getMacAddress(), pacote.getMacOrigem(), this.portaHost.getIp(), pacote.getIpOrigem(), false);
				this.portaHost.enviar(pReply);
				System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: Enviar request arp");

			}
			
		}
		else if(pacote.getPayload().equals("Reply") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
			for (Pacote pacote2 : fila) {
				pacote2 = fila.poll();
				this.enviar(pacote2.getIpDestino(), pacote2.getPayload());
				System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: Enviar reply arp");
			}
		} else {
			System.out.println("Recebendo Pacote Original");
			System.out.println("Host:"+this.portaHost.getMacAddress());
			System.out.println("Pacote Payload " + pacote.getPayload());
		}
		
		// Ao Receber o ArpReply optivemos por ser unicast
	}
	
	private String buscarARP(String ip) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: buscar arp (host)");
		String buscado = this.tabArp.get(ip);
		return buscado;
	}
	
	private Porta buscarEnc(String macAddress) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: buscar enc (host)");
		Porta buscado = this.tabEnc.get(macAddress);
		return buscado;
	}

	
	public HashMap<String, String> getTabArp() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:HashMap<String, String> getTabArp()");
		return tabArp;
	}

	public void setTabArp(HashMap<String, String> tabArp) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setTabArp(HashMap<String, String> tabArp)");
		this.tabArp = tabArp;
	}

	public HashMap<String, Porta> getTabEnc() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:HashMap<String, Porta> getTabEnc()");
		return tabEnc;
	}

	public void setTabEnc(HashMap<String, Porta> tabEnc) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setTabEnc(HashMap<String, Porta> tabEnc)");
		this.tabEnc = tabEnc;
	}

	public PortaHost getPortaHost() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:PortaHost getPortaHost()");
		return portaHost;
	}

	public void setPortaHost(PortaHost portaHost) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setPortaHost(PortaHost portaHost)");
		this.portaHost = portaHost;
	}

	public Queue<Pacote> getFila() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:Queue<Pacote> getFila()");
		return fila;
	}

	public void setFila(Queue<Pacote> fila) {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA:setFila(Queue<Pacote> fila)");
		this.fila = fila;
	}
	
}
