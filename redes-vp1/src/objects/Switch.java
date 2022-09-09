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
	}

	private void encaminhar(Pacote pacote, PortaSwitch Porta) {
		// Enviar Pacote para PortaSwitch recebida.
		Porta.enviar(pacote);
	}

	private void broadcast(Pacote pacote) {
		// Enviar para todas as Portas do Switch o Pacote, Executando um Flooding na
		// rede, Lembrando que
		// nao espera-se resposta de ninguem.

		for (PortaSwitch portaSwitch : this.getPorts()) {
			if(portaSwitch.getCabo() != null) {
				this.encaminhar(pacote, portaSwitch);
			}
			
		}
	}

	private String buscarARP(String ip) {

		String buscado = this.tabArp.get(ip);
		return buscado;
	}

	private PortaSwitch buscarEnc(String macAddress) {

		PortaSwitch buscado = this.tabEnc.get(macAddress);
		return buscado;
	}

	public PortaSwitch getPrimeiraPortaDesconectada() throws NullPointerException {
		PortaSwitch portaReturned = null;
		for (PortaSwitch porta : this.ports) {
			if (!porta.getLigado()) {
				portaReturned = porta;
				break;
			}
		}

		if (portaReturned != null) {
			return portaReturned;
		} else {
			throw new NullPointerException();
		}

	}

	public void receber(Pacote pacote, PortaSwitch portaSwitch) {
		// ENC - IP, Porta
		// ARP - MAC, IP
		// 1. Adiciona na Tabela Enc e Tabela Arp, respectivamente o Mac Address/Porta e
		// Ip/Mac Address
		this.tabEnc.put(pacote.getMacOrigem(), portaSwitch);
		this.tabArp.put(pacote.getIpOrigem(),pacote.getMacOrigem());

		// 2. caso seja FFF no mac Destino, verifica-se na Tabela Arp caso nao
		// verifica-se na Tabela Enc
		// 3. Apos verificar-se na tabela, caso esteja na tabela executa o
		// encaminhamento caso nao executa BroadCast
		if (pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF")) {
			this.broadcast(pacote);
		} else {
			String macDes = this.buscarARP(pacote.getIpDestino());

			if (macDes == null) {
				this.broadcast(pacote);
			} else {
				PortaSwitch porta = this.buscarEnc(macDes);
				this.encaminhar(pacote, porta);
			}
		}
	}

	public Queue<Pacote> getFila() {
		return fila;
	}

	public void setFila(Queue<Pacote> fila) {
		this.fila = fila;
	}

	public Map<String, String> getTabArp() {
		return tabArp;
	}

	public void setTabArp(Map<String, String> tabArp) {
		this.tabArp = tabArp;
	}

	public Map<String, PortaSwitch> getTabEnc() {
		return tabEnc;
	}

	public void setTabEnc(Map<String, PortaSwitch> tabEnc) {
		this.tabEnc = tabEnc;
	}

	public List<PortaSwitch> getPorts() {
		return ports;
	}

	public void setPorts(List<PortaSwitch> ports) {
		this.ports = ports;
	}
}
