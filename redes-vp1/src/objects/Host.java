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
	}

	public void enviar(String ipDestino, String payload) {
		
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
		}
		
		this.portaHost.enviar(pkgToSend);
	}
	
	public void receber(Pacote pacote, PortaHost portaHost) {
		this.tabEnc.put(pacote.getMacOrigem(), portaHost);
		this.tabArp.put(pacote.getIpOrigem(),pacote.getMacOrigem());

		ler(pacote);
	}
	
	public void ler(Pacote pacote) {
		if(pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF")) {
			if(pacote.getPayload().equals("Request") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
				Pacote pReply =  new Pacote(this.portaHost.getMacAddress(), pacote.getMacOrigem(), this.portaHost.getIp(), pacote.getIpOrigem(), false);
				this.portaHost.enviar(pReply);
			}
			
			
		}
		else if(pacote.getPayload().equals("Reply") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
			for (Pacote pacote2 : fila) {
				pacote2 = fila.poll();
				this.enviar(pacote2.getIpDestino(), pacote2.getPayload());
			}
		} else {
			System.out.println("Recebendo Pacote Original");
			System.out.println("Host:"+this.portaHost.getMacAddress());
			System.out.println("Pacote Payload " + pacote.getPayload());
		}
		
		// Ao Receber o ArpReply optivemos por ser unicast
	}
	
	private String buscarARP(String ip) {
		String buscado = this.tabArp.get(ip);
		return buscado;
	}
	
	private Porta buscarEnc(String macAddress) {
		Porta buscado = this.tabEnc.get(macAddress);
		return buscado;
	}

	
	public HashMap<String, String> getTabArp() {
		return tabArp;
	}

	public void setTabArp(HashMap<String, String> tabArp) {
		this.tabArp = tabArp;
	}

	public HashMap<String, Porta> getTabEnc() {
		return tabEnc;
	}

	public void setTabEnc(HashMap<String, Porta> tabEnc) {
		this.tabEnc = tabEnc;
	}

	public PortaHost getPortaHost() {
		return portaHost;
	}

	public void setPortaHost(PortaHost portaHost) {
		this.portaHost = portaHost;
	}

	public Queue<Pacote> getFila() {
		return fila;
	}

	public void setFila(Queue<Pacote> fila) {
		this.fila = fila;
	}
	
}
