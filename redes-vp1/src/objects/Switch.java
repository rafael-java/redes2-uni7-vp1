package objects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Switch {
	
	private Queue<Pacote> fila =  new LinkedList<>();
	private HashMap<String, String> TabArp = new HashMap<>();;
	private HashMap<String, Porta> TabEnc = new HashMap<>();
	private List<PortaSwitch> ports;
	// Lista de Porta
	
	private void encaminhar(Pacote pacote, Integer Porta) {
		//Enviar Pacote para PortaSwitch recebida.	
	}
	
	private void broadcast(Pacote pacote) {
		// Enviar para todas as Portas do Switch o Pacote, Executando um Flooding na rede, Lembrando que 
		// nao espera-se resposta de ninguem.
	}
	
	private String buscarARP(String ip) {
		
		String buscado = this.TabArp.get(ip);
		
		return buscado;
	}
	
	private Porta buscarEnc(String macAddress) {
		
		Porta buscado = this.TabEnc.get(macAddress);
		
		return buscado;
	}
	
	private Porta getPrimeiraPortaDesconectada() {
		Porta portaReturned = null;
		for(Porta porta : this.ports) {
			if(!porta.ligado) {
				portaReturned=porta;
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
}
