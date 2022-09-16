package objects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Switch {

	private Queue<Pacote> fila = new LinkedList<Pacote>();
	// IP, MAC
	private Map<String, String> tabArp = new HashMap<>();
	// MAC, Porta
	private Map<String, PortaSwitch> tabEnc = new HashMap<>();
	private List<PortaSwitch> ports;
	// Lista de Porta

	public Switch() {
		System.out.println("new Switch()");
	}

	public PortaSwitch getPrimeiraPortaDesconectada() throws NullPointerException {
		System.out.println("PortaSwitch <-- Switch.getPrimeiraPortaDesconectada()");
		System.out.println("Pode lançar uma excessão");

		for (PortaSwitch porta : this.ports) {
			System.out.println("for each porta in this.ports");
			System.out.println("boolean <-- porta.getLigado()");
			if (!porta.getLigado()) {
				return porta;
			}
		}
		
		throw new NullPointerException();
	}

	public void receber(Pacote pacote, PortaSwitch portaSwitch) {
		System.out.println("void <-- Switch.receber(Pacote pacote, PortaSwitch portaSwitch))");

		// ENC - IP, Porta
		// ARP - MAC, IP
		// 1. Adiciona na Tabela Enc e Tabela Arp, respectivamente o Mac Address/Porta e
		// Ip/Mac Address
		System.out.println("Switch -> this.tabEnc.put(pacote.getMacOrigem(), portaSwitch)");
		this.tabEnc.put(pacote.getMacOrigem(), portaSwitch);
		System.out.println("Switch -> this.tabArp.put(pacote.getIpOrigem(),pacote.getMacOrigem())");
		this.tabArp.put(pacote.getIpOrigem(),pacote.getMacOrigem());

		// 2. caso seja FFF no mac Destino, verifica-se na Tabela Arp caso nao
		// verifica-se na Tabela Enc
		// 3. Apos verificar-se na tabela, caso esteja na tabela executa o
		// encaminhamento caso nao executa BroadCast
		System.out.println("bool <-- pacote.getMacDestino()");
		if (pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF")) {
			System.out.println("Switch -> this.broadcast(pacote)");
			this.broadcast(pacote);
		} else {
			System.out.println("Switch -> this.buscarARP(pacote.getIpDestino()");
			String macDes = this.buscarARP(pacote.getIpDestino());

			if (macDes == null) {
				System.out.println("Switch -> this.broadcast(pacote)");
				this.broadcast(pacote);
			} else {
				System.out.println("porta <-- Switch -> this.buscarEnc(macDes)");
				PortaSwitch porta = this.buscarEnc(macDes);
				
				if (porta == null) {
					this.broadcast(pacote);
				} 
				
				else {
					System.out.println("Switch -> this.encaminhar(pacote, porta)");
					this.encaminhar(pacote, porta);
				}
			}
		}
	}
	
	private void encaminhar(Pacote pacote, PortaSwitch Porta) {
		System.out.println("Switch.encaminhar(Pacote pacote, PortaSwitch Porta))");

		// Enviar Pacote para PortaSwitch recebida.
		System.out.println("Switch -> Porta.enviar(pacote)");
		Porta.enviar(pacote);
	}

	private void broadcast(Pacote pacote) {
		System.out.println("Switch.broadcast(Pacote pacote)");

		// Enviar para todas as Portas do Switch o Pacote, Executando um Flooding na
		// rede, Lembrando que
		// nao espera-se resposta de ninguem.

		for (PortaSwitch portaSwitch : this.getPorts()) {
		System.out.println("for each porta in this.getPorts");
			if(portaSwitch.getCabo() != null) {
				System.out.println("Switch -> this.encaminhar(pacote, portaSwitch)");
				this.encaminhar(pacote, portaSwitch);
			}
			
		}
	}
	
	private String buscarARP(String ip) {
		System.out.println("Switch.buscarARP(String ip)");

		System.out.println("Switch -> this.tabArp.get(ip)");
		String buscado = this.tabArp.get(ip);
		
		System.out.println("buscado <--");
		return buscado;
	}

	private PortaSwitch buscarEnc(String macAddress) {
		System.out.println("Switch.buscarEnc(String macAddress)");

		System.out.println("Switch -> this.tabEnc.get(macAddress)");
		PortaSwitch buscado = this.tabEnc.get(macAddress);
		
		System.out.println("buscado <-- ");
		return buscado;
	}

	public Queue<Pacote> getFila() {
		System.out.println("Queue<Pacote> Switch.getFila()");
		return fila;
	}

	public void setFila(Queue<Pacote> fila) {
		System.out.println("Switch.setFila(Queue<Pacote> fila)");
		this.fila = fila;
	}

	public Map<String, String> getTabArp() {
		System.out.println("Switch.Map<String, String> getTabArp() ");
		return tabArp;
	}

	public void setTabArp(Map<String, String> tabArp) {
		System.out.println("Switch.setTabArp(Map<String, String> tabArp)");
		this.tabArp = tabArp;
	}

	public Map<String, PortaSwitch> getTabEnc() {
		System.out.println("Switch.Map<String, PortaSwitch> getTabEnc()");
		return tabEnc;
	}

	public void setTabEnc(Map<String, PortaSwitch> tabEnc) {
		System.out.println("Switch.setTabEnc(Map<String, PortaSwitch> tabEnc)");
		this.tabEnc = tabEnc;
	}

	public List<PortaSwitch> getPorts() {
		System.out.println("List<PortaSwitch> Switch.getPorts()");
		return ports;
	}

	public void setPorts(List<PortaSwitch> ports) {
		this.ports = ports;
		System.out.println("Switch.setPorts(List<PortaSwitch> ports)");
	}
}
