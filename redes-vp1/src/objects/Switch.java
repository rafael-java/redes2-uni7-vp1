package objects;

import java.util.LinkedList;
import java.util.Queue;

public class Switch {
	
	private Queue<Pacote> fila =  new LinkedList<>();
	// Lista de Porta
	
	private void encaminhar(Pacote pacote, Integer Porta) {
		//Enviar Pacote para PortaSwitch recebida.	
	}
	
	private void broadcast(Pacote pacote) {
		// Enviar para todas as Portas do Switch o Pacote, Executando um Flooding na rede, Lembrando que 
		// nao espera-se resposta de ninguem.
	}
	
	private Integer Buscar(String MacAddrss) {
		//
		return 0;
	}
	
	public void receber(Pacote pacote) {
		// 1. Adiciona na Tabela Enc e Tabela Arp, respectivamente o Mac Address/Porta e Ip/Mac Address
		// 2. caso seja FFF no mac Destino, verifica-se na Tabela Arp caso nao verifica-se na Tabela Enc
		// 3. Apos verificar-se na tabela, caso esteja na tabela executa o encaminhamento caso nao executa BroadCast
	}
}
