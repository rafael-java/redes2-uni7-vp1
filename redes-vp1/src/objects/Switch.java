package objects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Switch {
	
	private Queue<Pacote> fila =  new LinkedList<Pacote>();
	// MAC, IP
	private HashMap<String, String> tabArp = new HashMap<>();
	// IP, Porta
	private HashMap<String, Porta> tabEnc = new HashMap<>();
	private List<PortaSwitch> ports;
	// Lista de Porta
	
	public Switch() {

	}
	
	private void encaminhar(Pacote pacote, Integer Porta) {
		//Enviar Pacote para PortaSwitch recebida.	
	}
	
	private void broadcast(Pacote pacote) {
		// Enviar para todas as Portas do Switch o Pacote, Executando um Flooding na rede, Lembrando que 
		// nao espera-se resposta de ninguem.
	}
	
	private String buscarARP(String ip) {
		return null;
//		String buscado = this.TabArp.get(ip);
//		
//		return buscado;
	}
	
	private Porta buscarEnc(String macAddress) {
		
//		Porta buscado = this.TabEnc.get(macAddress);
//		
//		return buscado;
		
		return null;
	}
	
	public PortaSwitch getPrimeiraPortaDesconectada() {
		PortaSwitch portaReturned = null;
		for(PortaSwitch porta : this.ports) {
			if(!porta.getLigado()) {
				portaReturned = porta;
				break;
			}
		}
		return portaReturned;
	}
	
	public void receber(Pacote pacote) {
		// 1. Adiciona na Tabela Enc e Tabela Arp, respectivamente o Mac Address/Porta e Ip/Mac Address
		// 2. caso seja FFF no mac Destino, verifica-se na Tabela Arp caso nao verifica-se na Tabela Enc
		// 3. Apos verificar-se na tabela, caso esteja na tabela executa o encaminhamento caso nao executa BroadCast
	}

	public Queue<Pacote> getFila() {
		return fila;
	}

	public void setFila(Queue<Pacote> fila) {
		this.fila = fila;
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

	public List<PortaSwitch> getPorts() {
		return ports;
	}

	public void setPorts(List<PortaSwitch> ports) {
		this.ports = ports;
	}
}
