package objects;
import objects.Pacote;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Host {
	private String MacAddress;
	private String Ip;
	private HashMap<String, String> TabArp = new HashMap<>();;
	private HashMap<String, Porta> TabEnc = new HashMap<>();
	private PortaHost porta;
	
	private Queue<Pacote> fila =  new LinkedList<>();
	
	public Host(String macAddress, String ip) {
		super();
		MacAddress = macAddress;
		Ip = ip;
	}

	public void enviar(String Ip, String dados) {
		Pacote pkg = new Pacote(this.MacAddress, this.Ip, Ip, dados);
		String macDestino = buscarARP(Ip);
		if(macDestino != null) {
			pkg.setMacDestino(macDestino);
			this.porta.enviar(pkg);
		} else {
			Pacote arpPkg = new Pacote(this.MacAddress, this.Ip, "FF:FF:FF:FF:FF:FF", Ip, "Request");
			fila.add(pkg); // Adiciona na Fila o Pacote para que fique na espera de um ArpReply
			this.porta.enviar(arpPkg);
			
		}
		
	}
	
	public void receber(Pacote pacote) {
		// Ao Receber o ArpReply Reenviar todas os Pacotes na Fila. 
	}
	
	public void atrelar(PortaHost porta) {
		this.porta=porta;
	}
	
	private String buscarARP(String ip) {
		
		String buscado = this.TabArp.get(ip);
		
		return buscado;
	}
	
	private Porta buscarEnc(String macAddress) {
		
		Porta buscado = this.TabEnc.get(macAddress);
		
		return buscado;
	}
	
}
