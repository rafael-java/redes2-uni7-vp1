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

	public PortaSwitch getPrimeiraPortaDesconectada() {
		System.out.println("Obtendo primeira porta desconectada, do switch...");

		for (PortaSwitch porta : this.ports) {
			if (!porta.getLigado()) {
				return porta;
			}
		}
		
		return null;
	}

	public void receber(Pacote pacote, PortaSwitch portaSwitch) {
		System.out.println("Switch recebendo...");

		// ENC - IP, Porta
		// ARP - MAC, IP
		// 1. Adiciona na Tabela Enc e Tabela Arp, respectivamente o Mac Address/Porta e
		// Ip/Mac Address
		System.out.println("Colocando na ENC table os dados do \"acusado\", caso já não estejam...");
		this.tabEnc.put(pacote.getMacOrigem(), portaSwitch);

		System.out.println("Colocando na ARP table os dados do \"acusado\", caso já não estejam...");
		this.tabArp.put(pacote.getIpOrigem(), pacote.getMacOrigem());

		// 2. caso seja FFF no mac Destino, verifica-se na Tabela Arp caso nao
		// verifica-se na Tabela Enc
		// 3. Apos verificar-se na tabela, caso esteja na tabela executa o
		// encaminhamento caso nao executa BroadCast
		if (pacote.getMacDestino().equals("FF:FF:FF:FF:FF:FF")) {
			System.out.println("O pacote tem Mac Destino igual a FF.FF.FF.FF.FF.FF...");
			this.broadcast(pacote);
		} else {
			System.out.println("O pacote tem Mac Destino diferente de FF.FF.FF.FF.FF.FF...");
			String macDes = this.buscarARP(pacote.getIpDestino());

			PortaSwitch porta = this.buscarEnc(macDes);

			if (porta == null) {
				System.out.println("Não localizou a porta na tabela ENC...");
				this.broadcast(pacote);
			}

			else {
				System.out.println("Localizou a porta na tabela ENC...");
				this.encaminhar(pacote, porta);
			}

//			}
		}
	}

	private void encaminhar(Pacote pacote, PortaSwitch Porta) {
		System.out.println("");
		System.out.println("Switch encaminhando o pacote para a (próxima) porta switch...");

		Porta.enviar(pacote);
	}

	private void broadcast(Pacote pacote) {
		System.out.println("Iniciando broadcast para todas as portas...");

		// Enviar para todas as Portas do Switch o Pacote, Executando um Flooding na
		// rede, Lembrando que
		// nao espera-se resposta de ninguem.

		for (PortaSwitch portaSwitch : this.getPorts()) {
			if (portaSwitch.getCabo() != null) {
				this.encaminhar(pacote, portaSwitch);
			}

		}
	}

	private String buscarARP(String ip) {
		System.out.println("Buscando na tabela ARP do switch...");

		return this.tabArp.get(ip);
	}

	private PortaSwitch buscarEnc(String macAddress) {
		System.out.println("Buscando na tabela ENC do switch...");

		return this.tabEnc.get(macAddress);
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
		System.out.println("Setando portas no switch...");
	}
}
