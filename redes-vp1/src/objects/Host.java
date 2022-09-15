package objects;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Host {

	private HashMap<String, String> tabArp = new HashMap<>();
	private HashMap<String, Porta> tabEnc = new HashMap<>();
	private PortaHost portaHost;
	private Queue<Pacote> fila =  new LinkedList<Pacote>();
	
	public Host() {
		System.out.println("PARA CHECAR NO DIAGRAMA DE SEQUENCIA: new Host");
	}

	public void enviar(String ipDestino, String payload) {
		System.out.println("Host.enviar(String ipDestino, String payload)");
		System.out.println("Host -> new Pacote(this.portaHost.getMacAddress(), this.portaHost.getIp(), ipDestino, payload)");
		Pacote pkg = new Pacote(this.portaHost.getMacAddress(), this.portaHost.getIp(), ipDestino, payload);
		System.out.println("Host <-- pkg");
		System.out.println("Host -> Host.buscarARP(ipDestino)");
		String macDestino = buscarARP(ipDestino);
		System.out.println("Host <-- macDestino");
		System.out.println("Host - Critica, macDestino != null");
		if(macDestino != null) {
			System.out.println("Host -> pkg.setMacDestino(macDestino)");
			pkg.setMacDestino(macDestino);
			
			System.out.println("Host -> portaHost.enviar(pkg)");
			this.portaHost.enviar(pkg);
		} else {
			
			System.out.println("Host -> New Pacote(this.portaHost.getMacAddress(), \"FF:FF:FF:FF:FF:FF\", this.portaHost.getIp(), ipDestino, true) ");
			Pacote arpPkg = new Pacote(this.portaHost.getMacAddress(), "FF:FF:FF:FF:FF:FF", this.portaHost.getIp(), ipDestino, true);
			System.out.println("Host <-- arpPkg");
			System.out.println("Host -> adicionar pacote na fila");
			fila.add(pkg); // Adiciona na Fila o Pacote para que fique na espera de um ArpReply
			
			
			System.out.println("Host -> portaHost.enviar(arpPkg");
			this.portaHost.enviar(arpPkg);
		}		
	}
	
	public void receber(Pacote pacote, PortaHost portaHost) {
		
		System.out.println("PortaHost ->  Host.receber(pacote, portaHost)");
		
		System.out.println("Host ->  Host.tabEnc.put(MacOrigem, portaHost)");
		System.out.println("Host ->  Host.tabArp.put(IpOrigem, MacOrigem)");
		
		this.tabEnc.put(pacote.getMacOrigem(), portaHost);
		this.tabArp.put(pacote.getIpOrigem(), pacote.getMacOrigem());

		
		System.out.println("Host -> ler(pacote)");

		ler(pacote);
	}
	
	public void ler(Pacote pacote) {
		
		if (pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF") && pacote.getPayload().equals("Request") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
			System.out.println("Host - Critica (pacote.getMacDestino().equals(\"FF:FF:FF:FF:FF:FF\") && pacote.getPayload().equals(\"Request\") && pacote.getIpDestino().equals(this.portaHost.getIp())");
			System.out.println("Host -> New Pacote(this.portaHost.getMacAddress(), \"FF:FF:FF:FF:FF:FF\", this.portaHost.getIp(), ipDestino, true) ");	
			Pacote pReply =  new Pacote(this.portaHost.getMacAddress(), pacote.getMacOrigem(), this.portaHost.getIp(), pacote.getIpOrigem(), false);	
			System.out.println("Host <-- rReply");
			
			System.out.println("Host -> PortaHost.enviar(pReply)");
			this.portaHost.enviar(pReply);
			}
		
		else if(pacote.getPayload().equals("Reply") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
			System.out.println("Host - Critica (pacote.getPayload().equals(\"Reply\") && pacote.getIpDestino().equals(this.portaHost.getIp()))");
			for (Pacote pacote2 : fila) {
				pacote2 = fila.poll();
				System.out.println("Se tiver item na fila, desinfilera");
				System.out.println("Host -> Host.enviar(IpDestino, Payload)");
				this.enviar(pacote2.getIpDestino(), pacote2.getPayload());
			}
		} else {
			System.out.println("PARA TESTE: Recebendo Pacote Original");
			System.out.println("PARA TESTE: Host:"+this.portaHost.getMacAddress());
			System.out.println("PARA TESTE: Pacote Payload " + pacote.getPayload());
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
