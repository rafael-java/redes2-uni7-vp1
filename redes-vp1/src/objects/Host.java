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
		System.out.println("Host enviando...");
		Pacote pkg = new Pacote(this.portaHost.getMacAddress(), this.portaHost.getIp(), ipDestino, payload);

		String macDestino = buscarARP(ipDestino);

		if(macDestino != null) {
			System.out.println("Encontrado o Mac Destino na ARP table...");
			pkg.setMacDestino(macDestino);
			
			this.portaHost.enviar(pkg);
		} else {
			
			System.out.println("Não encontrado o Mac Destino na ARP table...");

			Pacote arpPkg = new Pacote(this.portaHost.getMacAddress(), "FF:FF:FF:FF:FF:FF", this.portaHost.getIp(), ipDestino, true);

			System.out.println("Adicionando o pacote anterior em fila de pacotes do Host...");
			fila.add(pkg);
			
			this.portaHost.enviar(arpPkg);
		}		
	}
	
	public void receber(Pacote pacote, PortaHost portaHost) {
		
		System.out.println("Host recebendo o pacote...");
		
		System.out.println("Colocando na ENC table os dados do \"acusado\"...");
		this.tabEnc.put(pacote.getMacOrigem(), portaHost);
		
		System.out.println("Colocando na ARP table os dados do \"acusado\"...");
		this.tabArp.put(pacote.getIpOrigem(), pacote.getMacOrigem());

		ler(pacote);
	}
	
	public void ler(Pacote pacote) {
		
		System.out.println("Host lendo o pacote...");

		if (pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF") && pacote.getPayload().equals("Request") && pacote.getIpDestino().equals(this.portaHost.getIp())) {
			System.out.println("Pacote é um ARP request, e o host é o destinatário...");
			Pacote pReply =  new Pacote(this.portaHost.getMacAddress(), pacote.getMacOrigem(), this.portaHost.getIp(), pacote.getIpOrigem(), false);	
			
			this.portaHost.enviar(pReply);
			}
		
		else if(pacote.getPayload().equals("Reply")) {
			System.out.println("Host recebeu um pacote reply, será que isso atualizou algo para os pacotes que estavam na fila? Vamos ver...");
			for (Pacote pacote2 : fila) {
				pacote2 = fila.poll();
				System.out.println("Há pacote na fila, obtendo pacote...");
				System.out.println("Tentando o envio...");
				this.enviar(pacote2.getIpDestino(), pacote2.getPayload());
			}
		} else {
			System.out.println("O host é o destinatario ou o receptor, não é papel da camada de enlace lidar com isso");
			System.out.println("PARA TESTE: Host:"+this.portaHost.getMacAddress());
			System.out.println("PARA TESTE: Pacote Payload " + pacote.getPayload());
		}
		
		// Ao Receber o ArpReply optivemos por ser unicast
	}
	
	private String buscarARP(String ip) {
		System.out.println("Buscando na ARP table do host...");
		return this.tabArp.get(ip);
	}
	
	private Porta buscarEnc(String macAddress) {
		System.out.println("Buscando na ENC table do host...");
		return this.tabEnc.get(macAddress);
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
